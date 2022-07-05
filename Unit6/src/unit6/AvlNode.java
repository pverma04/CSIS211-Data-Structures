
package unit6;


public class AvlNode<T> {
    T data;
    AvlNode left;
    AvlNode right;
    int height;
    
    public AvlNode(T data, AvlNode l, AvlNode r){
        this.data = data;
        this.left = l;
        this.right = r;
    }
}
