/** ***********************************************
 * File: Node.java
 * Author: Parth Verma
 * Description: This file contains code for the Node class
 * Date: July 14, 2022
 ************************************************ */
package unit7;

public class Node<T> {

    T mData;
    Node mNext;
    int mOffset;

    public Node(T data) {
        this.mData = data;
        this.mOffset = 0;
    }

}
