/** ***********************************************
 * File: Node.java
 * Author: Parth Verma
 * Description: This file contains code for the Node class
 * Date: July 24, 2022
 ************************************************ */

package unit9;

public class Node<T> {
    T mData;
    Node mNext;
    boolean mVisited;
    public Node() {
        this(null);
    }
    public Node (T data) {
        this.mData = data;
        this.mVisited = false;
    }
}
