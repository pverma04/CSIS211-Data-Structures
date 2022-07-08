
package unit6.pkg1;

public class AvlNode<T> {
    T data;
    int count;
    int height;
    AvlNode left, right;

    AvlNode(T d) {
        this.data = d;
        this.height = 1;
        this.count = 1;
    }
}
