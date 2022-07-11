/**
 * ***********************************************
 * File: SearchTree.java
 * Author: Parth Verma
 * Description: This file contains code for the Binary Search tree (uses Node)
 * Date: July 10, 2022
 * ***********************************************
 */
package unit6.pkg1;

public class SearchTree<T extends Comparable<T>> {

    Node root;

    public SearchTree() {
        this.root = null;
    }

    public SearchTree(Node root) {
        this.root = root;
    }

    /**
     * ***********************************************
     * @par Name insert
     * @purpose Calls the private insert method to add data to the tree
     * @param [in] : T data
     * @return Void***********************************************
     */
    public void insert(T data) {
        this.insert(data, this.root);
    }

    /**
     * ***********************************************
     * @par Name insert
     * @purpose Traverses through the tree given its root node, to insert the
     * given data as a new node into the correct position
     * @param [in] : T data, Node n
     * @return Node (root node of tree with added
     * data)***********************************************
     */
    private Node insert(T data, Node n) {
        Node insertNode = new Node(data);
        if (this.root == null) {
            this.root = insertNode;
        } else if (data.compareTo((T) n.mData) < 0) { //going to the left
            if (n.mLeft == null) {
                n.mLeft = insertNode;
            } else {
                insert(data, n.mLeft);
            }
        } else if (data.compareTo((T) n.mData) > 0) { //going to the right
            if (n.mRight == null) {
                n.mRight = insertNode;
            } else {
                insert(data, n.mRight);
            }
        }
        return (n);
    }

    /**
     * ***********************************************
     * @par Name findMinNode
     * @purpose Calls the private method to find the Node with the smallest data
     * @param [in] : None
     * @return Node (node with smallest
     * data)***********************************************
     */
    public Node findMinNode() {
        return this.findMinNode(this.root);
    }

    /**
     * ***********************************************
     * @par Name findMinNode
     * @purpose Traverses down the left side of the tree to find the node with 
     * the smallest data in the tree given its root
     * @param [in] : Node n
     * @return Node (node with smallest
     * data)***********************************************
     */
    private Node findMinNode(Node n) {
        if (n.mLeft == null) { //nothing to the left/smaller, return this node
            return n;
        } else {
            return this.findMinNode(n.mLeft); //keep reccuring to the left for min value
        }
    }

    /**
     * ***********************************************
     * @par Name findMaxNode
     * @purpose Calls the private method to find the Node with the largest data
     * @param [in] : None
     * @return Node (node with largest
     * data)***********************************************
     */
    public Node findMaxNode() {
        return this.findMaxNode(this.root);
    }
    
    /**
     * ***********************************************
     * @par Name findMaxNode
     * @purpose Traverses down the right side of the tree to find the node with
     * the largest data in the tree given its root
     * @param [in] : Node n
     * @return Node (node with largest
     * data)***********************************************
     */
    private Node findMaxNode(Node n) {
        if (n.mRight == null) { //nothing to the right/bigger, return this node
            return n;
        } else {
            return this.findMaxNode(n.mRight); //keep reccuring to the right for max value
        }
    }

    /**
     * ***********************************************
     * @par Name remove
     * @purpose Uses the private method to remove the node with the given data 
     * from the tree
     * @param [in] : T data
     * @return Void***********************************************
     */
    public void remove(T data) {
        this.remove(data, this.root);
    }

    /**
     * ***********************************************
     * @par Name remove
     * @purpose Traverses through the tree to find and remove the node 
     * containing data that matches the given data
     * @param [in] : T data, Node n
     * @return Node (root node with removed node)***********************************************
     */
    private Node remove(T data, Node n) {
        if (n == null) { //the tree is empty, return the null node n
            return n;
        }
        if (data.compareTo((T) n.mData) < 0) { //going to the left
            n.mLeft = this.remove(data, n.mLeft); //since not found, recur down tree
        } else if (data.compareTo((T) n.mData) > 0) { //going to the right
            n.mRight = this.remove(data, n.mRight); //since not found, recur down tree
        } else if (n.mLeft != null && n.mRight != null) {
            n.mData = (T) findMinNode(n.mRight).mData;
            remove((T) n.mData, n.mRight); //continue traversing
        } else { //if data is not greater or less than n.mData, delete this node
            n = (n.mLeft != null) ? n.mLeft : n.mRight;
        }
        return n;
    }

    /**
     * ***********************************************
     * @par Name contains
     * @purpose Uses the private method to determine whether the given data is 
     * found in a node in the tree
     * @param [in] : T data
     * @return Boolean***********************************************
     */
    public boolean contains(T data) {
        return this.contains(data, this.root);
    }

    /**
     * ***********************************************
     * @par Name contains
     * @purpose Traverses through the tree to determine whether the given data
     * is found in a node in the tree given its root node
     * @param [in] : T data, Node n
     * @return Boolean***********************************************
     */
    private boolean contains(T data, Node n) {
        if (n == null) { //if empty, nothing in tree
            return false;
        } else if (data.compareTo((T) n.mData) < 0) { //to the left
            return contains(data, n.mLeft);
        } else if (data.compareTo((T) n.mData) > 0) { //to the right
            return contains(data, n.mRight);
        } else { //data has been found
            return true;
        }
    }

    /**
     * ***********************************************
     * @par Name isEmpty
     * @purpose A helper method to determine whether the tree is populated or
     * empty
     * @param [in] : None
     * @return Boolean***********************************************
     */
    public boolean isEmpty() {
        return (this.root == null);
    }

    /**
     * ***********************************************
     * @par Name printTree
     * @purpose Uses the private method to print out contents of the tree
     * @param [in] : None
     * @return Void***********************************************
     */
    public void printTree() {
        this.printTree(this.root);
    }

    /**
     * ***********************************************
     * @par Name printTree
     * @purpose Traverses through the tree given its root node to print out the
     * contents of the tree
     * @param [in] : Node n
     * @return Void***********************************************
     */
    private void printTree(Node n) {
        if (n != null) { //if tree isnt empty
            //System.out.println(n.mData + " left: " + (n.mLeft == null ? "null" : n.mLeft.mData) + " right: " + (n.mRight == null ? "null" : n.mRight.mData));
            //System.out.println("-------------------");
            
            System.out.println(n.mData);
            this.printTree(n.mLeft); //traverse through left
            this.printTree(n.mRight); //traverse through right
        }
    }
}
