
package unit6;

public class SearchTree<T extends Comparable<T>> {
    Node root;
    
    public SearchTree(){
        this(null);
    }
    
    public SearchTree(Node root){
        this.root = root;
    }
    
    
    protected void updateHeight(Node n) {
        int lCHeight = this.height(n.left); //height of left CHILD
        int rCHeight = this.height(n.right); //height of right CHILD
        n.height = Math.max(lCHeight, rCHeight) + 1; //whichever child height is higher, and add one for the root node
    }

    protected int height(Node n) {
        return n == null ? -1 : n.height;
    }
    
    
    public void insert(T data) {
        this.root = this.insert(data, this.root);
    }

    private Node insert(T data, Node n) {

        if (n == null) {
            n = new Node(data);
        } else if (data.compareTo((T) n.data) < 0) { //traverse left
            n.left = insert(data, n.left); //keep traversing to the left
        } else if (data.compareTo((T) n.data) > 0) { //traverse right
            n.right = insert(data, n.right); //keep traversing to the right
        } else if (data.compareTo((T) n.data) == 0) { //if it already exists
            n.count++;
        }

        //n = this.insert(data, this.root);
        updateHeight(n);
        return (n); //if data already exists in a node in the tree, leave the tree unchanged. Otherwise balance and return the root
    }
    
    public T findMin() {
        return (T) this.findMin(this.root);
    }

    private T findMin(Node n){
        if (n.left == null) { //nothing to the left/smaller, return this node
            return (T) n.data;
        } else {
            return this.findMin(n.left); //keep reccuring to the left for min value
        }
    }
    
    public T findMax() {
        return (T) this.findMin(this.root);
    }

    private T findMax(Node n) {
        if (n.right == null) { //nothing to the right/bigger, return this node
            return (T) n.data;
        } else {
            return this.findMin(n.right); //keep reccuring to the right for max value
        }
    }
    
    public void remove(T data) {
        this.remove(data, this.root);
    }

    private Node remove(T data, Node n){
        if (n == null) { //the tree is empty, return the null node n
            return n;
        }
        if (data.compareTo((T) n.data) < 0) { //going to the left
            n.left = this.remove(data, n.left); //since not found, recur down tree
        } else if (data.compareTo((T) n.data) > 0) { //going to the right
            n.right = this.remove(data, n.right); //since not found, recur down tree
        } else if (n.left != null && n.right != null) {
            n.data = findMin(n.right);
            remove((T) n.data, n.right); //continue traversing
        } else { //if data is not greater or less than n.data, delete this node
            n = (n.left != null) ? n.left : n.right;
        }
        return n;
    }
    
    public boolean contains(T data){
        return this.contains(data, this.root);
    }
    
    private boolean contains(T data, Node n) {
        if (n == null) { //if empty, nothing in tree
            return false;
        } else if (data.compareTo((T) n.data) < 0) { //to the left
            return contains(data, n.left);
        } else if (data.compareTo((T) n.data) > 0) { //to the right
            return contains(data, n.right);
        } else { //data has been found
            return true;
        }
    }
    
    public boolean isEmpty(){
        return (this.root == null);
    }
    
    public void printTree(){
        this.printTree(this.root);
    }
    
    private void printTree(Node n){
        if (n != null) { //if tree isnt empty
            System.out.println(n.data + " count: " + n.count + " height: " + n.height);
            this.printTree(n.left); //traverse through left
            this.printTree(n.right); //traverse through right
        }
    }
}
