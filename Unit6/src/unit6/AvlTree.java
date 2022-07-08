
package unit6;

public class AvlTree<T extends Comparable<T>>{
    AvlNode root;
    private static final int ALLOWED_IMBALANCE = 1;
    
    public AvlTree() {
        this.root = null;
    }
    
    //HELPER METHODS
    
    private void updateHeight(AvlNode n) {
       n.height = Math.max(height(n.left), height(n.right)) + 1; //whichever child height is higher, and add one for the root node
    }

    private int height(AvlNode n) {
        return n == null ? -1 : n.height;
    }
    /*
    private int balanceDiff(AvlNode n) {
        if (n != null) {
            return this.height(n.left) - this.height(n.right); //> 1 means left heavy, < -1 means right heavy
        } else {
            //return -1;
            return 0;
        }
        //return (n == null) ? 0 : height(n.left) - height(n.right);
    }
    */
    int getBalance(AvlNode n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }
    
    //MIN AND MAX (public then private method)
    public AvlNode findMin() {
        return this.findMin(this.root);
    }

    private AvlNode findMin(AvlNode n) {
        if (n.left == null) { //nothing to the left/smaller, return this node
            return n    ;
        } else {
            return this.findMin(n.left); //keep reccuring to the left for min value
        }
    }

    public AvlNode findMax() {
        return this.findMax(this.root);
    }

    private AvlNode findMax(AvlNode n) {
        if (n.right == null) { //nothing to the right/bigger, return this node
            return n;
        } else {
            return this.findMax(n.right); //keep reccuring to the right for max value
        }
    }

    //ROTATION AND BALANCE (public then private method)
    /*public void rotateR(){
        this.root = this.rotateR(this.root);
    }*/
    
    private AvlNode rotateR(AvlNode n) { //the imbalance begins at Node n and is left heavy
        AvlNode x = n.left;
        AvlNode y = x.right;
        x.right = n;
        n.left = y;
        updateHeight(n);
        updateHeight(x);
        return x;
    }

    /*public void rotateL() {
        this.root = this.rotateL(this.root);
    }
    */
    
    
    private AvlNode rotateL(AvlNode n) { //the imbalance begins at Node n and is left heavy //works opposite as rotateR
        AvlNode x = n.right;
        AvlNode y = x.left;
        x.left = n;
        n.right = y;
        updateHeight(n);
        updateHeight(x);
        return x;
    }
    
    
    private AvlNode rebalance(AvlNode z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance < -1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateL(z);
            } else {
                z.right = rotateR(z.right);
                z = rotateL(z);
            }
        } else if (balance > 1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateR(z);
            } else {
                z.left = rotateL(z.left);
                z = rotateR(z);
            }
        }
        return z;
    }


    //INSERT AND REMOVE (public then private method)
    public void insert(T data) {
        this.root = this.insert(data, this.root);
    }

    private AvlNode insert(T data, AvlNode n) {
        if (n == null) {
            return new AvlNode(data);
        } else if (data.compareTo((T) n.data) < 0) { //traverse left
            n.left = insert(data, n.left); //keep traversing to the left
        } else if (data.compareTo((T) n.data) > 0) { //traverse right
            n.right = insert(data, n.right); //keep traversing to the right
        } else if (data.compareTo((T) n.data) == 0){ //if it already exists
            n.count++;
            return n;
        } 
        
        updateHeight(n);
        /*
        int factor = balanceDiff(n);
        // If this node becomes unbalanced, then there are 4 cases Left Left Case
        if (factor > 1 && data.compareTo((T)n.left.data) < 0) {
            return rotateR(n);
        }

        // Right Right Case
        if (factor < -1 && data.compareTo((T) n.right.data) > 0) {
            return rotateL(n);
        }

        // Left Right Case
        if (factor > 1 && data.compareTo((T) n.left.data) > 0) {
            n.left = rotateL(n.left);
            return rotateR(n);
        }

        // Right Left Case
        if (factor < -1 && data.compareTo((T) n.right.data) < 0) {
            n.right = rotateR(n.right);
            return rotateL(n);
        }

        // return the (unchanged) node pointer 
        return n;
       */
        return rebalance(n); //if data already exists in a node in the tree, leave the tree unchanged. Otherwise balance and return the root
    }
    
    public void remove(T data){
        this.root = this.remove(data, this.root);
    }
    
    private AvlNode remove(T data, AvlNode n){
        if (n == null) { //the tree is empty, return the null node n
            return n;
        }
        if (data.compareTo((T) n.data) < 0) { //going to the left
            n.left = this.remove(data, n.left); //since not found, recur down tree
        } else if (data.compareTo((T) n.data) > 0) { //going to the right
            n.right = this.remove(data, n.right); //since not found, recur down tree
        } else {
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
                } else { // One child case
                    n = temp; // Copy the contents of the non-empty child
                }                               
            } else {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                AvlNode temp = findMin(n.right);

                // Copy the inorder successor's data to this node
                n.data = temp.data;

                // Delete the inorder successor
                n.right = remove((T) temp.data, n.right);
            }
        }
        // If the tree had only one node then return
        if (n == null) {
            return n;
        }

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        n.height = Math.max(height(n.left), height(n.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(n);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(n.left) >= 0) {
            return rotateR(n);
        }

        // Left Right Case
        if (balance > 1 && getBalance(n.left) < 0) {
            n.left = rotateL(n.left);
            return rotateR(n);
        }

        // Right Right Case
        if (balance < -1 && getBalance(n.right) <= 0) {
            return rotateL(n);
        }

        // Right Left Case
        if (balance < -1 && getBalance(n.right) > 0) {
            n.right = rotateR(n.right);
            return rotateL(n);
        }

        //return root;
        return n;
    }
   
    public void printTree() {
        System.out.println("root="+this.root.data);
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
