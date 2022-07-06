
package unit6;

public class AvlTree<T extends Comparable<T>>{
    AvlNode root;
    private static final int ALLOWED_IMBALANCE = 1;
    
    public AvlTree() {
        this.root = null;
    }
    
    //HELPER METHODS
    
    private void updateHeight(AvlNode n) {
        int lCHeight = this.height(n.left); //height of left CHILD
        int rCHeight = this.height(n.right); //height of right CHILD
        n.height = Math.max(lCHeight, rCHeight) + 1; //whichever child height is higher, and add one for the root node
    }

    private int height(AvlNode n) {
        return n == null ? -1 : n.height;
    }

    private int balanceDiff(AvlNode n) {
        return this.height(n.left) - this.height(n.right); //> 1 means left heavy, < -1 means right heavy
    }
    
    //MIN AND MAX (public then private method)
    public T findMin() {
        return (T) this.findMin(this.root);
    }

    private T findMin(AvlNode n) {
        if (n.left == null) { //nothing to the left/smaller, return this node
            return (T) n.data;
        } else {
            return this.findMin(n.left); //keep reccuring to the left for min value
        }
    }

    public T findMax() {
        return (T) this.findMin(this.root);
    }

    private T findMax(AvlNode n) {
        if (n.right == null) { //nothing to the right/bigger, return this node
            return (T) n.data;
        } else {
            return this.findMin(n.right); //keep reccuring to the right for max value
        }
    }

    //ROTATION AND BALANCE (public then private method)
    public void rotateR(){
        this.root = this.rotateR(this.root);
    }
    
    private AvlNode rotateR(AvlNode n) { //the imbalance begins at Node n and is left heavy
        AvlNode lChild = n.left;

        n.left = lChild.right;
        lChild.right = n; //sets lChild as the root

        this.updateHeight(n);
        this.updateHeight(lChild);

        return lChild; //after rotation returns the root
    }

    public void rotateL() {
        this.root = this.rotateL(this.root);
    }
    
    private AvlNode rotateL(AvlNode n) { //the imbalance begins at Node n and is left heavy //works opposite as rotateR
        AvlNode rChild = n.right;

        n.right = rChild.left;
        rChild.left = n; //sets lChild as the root

        this.updateHeight(n);
        this.updateHeight(rChild);

        return rChild; //after rotation returns the root
    }
    
    public void balance(){
        this.root = this.balance(this.root);
    }
    
    private AvlNode balance(AvlNode n) {
        int factor = balanceDiff(n);
        
        if(factor > 1){ //left heavy
            if(balanceDiff(n.left) < -1){ //n.left is right heavy
                n.left = rotateL(n.left);
                n = rotateR(n);
            }
            else{ //regular rotation
                n = rotateR(n); //left heavy, rotate to the right
            }
        }
        else if (factor < -1) { //right heavy
            if (balanceDiff(n.right) > 1) { //n.right is left heavy
                n.right = rotateR(n.right);
                n = rotateL(n);
            } else { //regular rotation
                n = rotateL(n); //right heavy, rotate to the left
            }
        }
        return n;
    }
    
    //INSERT AND REMOVE (public then private method)
    public void insert(T data) {
        this.root = this.insert(data, this.root);
    }

    private AvlNode insert(T data, AvlNode n) {
        if (n == null) {
            n = new AvlNode(data, null, null);
        } else if (data.compareTo((T) n.data) < 0) { //traverse left
            n.left = insert(data, n.left); //keep traversing to the left
        } else if (data.compareTo((T) n.data) > 0) { //traverse right
            n.right = insert(data, n.right); //keep traversing to the right
        }
        updateHeight(n);
        return balance(n); //if data already exists in a node in the tree, leave the tree unchanged. Otherwise balance and return the root
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
        } else if (n.left != null && n.right != null) { //n has now been set to the node that needs to be deleted, or there it doesn't exist
            n.data = findMin(n.right);
            remove((T) n.data, n.right); //continue traversing
        } else { //if data is not greater or less than n.data, delete this node
            n = (n.left != null) ? n.left : n.right;
        }
        
        if (n == null) { //if data wasn't found, n is null
            return null;
        }
        this.updateHeight(n);
        return this.balance(n);
    }
   
    public void printTree() {
        this.printTree(this.root);
    }

    private void printTree(AvlNode n) {
        if (n != null) { //if tree isnt empty
            System.out.println(n.data);
            this.printTree(n.left); //traverse through left
            this.printTree(n.right); //traverse through right
        }
    }
}
