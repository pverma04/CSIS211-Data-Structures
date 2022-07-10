
package unit6.pkg1;

public class AvlTree <T extends Comparable<T>> {
    AvlNode root;
    
    private int height (AvlNode n) {
        return (n == null) ? 0 : n.height;
    }
    
    private void updateHeight(AvlNode n) {
        n.height = Math.max(height(n.left), height(n.right)) +1; //max of right and left is the height (add one to account for the root node as well)
    }
    
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
    private AvlNode rightRotate(AvlNode a) {
        AvlNode b = a.left; //to become the new root
        AvlNode subT = b.right; //everything to follow (T2 will represent the "root") that will be carried in the same position
        b.right = a; //switching
        a.left = subT; //switching
        a.height = max(height(a.left), height(a.right)) + 1;
        b.height = max(height(b.left), height(b.right)) + 1;

        return b; //the new root
    }
    
    private AvlNode leftRotate(AvlNode a) {
        AvlNode b = a.right; //to become the new root
        AvlNode T2 = b.left; //everything to follow (T2 will represent the "root") that will be carried in the same position
        b.left = a; //switching
        a.right = T2; //switching
        a.height = max(height(a.left), height(a.right)) + 1;
        b.height = max(height(b.left), height(b.right)) + 1;

        return b; //the new root
    }
    
    private int getBalance(AvlNode n) {
        return (n == null) ? 0 : height(n.left) - height(n.right); //left - right for height
    }
    
    public void insert(T data) {
        this.root = this.insert(this.root, data);
    }
    
    private AvlNode insert(AvlNode n, T data) {
        if (n == null) { //new AvlNode is the only node in the list, just retunn that as the root
            return (new AvlNode(data));
        } else if (data.compareTo((T) n.data) < 0) { //going to the left
            n.left = insert(n.left, data); //recurse
        } else if (data.compareTo((T) n.data) > 0) { //going to the right
            n.right = insert(n.right, data); //recurse
        } else { //if the data already exists in an AvlNode, don't add it. Return the original root, but update the count of the node
            n.count++;
            return n;
        }
        updateHeight(n);
        
        int bal = getBalance(n);
        
        if (bal > 1 && data.compareTo((T) n.left.data) < 0) { //left case
            return rightRotate(n);
        } if (bal < -1 && data.compareTo((T) n.right.data) > 0) { //right case
            return leftRotate(n);
        } if (bal > 1 && data.compareTo((T) n.left.data) > 0) { //left-right case
            n.left = leftRotate(n.left);
            return rightRotate(n);
        } if (bal < -1 && data.compareTo((T) n.right.data) < 0) { //right-left case
            n.right = rightRotate(n.right);
            return leftRotate(n);
        } else { //if tree was already balanced
            return n;
        }
    }
    
    private AvlNode minValueNode(AvlNode n) {
        AvlNode r = n; //reference node
        while (r.left != null) { //traverse left side to find smallest data
            r = r.left;
        }
        return r;
    }
    
    private AvlNode maxValueNode(AvlNode n) {
        AvlNode r = n; //reference node

        while (r.right != null) { //traverse right side to find greatest data
            r = r.right;
        }
        return r;
    }
    
    public void deleteNode(T data) {
        this.root = this.deleteNode(this.root, data);
    }
    
    private AvlNode deleteNode(AvlNode n, T data) {
        if (n == null) { //if null then empty tree, return null
            return n;
        } else if (data.compareTo((T) n.data) < 0) { //go down left side
            n.left = deleteNode(n.left, data);
        } else if (data.compareTo((T) n.data) > 0) { //go down right side
            n.right = deleteNode(n.right, data);
        } else { //if not greater or less than data, we have found the node to be deleted
            if ((n.left == null) || (n.right == null)) { //one or no children
                AvlNode temp = null;

                if (temp == n.left) { //determine node to hold as temp
                    temp = n.right;
                } else {
                    temp = n.left;
                }

                if (temp == null) { //if no children
                    temp = n;
                    n = null;
                } else { //for one child case, set root node = temp
                    n = temp;
                }
            } else { //2 children
                AvlNode temp = minValueNode(n.right);
                n.data = temp.data;
                n.right = deleteNode(n.right, (T) temp.data);
            }
        }

        if (n == null) { //if tree root was null, there is nothing to delete (root stays null and unchanged)
            return n;
        }

        updateHeight(n);
        int bal = getBalance(n);

        if (bal > 1 && getBalance(n.left) >= 0) { //left case
            return rightRotate(n);
        }
        if (bal < -1 && getBalance(n.right) <= 0) { //right case
            return leftRotate(n);
        }
        if (bal > 1 && getBalance(n.left) < 0) { //left-right case
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }
        if (bal < -1 && getBalance(n.right) > 0) { //right-right case
            n.right = rightRotate(n.right);
            return leftRotate(n);
        } else { //if tree is balanced already
            return n;
        }
    }
    
    public void printTree() {
        System.out.println("root = " + this.root.data);
        this.printTree(this.root);
    }

    private void printTree(AvlNode n) {
        if (n != null) { //if tree isnt empty
            System.out.println(n.data);
            /* print with additional funcationality
            System.out.println(n.data + " count " + n.count + " height " + n.height + " left: " + (n.left == null ? "null" : n.left.data) + " right: " + (n.right == null ? "null" : n.right.data));
            */
            this.printTree(n.left); //traverse through left
            this.printTree(n.right); //traverse through right
        }
    }
    
    public boolean contains(AvlNode n, T data) {
        if (n != null) {
            while(n != null) {
                if (data.compareTo((T) n.data) > 0) { //data is less than current n.data
                    n = n.right;
                } else if (data.compareTo((T) n.data) < 0) { //data is greater than current n.data
                    n = n.left;
                } else { //data is equal to current n.data
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isTreeEmpty() {
        return this.root == null;
    }
    
    public void makeEmpty() {
        this.root = null;
    }
    
}
