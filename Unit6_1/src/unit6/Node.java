
package unit6;

public class Node <T> {
    T data;
     
    Node left;
    Node right;
    
    int height; //of the node in the tree
    int count; //occurences of the data of this node
    
    public Node(){
        this(null);
        this.height = 0;
        this.count = 0;
    }
    public Node(T data){
        this.data = data;
        //this.left = l;
        //this.right = r;
        this.height = 0;
        this.count = 1;
    }
}
