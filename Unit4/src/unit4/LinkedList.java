
package unit4;

public class LinkedList<T> {
    Node head;
    
    public LinkedList(){
        this.head = null;
    }
    
    public void addToEnd(T data){
        if(this.head == null){
            this.head = new Node(data); //use the T data to make a new node, for head
            /*following lines are not needed as they instantiate as null
            *this.head.next = null; //only node in the list, nothing after
            *this.head.prev = null; //only node in the list, nothing before
            */
        }
        else{
            Node p = this.head; //used to traverse the list
            while(p.next != null){
                p = p.next;
            }
            Node n = new Node(data); //new node to add
            //set the node
            n.next = null; //since at the end of the list
            n.prev = p;
            p.next = n; //set p to before n
        }
    }
    
    public void addToStart(T data){
        Node n = new Node(data); //node to add to start with given data
        if(this.head == null){ //empty list
            this.head = n; //set head to the new node
            /*following lines are not needed as they instantiate as null
            *this.head.next = null; //only node in the list, nothing after
            *this.head.prev = null; //only node in the list, nothing before
            */
        }
        else{ //there is atleast a head node
            Node temp = this.head;
            this.head = n; //data has been set above
            this.head.next = temp;
            this.head.prev = null; //not needed, as it instantiates as null
            temp.prev = this.head; //head (set to the new node) is now before temp. temp.next was set when temp = this.head
        }
    }
    
    public void insert(T search, T data, boolean insertAfter){ //insert a new node with data 'data' after the node containing search
        Node toSearch = this.getNode(search); //node to be located, using helper method getNode
        Node insert = new Node(data); //node to be inserted after toSearch
        if(!insertAfter){ //new node to be inserted after the search node
            if (toSearch != null) { //found the node using getNode, no need to traverse
                insert.next = toSearch.next; //both lead to the same next node now
                toSearch.next = insert; //set toSearch to lead to insert (toSearch.prev hasn't changed)
                insert.prev = toSearch; //set insert to after toSearch
            } 
        }
        else{ ////new node to be inserted before the search node
            if (toSearch != null) { //found the node using getNode, no need to traverse
                insert.prev = toSearch.prev; //both follow the same node
                toSearch.prev = insert; //toSearch now follows insert
                insert.next = toSearch; //insert leads to toSearch
                insert.prev.next = insert; //the node before isnert now leads to insert
            }
        }
       
    }
    
    public void insert(int index, T data){ //insert a new node with data 'data' at the given index
        Node toSearch = this.getNode(index); //found the node at the index
        Node insert = new Node(data);
        //Node p = this.head; //to traverse
        if(toSearch != null){ //if a node was found at the index (if not, then program will end and won't insert anything)
            insert.prev = toSearch.prev; //both follow to same next node now
            insert.next = toSearch; //insert now leads to toSearch
            toSearch.prev = insert; //toSearch now follows insert
        }
    }
    
    public void delete(T search) {
        Node delete = this.getNode(search);
        delete.prev.next = delete.next; //delete.prev now leads to delete.next
        delete.next.prev = delete.prev; //delete.next now follows delete.prev
    }

    public void delete(int index){
        Node delete = this.getNode(index);
        delete.prev.next = delete.next; //delete.prev now leads to delete.next
        if(delete.next != null){
            delete.next.prev = delete.prev; //delete.next now follows delete.prev
        }
    }
    
    public void printList(){
        Node p = this.head; //to traverse
        if(p != null){
            while (p.next != null) { //traverse all the way to the end and work backwards
                p = p.next;
            }
            while (p != null) { //go backwards and print everything
                System.out.println("" + p.data);
                p = p.prev;
            }
        }
    }
    
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
    
    public int occurrences(T search) {
        Node p = this.head;
        int count = 0;
        while (p.next != null) {
            if (p.data.equals(search)) {
                count++;
            }
            p = p.next;
        }
        if (p.data.equals(search)) {
            count++;
        }
        return count;
    }
    
    public boolean contains(T search) {
        if (this.getNode(search) != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public T getFirstNodeData() {
        return (T) this.head.data;
    }
    
    public T getLastNodeData() {
        Node p = this.head;
        while (p.next != null) {
            p = p.next;
        }
        return (T) p.data;
    }
    
    public Node getNode(int index){
        int indexCount = 0;
        Node p = this.head;
        Node rv = null;
        while(p.next != null){
            if(indexCount == index){
                //rv = p;
                return p;
            }
            p = p.next;
            indexCount++;
        }
        if(indexCount == index){
            rv = p;
        }
        return rv;
    }
    
    public Node getNode(T search) { //returns the node in the list that contains T search in its data
        Node p = this.head; //to traverse
        Node rv = null;
        if (p != null) { //if there is atleast a head
            if (p.next == null && p.data.equals(search)) { //if there is only head, and it matches search
                rv = p;
            } 
            else { //if there is more than head
                while ((p.next) != null) { //traverse
                    if ((p.data).equals(search)) { //if the data matches search
                        rv = p;
                        break;
                    }
                    p = p.next;
                }
                if ((p.data).equals(search)) { //checking the last node as well
                    rv = p;
                }
            }
        }
        return rv;
    }
}
