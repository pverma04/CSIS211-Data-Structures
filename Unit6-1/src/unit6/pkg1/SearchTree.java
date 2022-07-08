/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unit6.pkg1;

/**
 *
 * @author parthverma
 */
public class SearchTree<T extends Comparable<T>> {

    Node root;

    public SearchTree() {
        this.root = null;
    }

    public SearchTree(Node root) {
        this.root = root;
    }

    public void insert(T data) {
        this.insert(data, this.root);
    }

    protected Node insert(T data, Node n) {
        Node insertNode = new Node(data);
        if (this.root == null) {
            this.root = insertNode;
        } else if (data.compareTo((T) n.data) < 0) { //going to the left
            if (n.left == null) {
                n.left = insertNode;
            } else {
                insert(data, n.left);
            }
        } else if (data.compareTo((T) n.data) > 0) { //going to the right
            if (n.right == null) {
                n.right = insertNode;
            } else {
                insert(data, n.right);
            }
        }
        return (n);
    }

    public T findMin() {
        return (T) this.findMin(this.root);
    }

    private T findMin(Node n) {
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

    private Node remove(T data, Node n) {
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

    public boolean contains(T data) {
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

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void printTree() {
        this.printTree(this.root);
    }

    private void printTree(Node n) {
        if (n != null) { //if tree isnt empty
            System.out.println(n.data + " left: " + (n.left == null ? "null" : n.left.data) + " right: " + (n.right == null ? "null" : n.right.data));

            System.out.println("-------------------");

            this.printTree(n.left); //traverse through left
            this.printTree(n.right); //traverse through right
        }
    }
}
