
package unit4;

public class Queue<T> {
    LinkedList<T> queueList;
    int size;
    Node start;
    Node end;
    public Queue(){
        queueList = new LinkedList<T>();
        this.start = this.queueList.head;
        this.end = this.queueList.tail;
    }
    
    public void enqueue(T data){
        this.queueList.addToEnd(data);
        this.end = this.queueList.tail;
        this.start = this.queueList.head;
        size++;
    }

    public void dequeue(){
        if(!isEmpty()){
            if(this.start.next == null){
                this.start = null;
                this.end = null;
            }
            else{
                this.queueList.head.next.prev = null;
                this.queueList.head = this.queueList.head.next;
                this.start = this.queueList.head;
            }
            size--;
        }
    }
    
    public T peek(){
        if(!isEmpty()){
            return (T) this.start.data;
        }
        return null;
    }
    
    public void printQueue(){
        Node p = this.start;
        if (!this.isEmpty()) {
            while (p != null) {
                System.out.println("" + p.data);
                p = p.next;
            }
        } else {
            System.out.println("Empty Queue");
        }
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
}
