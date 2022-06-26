
package unit4;


public class Stack<T> {
    LinkedList<T> stackList;
    Node top;
    Node bottom;
    int size;
    
    public Stack(){
        this.stackList = new LinkedList<T>();
        this.top = this.stackList.head;
        this.bottom = this.stackList.tail;
        size = 0;
    }
    public void push(T data){
        this.stackList.addToEnd(data);
        this.top = this.stackList.tail;
        size++;
    }
    
    public void pop(){
        if(!this.isEmpty()){
            if(this.top == this.stackList.head){
                this.top = null;
                this.bottom = null;
            }
            else{
                this.stackList.tail.prev.next = null;
                this.stackList.tail = this.stackList.tail.prev;
                this.top = this.stackList.tail;
                this.bottom = this.stackList.head;
            }
            size--;
        }
    }
    public T peek(){
        if(!isEmpty()){
            return (T) this.top.data;
        }
        else{
            return null;
        }
    }
        
    public void printStack(){
        Node p = this.top;
        if(!this.isEmpty()){
            while(p != null){
                System.out.println("" + p.data);
                p = p.prev;
            }
        }
        else{
            System.out.println("Empty Stack");
        }
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
}
