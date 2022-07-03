/** ***********************************************
 * File: LinkedList.java
 * Author: Parth Verma
 * Description: This file contains code for the LinkedList class of unit 4
 * Date: June 30, 2022
 ************************************************ */
package unit4;

public class LinkedList<T> {
    Node head;
    Node tail;
    
    public LinkedList(){
        this.head = null;
        this.tail = null;
    }
    
    /**
     * ***********************************************
     * @par Name addToEnd
     * @purpose Adds the given data to the end of the Linked List
     * @param [in] : T data
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void addToEnd(T data){
        Node add = new Node(data);
        if(this.head == null){
            this.head = add;
            this.head.prev = null;
            this.tail = add;
            this.tail.next = null;
        }
        else{
            this.tail.next = add;
            add.prev = this.tail;
            add.next = null;
            this.tail = add;
        }
    }

    /**
     * ***********************************************
     * @par Name printList
     * @purpose Prints the contents of the LinkedList in order
     * @param [in] : None
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void printList(){
        Node p = this.head; //to traverse
        if(p != null){
            while (p != null) { //traverse all the way to the end
                System.out.println("" + p.data);
                p = p.next;
            }
        }
        else{
            System.out.println("Empty List");
        }
    }
}
