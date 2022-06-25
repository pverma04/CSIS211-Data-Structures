/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unit4;

/**
 *
 * @author parthverma
 */
public class LinkedList<T> {
    Node head;
    Node tail;
    
    public LinkedList(){
        this.head = null;
        this.tail = null;
    }
    
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
