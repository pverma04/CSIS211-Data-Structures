
package unit4;


public class Node<T> {
    //data section
    public T data;
    
    Node next;
    Node prev;
    
    public Node(){
        this(null);
    }
    public Node(T data){
        this.data = data;
    }
}
