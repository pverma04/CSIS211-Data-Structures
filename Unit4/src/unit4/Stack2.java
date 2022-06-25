
package unit4;

public class Stack2<T>{
    //data section
    LinkedListComplex<T> stackList;
    int size; //more effecient to keep a size variable rather than calling this.stackList.getSize() each time
    
    public Stack2(){
        this.stackList = new LinkedListComplex<T>();
        this.size = 0;
    }
    public void push(T data){
        this.stackList.addToEnd(data);
        this.size++;
    }
    public void pop(){
        if(this.size > 0){
            this.stackList.delete(this.size - 1);
            size--;
        }
    }
    public T peek(){
        if(size > 0){
            return (T) this.stackList.getNode(size - 1).data;
        }
        return null;
    }
    public void print(){
        this.stackList.printList();
        
    }
    
}
