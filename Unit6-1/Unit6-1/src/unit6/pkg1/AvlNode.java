/**
 * ***********************************************
 * File: AvLNode.java
 * Author: Parth Verma
 * Description: This file contains code for the AvlNode 
 * specifically used in AVL Tree for the count and height attributes
 * Date: July 10, 2022
 * ***********************************************
 */
package unit6.pkg1;

public class AvlNode<T> {
    T mData;
    int mCount;
    int mHeight;
    AvlNode mLeft, mRight;

    AvlNode(T d) {
        this.mData = d;
        this.mHeight = 1;
        this.mCount = 1;
    }
}
