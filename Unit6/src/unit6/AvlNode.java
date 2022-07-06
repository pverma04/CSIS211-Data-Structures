
package unit6;


public class AvlNode<T> {
    T data;
    AvlNode left;
    AvlNode right;
    int height;
    int count;
    
    public AvlNode(T data, AvlNode l, AvlNode r){
        this.data = data;
        this.left = l;
        this.right = r;
        this.count = 1;
    }
}
