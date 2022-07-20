
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
