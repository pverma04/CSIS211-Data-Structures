/** ***********************************************
 * File: Pairlist.java
 * Author: Parth Verma
 * Description: This file contains code for the PairList class (Derived from Linked List)
 * Date: June 23, 2022
 ************************************************ */
package unit3;

public class PairList <T> extends LinkedList<Pair>{
    public PairList() {
        super();
    }
    
    /**
     * ***********************************************
     * @par Name addPair
     * @purpose Create and add a new pair to the end of the super linked list
     * @param [in] : T first, T second
     * @return None
     * @par References None
     * @par Notes None
    ************************************************
     */
    public void addPair(T first, T second){
        super.addToEnd(new Pair(first, second));
    }
    
    /**
     * ***********************************************
     * @par Name addPair
     * @purpose Add a new pair to the end of the super linked list
     * @param [in] : Pair addOn
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void addPair(Pair addOn){
        super.addToEnd(addOn);
    }
    
    /**
     * ***********************************************
     * @par Name insert
     * @purpose Create and insert a new pair following the node containing the search pair 
     * @param [in] : Pair search, T first, T second
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void insert(Pair search, T first, T second) {
        Node p = super.head;
        Node nodeInsert = new Node(new Pair(first, second));
        Node toSearch = this.getNode(search);
        if(toSearch != null){ //if there IS a 'search' node
            nodeInsert.next = toSearch.next; //both now equal the same next
            toSearch.next = nodeInsert; //p's next is now the new Node, setting nodeInsert into its original spot
        }
    }
    
    /**
     * ***********************************************
     * @par Name insert
     * @purpose Insert a new pair following the node containing the
     * search pair
     * @param [in] : Pair search, Pair insert
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    @Override
    public void insert(Pair search, Pair insert){
        Node p = super.head;
        Node nodeInsert = new Node(insert);
        Node toSearch = this.getNode(search);
        if (toSearch != null) { //if there IS a 'search' node
            nodeInsert.next = toSearch.next; //both now equal the same next
            toSearch.next = nodeInsert; //p's next is now the new Node, setting nodeInsert into its original spot
        }
    }
    
    /**
     * ***********************************************
     * @par Name insert
     * @purpose Insert a new pair at the index of the linked list
     * moving following nodes on position to the right
     * @param [in] : Pair insert, int index
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void insertAtIndex(Pair insert, int index){
        Node p = super.head;
        Node nodeInsert = new Node(insert);
        int indexCount = 0;
        if(index >= super.getSize()){ //any index greater than size will lead to teh ndoe being placed at the end
            super.addToEnd(insert);
        }
        else if(index == 0){ 
            super.addToFirst(insert); //helper method to add a ndoe before the head
        }
        else{
            Node prevNode = super.getNode(index - 1); //node before the current index node found with helper method
            nodeInsert.next = prevNode.next; //set new node.next = previous node.next 
            prevNode.next = nodeInsert; //set prev node.next to new node;
        }
    }
    
    /**
     * ***********************************************
     * @par Name insert
     * @purpose Create and insert a new pair at the index of the linked list moving
     * following nodes on position to the right
     * @param [in] : T first, T second, int index
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void insertAtIndex(T first, T second, int index) {
        Node p = super.head;
        Pair insert = new Pair(first, second);
        Node nodeInsert = new Node(insert);
        int indexCount = 0;
        if (index >= super.getSize()) { //any index greater than size will lead to the ndoe being placed at the end
            super.addToEnd(insert);
        } 
        else if (index == 0) {
            super.addToFirst(insert); //helper method to add a ndoe before the head
        } 
        else {
            Node prevNode = super.getNode(index - 1); //node before the current index node found with helper method
            nodeInsert.next = prevNode.next; //set new node.next = previous node.next
            prevNode.next = nodeInsert; //set prev node.next to new node;
        }
    }
    
    /**
     * ***********************************************
     * @par Name printList
     * @purpose Print the contents of the linked list line by line
     * @param [in] : None
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    @Override
    public void printList() {
        //this.pairLinkedList.printList();
        //Node p = this.pairLinkedList.head;
        Node p = super.head;
        Pair toPrint;
        if (p == null) {
            System.out.println("Empty list");
        } else if (p.next == null) {
            System.out.println(((Pair) p.data).getFirst() + ", " + ((Pair) p.data).getSecond());
        } else {
            while (p.next != null) {
                System.out.println(((Pair) p.data).getFirst() + ", " + ((Pair) p.data).getSecond());
                p = p.next;
            }
            System.out.println(((Pair) p.data).getFirst() + ", " + ((Pair) p.data).getSecond());
        }
    }
    
    /**
     * ***********************************************
     * @par Name delete
     * @purpose Searches for and removes the given pair from the list
     * @param [in] : Pair remove
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    @Override
    public void delete(Pair remove) {
        Node p = super.head;
        while (p.next != null) {
            if (((Pair) p.next.data).checkEquals(remove)) { //if the given Pair is the same at p.data, remove it
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
    }
    
    /**
     * ***********************************************
     * @par Name delete
     * @purpose Searches for and removes the given first and second as a pair
     * from the list
     * @param [in] : T first, T second
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void delete(T first, T second) {
        Node p = super.head;
        Pair remove = new Pair(first, second);
        while (p.next != null) {
            if (((Pair) p.next.data).checkEquals(remove)) { //if the given first and second set as a Pair is the same at p.data, remove it
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
    }
    
    /**
     * ***********************************************
     * @par Name contains
     * @purpose Determines if the given Pair is in the list
     * @param [in] : Pair check
     * @return Boolean
     * @par References None
     * @par Notes None ***********************************************
     */
    @Override
    public boolean contains(Pair check) {
        if (this.getNode(check) != null) { //helper method to return the Node that matches the Pair
            return true;
        } else {
            return false;
        }
    }

    /**
     * ***********************************************
     * @par Name occurrences
     * @purpose Finds the number of occurrences of a type T variable in the list
     * (this could be a First or Second in a Pair)
     * @param [in] : T check, boolean isFirst
     * @return Boolean
     * @par References None
     * @par Notes None ***********************************************
     */
    public int occurrences(T check, boolean isFirst) {
        int count = 0;
        Node p = super.head;
        if (isFirst) { //if T check is a first
            while (p.next != null) {
                if (((Pair) p.data).checkEquals(((Pair) p.data).getFirst(), check)) {
                    count++;
                }
                p = p.next;
            }
            if (((Pair) p.data).checkEquals(((Pair) p.data).getFirst(), check)) { //Checking the last Node as well
                count++;
            }

        } else { //if T check is a second
            while (p.next != null) {
                if (((Pair) p.data).checkEquals(((Pair) p.data).getSecond(), check)) {
                    count++;
                }
                p = p.next;
            }
            if (((Pair) p.data).checkEquals(((Pair) p.data).getSecond(), check)) { //Checking the last Node as well
                count++;
            }
        }
        return count;
    }
    
    /**
     * ***********************************************
     * @par Name getFirst
     * @purpose Find and return the 'first' value of a pair by searching for the
     * Node with data containing the given 'second' value
     * @param [in] : T second
     * @return T
     * @par References None
     * @par Notes None ***********************************************
     */
    public T getFirst(T second){
        Node p = super.head;
        while(p.next != null){
            if(((Pair) p.data).checkEquals(((Pair) p.data).getSecond(), second)){ //if the current node's data (a Pair) has a matching second to the given one
                return (T) ((Pair)p.data).getFirst();
            }
            p = p.next;
        }
        return null; //if correct Pair not found, return null
    }
    
    /**
     * ***********************************************
     * @par Name getSecond
     * @purpose Find and return the 'second' value of a pair by searching for the
     * Node with data containing the given 'first' value
     * @param [in] : T first
     * @return T
     * @par References None
     * @par Notes None ***********************************************
     */
    public T getSecond(T first) {
        Node p = super.head;
        while (p.next != null) {
            if (((Pair) p.data).checkEquals(((Pair) p.data).getFirst(), first)) { //if the current node's data (a Pair) has a matching first to the given one
                return (T) ((Pair) p.data).getSecond();
            }
            p = p.next;
        }
        return null; //if correct Pair not found, return null
    }    
    
    /**
     * ***********************************************
     * @par Name getFirstPair
     * @purpose Returns the Pair at the head of the list
     * @param [in] : None
     * @return Pair
     * @par References None
     * @par Notes None ***********************************************
     */
    public Pair getFirstPair(){
        return (Pair) super.getFirstNodeData();
    }
    
    /**
     * ***********************************************
     * @par Name getLastPair
     * @purpose Returns the Pair at the end of the list
     * @param [in] : None
     * @return Pair
     * @par References None
     * @par Notes None ***********************************************
     */
    public Pair getLastPair(){
        return (Pair) super.getLastNodeData();
    }
    
    /**
     * ***********************************************
     * @par Name getNode
     * @purpose A helper method to return the Node that contains the given Pair
     * in its data
     * @param [in] : Pair check
     * @return Node
     * @par References None
     * @par Notes None ***********************************************
     */
    @Override
    public Node getNode(Pair check){
        Node p = super.head;
        Node rv = null;
        
        if(p != null){ //if head is not null
            if(p.next == null && ((Pair) p.data).checkEquals(check)){ //if the list only contains head and head.data = check
                rv = p;
            }
            else{ //continue traversing
                while ((p.next) != null) { 
                    if(((Pair) p.data).checkEquals(check)){ 
                        rv = p;
                        break;
                    }
                    p = p.next;
                }
                if (((Pair) p.data).checkEquals(check)) { //checking last Node as well
                    rv = p;
                }
            }
        }
        return rv; //returns null if not found
    }
}
