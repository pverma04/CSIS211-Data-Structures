
package unit3;

public class LinkedList<T> {
    public Node head;
    
    public LinkedList(){
        head = null;
    }
    public void addToEnd(T data){
        if(this.head == null){ //this means the list contains nothing
            
            this.head = new Node(data); //head now hold the data which has been added
            //this.head = new Node(data); //head now hold the data which has been added
            this.head.next = null; 
        }
        else{
            Node p = this.head; //reference to head node
            Node nodeAdd = new Node(data); //new node
            nodeAdd.data = data;

            nodeAdd.next = null;
            //while (!p.next.equals(null)) { //until the next node is null, traverse
            while (p.next!=null) { //until the next node is null, traverse
                p = p.next;
            }
            p.next = nodeAdd; 
            /*
            if(head == null){
                head = nodeAdd;
            }
            else{
                head.next = nodeAdd;
            }
             */
        }
    }
    public void insert(T search, T data){
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
        //p.next = p.next.next;
        //Node n = p.next;
        //p.next = n.next;
        
        
    }
    
    public int getSize()
    {
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
    public void printList(){
        Node p = this.head;
        if(p.next == null){
            System.out.println("" + p.data);
        }
        else{
            while (p.next != null) {
                System.out.println("" + p.data);
                p = p.next;
            } 
            System.out.println("" + p.data);
        }
    }
    public T getFirstNode(){
        return (T) this.head.data;
    }
    public T getLastNode(){
        Node p = this.head;
        while(p.next != null){
            p = p.next;
        }
        return (T) p.data;
    }
}