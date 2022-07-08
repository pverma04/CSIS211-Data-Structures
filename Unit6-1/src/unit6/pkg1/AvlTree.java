
package unit6.pkg1;

public class AvlTree <T extends Comparable<T>> {
    AvlNode root;
    
    private int height (AvlNode n) {
        return (n == null) ? 0 : n.height;
    }
    
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
    private AvlNode rightRotate(AvlNode b) {
        AvlNode a = b.left;
        AvlNode subT = a.right;

        // Perform rotation
        a.right = b;
        b.left = subT;

        // Update heights
        b.height = max(height(b.left), height(b.right)) + 1;
        a.height = max(height(a.left), height(a.right)) + 1;

        // Return new root
        return a;
    }
    
    private AvlNode leftRotate(AvlNode a) {
        AvlNode b = a.right;
        AvlNode T2 = b.left;

        // Perform rotation
        b.left = a;
        a.right = T2;

        // Update heights
        a.height = max(height(a.left), height(a.right)) + 1;
        b.height = max(height(b.left), height(b.right)) + 1;

        // Return new root
        return b;
    }
    
    private int getBalance(AvlNode n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }
    
    public AvlNode insert(AvlNode n, T data) {
        /* 1. Perform the normal BST rotation */
        if (n == null) {
            return (new AvlNode(data));
        }

        if (data.compareTo((T) n.data) < 0) {
            n.left = insert(n.left, data);
        } else if (data.compareTo((T) n.data) > 0) {
            n.right = insert(n.right, data);
        } else // Equal datas not allowed
        {
            n.count++;
            return n;
        }

        /* 2. Update height of this ancestor node */
        n.height = 1 + max(height(n.left),
                height(n.right));

        /* 3. Get the balance factor of this ancestor
        node to check whether this node became
        unbalanced */
        int treeBal = getBalance(n);

        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (treeBal > 1 && data.compareTo((T) n.left.data) < 0) {
            return rightRotate(n);
        }

        // Right Right Case
        if (treeBal < -1 && data.compareTo((T) n.right.data) > 0) {
            return leftRotate(n);
        }

        // Left Right Case
        if (treeBal > 1 && data.compareTo((T) n.left.data) > 0) {
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }

        // Right Left Case
        if (treeBal < -1 && data.compareTo((T) n.right.data) < 0) {
            n.right = rightRotate(n.right);
            return leftRotate(n);
        }

        /* return the (unchanged) node pointer */
        return n;
    }
    
    private AvlNode minValueNode(AvlNode n) {
        AvlNode current = n;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
    
    public AvlNode deleteNode(AvlNode n, T data) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (n == null) {
            return n;
        }

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (data.compareTo((T) n.data) < 0) {
            n.left = deleteNode(n.left, data);
        } // If the key to be deleted is greater than the
        // root's key, then it lies in right subtree
        else if (data.compareTo((T) n.data) > 0) {
            n.right = deleteNode(n.right, data);
        } // if key is same as root's key, then this is the node
        // to be deleted
        else {

            // node with only one child or no child
            if ((n.left == null) || (n.right == null)) {
                AvlNode temp = null;
                if (temp == n.left) {
                    temp = n.right;
                } else {
                    temp = n.left;
                }

                // No child case
                if (temp == null) {
                    temp = n;
                    n = null;
                } else // One child case
                {
                    n = temp; // Copy the contents of
                }                                // the non-empty child
            } else {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                AvlNode temp = minValueNode(n.right);

                // Copy the inorder successor's data to this node
                n.data = temp.data;

                // Delete the inorder successor
                n.right = deleteNode(n.right, (T) temp.data);
            }
        }

        // If the tree had only one node then return
        if (n == null) {
            return n;
        }

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        n.height = max(height(n.left), height(n.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(n);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(n.left) >= 0) {
            return rightRotate(n);
        }

        // Left Right Case
        if (balance > 1 && getBalance(n.left) < 0) {
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }

        // Right Right Case
        if (balance < -1 && getBalance(n.right) <= 0) {
            return leftRotate(n);
        }

        // Right Left Case
        if (balance < -1 && getBalance(n.right) > 0) {
            n.right = rightRotate(n.right);
            return leftRotate(n);
        }

        return n;
    }
    
    public void printTree() {
        System.out.println("root=" + this.root.data);
        //n.data + " count " + n.count + " height " + n.height + " left: " + (n.left == null ? "null" : n.left.data) + " right: " + (n.right == null ? "null" : n.right.data));

        this.printTree(this.root);
    }

    private void printTree(AvlNode n) {
        if (n != null) { //if tree isnt empty
            System.out.println(n.data + " count " + n.count + " height " + n.height + " left: " + (n.left == null ? "null" : n.left.data) + " right: " + (n.right == null ? "null" : n.right.data));

            this.printTree(n.left); //traverse through left
            this.printTree(n.right); //traverse through right
        }
        //System.out.println("min " + findMin(this.root));
    }
}
