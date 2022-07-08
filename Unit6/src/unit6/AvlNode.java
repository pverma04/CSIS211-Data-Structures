
package unit6;


public class AvlNode<T> {
    T data;
    AvlNode left;
    AvlNode right;
    int height;
    int count;
    
    public AvlNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.count = 1;
    }
}
