
package unit3;


public class PairList <T> extends LinkedList<Pair>{

    //private LinkedList<Pair> pairLinkedList;

    public PairList() {
        //this.pairLinkedList = new LinkedList<Pair>();
        super();
    }
    public void addPair(T first, T second){
        super.addToEnd(new Pair(first, second));
    }
    public void addPair(Pair addOn){
        super.addToEnd(addOn);
    }
    public void insert(Pair search, T first, T second) {
        Node p = super.head;
        Node nodeInsert = new Node(new Pair(first, second));
        Node toSearch = this.getNode(search);
        if(toSearch != null){
            nodeInsert.next = toSearch.next; //both now equal the same next
            toSearch.next = nodeInsert; //p's next is now the new Node, setting nodeInsert into its original spot
        }
    }
    @Override
    public void insert(Pair search, Pair insert){ //NOTE TO PROFESSOR: the second method that does work, but doesn't use any methods from LinkedList
        Node p = super.head;
        Node nodeInsert = new Node(insert);
        Node toSearch = this.getNode(search);
        if (toSearch != null) {
            nodeInsert.next = toSearch.next; //both now equal the same next
            toSearch.next = nodeInsert; //p's next is now the new Node, setting nodeInsert into its original spot
        }
    }
    public void insertAtIndex(Pair insert, int index){
        Node p = super.head;
        Node nodeInsert = new Node(insert);
        int indexCount = 0;
        if(index >= super.getSize()){
            super.addToEnd(insert);
        }
        else if(index == 0){
            super.addToFirst(insert);
        }
        else{
            Node prevNode = super.getNode(index - 1);
            nodeInsert.next = prevNode.next;
            prevNode.next = nodeInsert;
        }
    }
    public void insertAtIndex(T first, T second, int index) {
        Node p = super.head;
        Pair insert = new Pair(first, second);
        Node nodeInsert = new Node(insert);
        int indexCount = 0;
        if (index >= super.getSize()) {
            super.addToEnd(insert);
        } 
        else if (index == 0) {
            super.addToFirst(insert);
        } 
        else {
            Node prevNode = super.getNode(index - 1);
            nodeInsert.next = prevNode.next;
            prevNode.next = nodeInsert;
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
        return null;
    }
    public T getSecond(T first) {
        Node p = super.head;
        while (p.next != null) {
            if (((Pair) p.data).checkEquals(((Pair) p.data).getFirst(), first)) {
                return (T) ((Pair) p.data).getSecond();
            }
            p = p.next;
        }
        return null;
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
    public Pair getFirstPair(){
        return (Pair) super.getFirstNodeData();
    }
    public Pair getLastPair(){
        return (Pair) super.getLastNodeData();
    }
    @Override
    public void delete(Pair remove){
        Node p = super.head;
        while(p.next != null){
            if(((Pair)p.next.data).checkEquals(remove)){
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
    }
    public void delete(T first, T second) {
        Node p = super.head;
        Pair remove = new Pair(first, second);
        while (p.next != null) {
            if (((Pair) p.next.data).checkEquals(remove)){
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
    }
    @Override
    public boolean contains(Pair check){
        if(this.getNode(check) != null){
            return true;
        }
        else{
            return false;
        }
    }
    public int occurences(T check, boolean isFirst){
        int count = 0;
        Node p = super.head;
        if(isFirst){
            while(p.next != null){
                if(((Pair) p.data).checkEquals(((Pair) p.data).getFirst(), check)){
                    count++;
                }
                p = p.next;
            }
            if (((Pair) p.data).checkEquals(((Pair) p.data).getFirst(), check)) {
                count++;
            }
            
        }
        else{
            while (p.next != null) {
                if (((Pair) p.data).checkEquals(((Pair) p.data).getSecond(), check)) {
                    count++;
                }
                p = p.next;
            }
            if (((Pair) p.data).checkEquals(((Pair) p.data).getSecond(), check)) {
                    count++;
            }
        }
        return count;
    }
    @Override
    public Node getNode(Pair check){
        Node p = super.head;
        Node rv = null;
        
        if(p != null){
            if(p.next == null && ((Pair) p.data).checkEquals(check)){
                rv = p;
            }
            else{
                while ((p.next) != null) { //must compare type T
                    if(((Pair) p.data).checkEquals(check)){ //NOTE TO PROFESSOR: checking if they are equal does not work here          
                        rv = p;
                        break;
                    }
                    p = p.next;
                }
                if (((Pair) p.data).checkEquals(check)) {
                    rv = p;
                }
            }
        }
        return rv;
    }
}
