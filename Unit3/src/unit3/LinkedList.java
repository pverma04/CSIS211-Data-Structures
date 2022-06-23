
package unit3;

public class LinkedList<T> {
    public Node head;
    
    public LinkedList(){
        head = null;
    }
    
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
    public void insert(T search, T data){
        Node p = this.head;
        Node nodeInsert = new Node(data);
        Node toSearch = this.getNode(search);
        if (toSearch != null) {
            nodeInsert.next = toSearch.next; //both now equal the same next
            toSearch.next = nodeInsert; //p's next is now the new Node, setting nodeInsert into its original spot
        }
        /*
        Node nodeInsert = new Node(data);
        Node p = this.head;
        if(p != null){
            if(p.next==null && p.data.equals(search)){
                p.next=nodeInsert;
                nodeInsert.next=null;
            }
            else{
                while ((p.next) != null) { //must compare type T
                    if(p.data.equals(search)){ //NOTE TO PROFESSOR: checking if they are equal does not work here          
                        nodeInsert.next = p.next; //both now equal the same next
                        p.next = nodeInsert; //p's next is now the new Node, setting nodeInsert into its original spot
                    }
                    p = p.next;
                }  
            }
        }
        */
    }
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
    public void deleteIndex(int index) {
        Node prevNode = this.getNode(index - 1);
        prevNode.next = prevNode.next.next;
        /*
        Node p = this.head;
        int countIndex = 0;
        int indexCount = 0;
        if (index == 0) {
            head = head.next;
        } 
        else if (index < this.getSize()) {
            while (p.next != null) {
                indexCount++;
                if (indexCount == index) {
                    p.next = p.next.next;
                    break;
                }
                p = p.next;
            }
        }
        */
    }
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
    public int getSize(){
        if(head == null){
            return 0;
        }
        else{
            int count = 1;
            Node p = head;
            while (p.next != null) {
                count++;
                p = p.next;
            }
            return count;
        }
    }
    public int occurences(T search){
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
    public boolean contains(T search){
        Node p = this.head;
        while(p.next != null){
            if(p.data.equals(search)){
                return true;
            }
            p = p.next;
        }
        return false;
    }
    public T getFirstNodeData(){
        return (T) this.head.data;
    }
    public T getLastNodeData(){
        Node p = this.head;
        while(p.next != null){
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
                rv = p;
                break;
            }
            p = p.next;
            indexCount++;
        }
        return rv;
    }
    public Node getNode(T data){
        Node p = this.head;
        Node rv = null;
        if (p != null) {
            if (p.next == null && p.data.equals(data)) {
                rv = p;
            } else {
                while ((p.next) != null) { //must compare type T
                    if ((p.data).equals(data)) { //NOTE TO PROFESSOR: checking if they are equal does not work here          
                        rv = p;
                        break;
                    }
                    p = p.next;
                }
                if ((p.data).equals(data)) {
                    rv = p;
                }
            }
        }
        return rv;
    }
}