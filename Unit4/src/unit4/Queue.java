
package unit4;

public class Queue<T> {
    LinkedListComplex<T> queueList;
    int size;
    Node front;
    Node tail;
    public Queue(){
        queueList = new LinkedListComplex<>();
        front = this.queueList.head;
        tail = this.queueList.head;
    }
    
    public void enqueue(T data){
        this.queueList.addToEnd(data);
    }
    public void dequeue(){
        
    }
}
