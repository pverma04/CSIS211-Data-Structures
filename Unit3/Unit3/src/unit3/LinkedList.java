/** ***********************************************
 * File: LinkedList.java
 * Author: Parth Verma
 * Description: This file contains code for the LinkedList class
 * Date: June 23, 2022
 ************************************************ */
package unit3;

public class LinkedList<T> {
    public Node head;
    
    public LinkedList(){
        head = null;
    }
    
    /**
     * ***********************************************
     * @par Name addToEnd
     * @purpose Adds the given data to a new Node at the end of the list
     * @param [in] : T data
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void addToEnd(T data){
        if(this.head == null){ //this means the list contains nothing
            this.head = new Node(data); //head now hold the data which has been added
            this.head.next = null; 
        }
        else{
            Node p = this.head; //reference to head node
            Node nodeAdd = new Node(data); //new node
            nodeAdd.data = data;

            nodeAdd.next = null;
            while (p.next!=null) { //until the next node is null, traverse
                p = p.next;
            }
            p.next = nodeAdd; 
        }
    }
    
    /**
     * ***********************************************
     * @par Name addToFirst
     * @purpose Adds the given data to a new Node at the start of the list
     * @param [in] : T data
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void addToFirst(T data){
        Node first = new Node(data);
        if(this.head == null){
            this.head = first;
        }
        else{
            Node temp = this.head;
            this.head = first;
            this.head.next = temp;
        }
    }
    
    /**
     * ***********************************************
     * @par Name insert
     * @purpose Inserts the given data into a new Node after the Node containing
     * the given search data
     * @param [in] : T search, T data
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void insert(T search, T data){
        Node p = this.head;
        Node nodeInsert = new Node(data);
        Node toSearch = this.getNode(search); //helper method to find Node to insert after
        if (toSearch != null) {
            nodeInsert.next = toSearch.next; //both now equal the same next
            toSearch.next = nodeInsert; //p's next is now the new Node, setting nodeInsert into its original spot
        }
    }
    
    /**
     * ***********************************************
     * @par Name delete
     * @purpose Deletes the Node containing the given data
     * @param [in] : T search
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void delete(T search){
        Node p = this.head;
        while(p.next != null){
            if(p.data.equals(search)){
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }   
    }
    
    /**
     * ***********************************************
     * @par Name deleteIndex
     * @purpose Deletes the Node at the given index of the List
     * @param [in] : int index
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void deleteIndex(int index) {
        Node prevNode = this.getNode(index - 1);
        prevNode.next = prevNode.next.next;
    }
    
    /**
     * ***********************************************
     * @par Name printList
     * @purpose Prints the contents of the List line by line
     * @param [in] : None
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void printList() {
        Node p = this.head;
        if (p.next == null) {
            System.out.println("" + p.data);
        } else {
            while (p.next != null) {
                System.out.println("" + p.data);
                p = p.next;
            }
            System.out.println("" + p.data);
        }
    }
    
    /**
     * ***********************************************
     * @par Name getSize
     * @purpose Returns the size of the list
     * @param [in] : None
     * @return int
     * @par References None
     * @par Notes None ***********************************************
     */
    public int getSize(){
        if(head == null){ //empty list
            return 0;
        }
        else{
            int count = 1; //if head isn't empty, there is atleast 1 Node
            Node p = head;
            while (p.next != null) {
                count++;
                p = p.next;
            }
            return count;
        }
    }
    
    /**
     * ***********************************************
     * @par Name occurrences
     * @purpose Determines the number of occurrences of a given 'search' in the 
     * list
     * @param [in] : T search
     * @return int
     * @par References None
     * @par Notes None ***********************************************
     */
    public int occurrences(T search){
        Node p = this.head;
        int count = 0;
        while(p.next != null){
            if(p.data.equals(search)){
                count++;
            }
            p = p.next;
        }
        if (p.data.equals(search)) {
            count++;
        }
        return count;
    }
    
    /**
     * ***********************************************
     * @par Name contains
     * @purpose Determines whether or not a given 'search' is in the list
     * @param [in] : T search
     * @return boolean
     * @par References None
     * @par Notes None ***********************************************
     */
    public boolean contains(T search){
        if(this.getNode(search) != null){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * ***********************************************
     * @par Name getFirstNodeData
     * @purpose Returns the head node's data
     * @param [in] : None
     * @return T
     * @par References None
     * @par Notes None ***********************************************
     */
    public T getFirstNodeData(){
        return (T) this.head.data;
    }
    
    /**
     * ***********************************************
     * @par Name getLastNodeData
     * @purpose Returns the last node's data
     * @param [in] : None
     * @return T
     * @par References None
     * @par Notes None ***********************************************
     */
    public T getLastNodeData(){
        Node p = this.head;
        while(p.next != null){
            p = p.next;
        }
        return (T) p.data;
    }
    
    /**
     * ***********************************************
     * @par Name getNode
     * @purpose Returns the Node at the given index of the list
     * @param [in] : int index
     * @return Node
     * @par References None
     * @par Notes None ***********************************************
     */
    public Node getNode(int index){
        int indexCount = 0;
        Node p = this.head;
        Node rv = null;
        while(p.next != null){
            if(indexCount == index){
                rv = p;
                break;
            }
            p = p.next;
            indexCount++;
        }
        return rv;
    }
    
    /**
     * ***********************************************
     * @par Name getNode
     * @purpose Returns the the Node that contains the given 'search' in its data
     * @param [in] : T search
     * @return Node
     * @par References None
     * @par Notes None ***********************************************
     */
    public Node getNode(T search){
        Node p = this.head;
        Node rv = null;
        if (p != null) {
            if (p.next == null && p.data.equals(search)) {
                rv = p;
            } else {
                while ((p.next) != null) { //must compare type T
                    if ((p.data).equals(search)) {     
                        rv = p;
                        break;
                    }
                    p = p.next;
                }
                if ((p.data).equals(search)) {
                    rv = p;
                }
            }
        }
        return rv;
    }
    
}