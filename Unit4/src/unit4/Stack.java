
package unit4;

public class Stack<T>{
    //data section
    LinkedList<T> stackList;
    int size; //more effecient to keep a size variable rather than calling this.stackList.getSize() each time
    
    public Stack(){
        this.stackList = new LinkedList<T>();
        this.size = 0;
    }
    public void push(T data){
        this.stackList.addToEnd(data);
        this.size++;
    }
    public void pop(){
        if(size <= 1){
            this.stackList.head = null;
        }
        else{
            this.stackList.delete(this.size - 1);
        }
        size--;
    }
    public T peek(){
        if(size != 0){
            return (T) this.stackList.getNode(size - 1).data;
        }
        return null;
    }
    public void print(){
        this.stackList.printList();
        
    }
    
}
