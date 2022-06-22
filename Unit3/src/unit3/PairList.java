
package unit3;


public class PairList <T> extends LinkedList<Pair>{

    //private LinkedList<Pair> pairLinkedList;

    public PairList() {
        //this.pairLinkedList = new LinkedList<Pair>();
        super();
    }
    public void addPair(T first, T second){
        //this.pairLinkedList.addToEnd(new Pair(first, second));
        Pair add = new Pair(first, second);
        super.addToEnd(add);
        //super.addToEnd(new Pair(first, second));
    }
    
    public void addPair(Pair addOn){
        //this.pairLinkedList.addToEnd(addOn);
        super.addToEnd(addOn);
    }
    
    public void insertPair(Pair search, T first, T second) {
        Node p = super.head;
        Node nodeInsert = new Node(new Pair(first, second));
        if (p.next != null) {
            if (p.next == null && ((Pair) p.data).checkEquals(search)) {
                p.next = nodeInsert;
                nodeInsert.next = null;
            } 
            else {
                while ((p.next) != null) { //must compare type T
                    if (((Pair) p.data).checkEquals(search)) {
                        nodeInsert.next = p.next; //both now equal the same next
                        p.next = nodeInsert; //p's next is now the new Node, setting nodeInsert into its original spot
                    }
                    p = p.next;
                }
            }
        }
    }
    
    
    @Override
    public void insert(Pair search, Pair addOn){ //NOTE TO PROFESSOR: the second method that does work, but doesn't use any methods from LinkedList
        Node nodeInsert = new Node(addOn);
        //Node p = this.pairLinkedList.head;
        Node p = super.head;
        if (p.next != null) {
            if (p.next == null && ((Pair) p.data).checkEquals(search)) {
                p.next = nodeInsert;
                nodeInsert.next = null;
            } 
            else {
                while ((p.next) != null) { //must compare type T
                    if (((Pair) p.data).checkEquals(search)) {
                        nodeInsert.next = p.next; //both now equal the same next
                        p.next = nodeInsert; //p's next is now the new Node, setting nodeInsert into its original spot
                    }
                    p = p.next;
                }
            }
        }
    }
   
    public T getFirst(T second){
        Node p = super.head;
        while(p.next != null){
            if(((Pair) p.data).checkEquals(((Pair) p.data).getSecond(), second)){
                return (T) ((Pair)p.data).getFirst();
            }
            p = p.next;
        }
        return (T) "Pair not found";
    }
    public T getSecond(T first) {
        Node p = super.head;
        while (p.next != null) {
            if (((Pair) p.data).checkEquals(((Pair) p.data).getFirst(), first)) {
                return (T) ((Pair) p.data).getSecond();
            }
            p = p.next;
        }
        return (T) "Pair not found";
    }
    
    @Override
    public void printList(){
        //this.pairLinkedList.printList();
        //Node p = this.pairLinkedList.head;
        Node p = super.head;
        Pair toPrint;
        if(p == null){
            System.out.println("Empty list");
        }
        else if (p.next == null) {
            System.out.println(((Pair) p.data).getFirst() + ", " + ((Pair)p.data).getSecond());
        } else {
            while (p.next != null) {
                System.out.println(((Pair) p.data).getFirst() + ", " + ((Pair) p.data).getSecond());
                p = p.next;
            }
            System.out.println(((Pair) p.data).getFirst() + ", " + ((Pair) p.data).getSecond());
        }
    }
    /*
    public T getFirst(T second){
        Node p = super.head;
        while(p.next != null){
            if(((Pair) p.data).getSecond() != second){
                p = p.next;
            }
        }
        return (T) ((Pair) p.data).getFirst();
    }
    public T getSecond(T first) {
        Node p = super.head;
        while(p.next != null){
            if(((Pair) p.data).getFirst() != first){
                p = p.next;
            }
        }
        return (T) ((Pair) p.data).getSecond();
    }
    */
    
    public int getSize(){
        return super.getSize();
    }
    public Pair getFirstPair(){
        //return (Pair) super.head.data;
        return super.getFirstNode();
    }
    public Pair getLastPair(){
        /*
        Node p = super.head;
        while(p.next != null){
            p = p.next;
        }
        return (Pair) p.data;
        */
        return super.getLastNode();
    }
    @Override
    public void delete(Pair remove){
        Node p = super.head;
        while(p.next != null){
            if(((Pair)p.data).checkEquals(remove)){
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
    }
    @Override
    public boolean contains(Pair check){
        Node p = super.head;
        while(p.next != null){
            if(((Pair)p.data).checkEquals(check)){
                return true;
            }
        }
        return false;
    }
    public int occurences(T check, boolean isFirst){
        int count = 0;
        Node p = super.head;
        if(isFirst){
            while(p.next != null){
                if(((Pair) p.data).checkEquals(((Pair) p.data).getFirst(), check)){
                    count++;
                }
            }
        }
        else{
            while (p.next != null) {
                if (((Pair) p.data).checkEquals(((Pair) p.data).getSecond(), check)) {
                    count++;
                }
            }
        }
        return count;
    }
}
