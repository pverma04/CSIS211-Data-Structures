/** ***********************************************
 * File: LinkedList.java
 * Author: Parth Verma
 * Description: This file contains code for the LinkedList class
 * Date: June 23, 2022
 ************************************************ */
package unit7;

public class LinkedList<T> {
    public Node mHead;
    
    public LinkedList(){
        this.mHead = null;
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
        if(this.mHead == null){ //this means the list contains nothing
            this.mHead = new Node(data); //head now hold the data which has been added
            this.mHead.mNext = null; 
        }
        else{
            Node p = this.mHead; //reference to head node
            Node nodeAdd = new Node(data); //new node
            nodeAdd.mData = data;

            nodeAdd.mNext = null;
            while (p.mNext!=null) { //until the next node is null, traverse
                p = p.mNext;
            }
            p.mNext = nodeAdd; 
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
        if(this.mHead == null){
            this.mHead = first;
        }
        else{
            Node temp = this.mHead;
            this.mHead = first;
            this.mHead.mNext = temp;
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
        Node p = this.mHead;
        Node nodeInsert = new Node(data);
        Node toSearch = this.getNode(search); //helper method to find Node to insert after
        if (toSearch != null) {
            nodeInsert.mNext = toSearch.mNext; //both now equal the same next
            toSearch.mNext = nodeInsert; //p's next is now the new Node, setting nodeInsert into its original spot
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
        Node p = this.mHead;
        while(p.mNext != null){
            if(p.mData.equals(search)){
                p.mNext = p.mNext.mNext;
                break;
            }
            p = p.mNext;
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
        prevNode.mNext = prevNode.mNext.mNext;
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
        Node p = this.mHead;
        if (p.mNext == null) {
            System.out.println("" + p.mData);
        } else {
            while (p.mNext != null) {
                System.out.println("" + p.mData);
                p = p.mNext;
            }
            System.out.println("" + p.mData);
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
        if(this.mHead == null){ //empty list
            return 0;
        }
        else{
            int count = 1; //if head isn't empty, there is atleast 1 Node
            Node p = this.mHead;
            while (p.mNext != null) {
                count++;
                p = p.mNext;
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
        Node p = this.mHead;
        int count = 0;
        while(p.mNext != null){
            if(p.mData.equals(search)){
                count++;
            }
            p = p.mNext;
        }
        if (p.mData.equals(search)) {
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
        return (T) this.mHead.mData;
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
        Node p = this.mHead;
        while(p.mNext != null){
            p = p.mNext;
        }
        return (T) p.mData;
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
        Node p = this.mHead;
        Node rv = new Node(null);
        while(p.mNext != null){
            if(indexCount == index){
                //rv = p;
                return p;
            }
            p = p.mNext;
            indexCount++;
        }
        if(indexCount == index){
            rv = p;
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
        Node p = this.mHead;
        Node rv = null;
        if (p != null) {
            if (p.mNext == null && p.mData.equals(search)) {
                rv = p;
            } else {
                while ((p.mNext) != null) { //must compare type T
                    if ((p.mData).equals(search)) {     
                        rv = p;
                        break;
                    }
                    p = p.mNext;
                }
                if ((p.mData).equals(search)) {
                    rv = p;
                }
            }
        }
        return rv;
    }
    
}