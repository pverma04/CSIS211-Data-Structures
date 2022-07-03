/** ***********************************************
 * File: Queue.java
 * Author: Parth Verma
 * Description: This file contains code for the Queue class of unit 4
 * Date: June 30, 2022
 ************************************************ */
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
    
    /**
     * ***********************************************
     * @par Name enqueue
     * @purpose Adds the given data to the end of the queue
     * @param [in] : T data
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void enqueue(T data){
        this.queueList.addToEnd(data);
        this.end = this.queueList.tail;
        this.start = this.queueList.head;
        size++;
    }
    
    /**
     * ***********************************************
     * @par Name dequeue
     * @purpose Removes the value at the beginning of the queue
     * @param [in] : None
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
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
    
    /**
     * ***********************************************
     * @par Name peek
     * @purpose Returns the value at the beginning of the queue
     * @param [in] : None
     * @return T
     * @par References None
     * @par Notes None ***********************************************
     */
    public T peek(){
        if(!isEmpty()){
            return (T) this.start.data;
        }
        return null;
    }
    
    /**
     * ***********************************************
     * @par Name printQueue
     * @purpose Prints the contents of the list in order
     * @param [in] : None
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
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
    
    /**
     * ***********************************************
     * @par Name isEmpty
     * @purpose A helper method to determine if the list is empty
     * @param [in] : None
     * @return boolean
     * @par References None
     * @par Notes None ***********************************************
     */
    public boolean isEmpty(){
        return this.size == 0;
    }
}
