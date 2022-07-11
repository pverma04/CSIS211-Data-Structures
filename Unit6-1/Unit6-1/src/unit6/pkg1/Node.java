/**
 * ***********************************************
 * File: Node.java
 * Author: Parth Verma
 * Description: This file contains code for the Node 
 * specifically used in Binary Search Tree
 * Date: July 10, 2022
 * ***********************************************
 */
package unit6.pkg1;

public class Node<T> {

    T mData;

    Node mLeft;
    Node mRight;

    public Node() {
        this(null);
    }

    public Node(T data) {
        this.mData = data;
    }
}
