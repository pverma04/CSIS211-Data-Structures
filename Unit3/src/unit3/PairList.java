
package unit3;


public class PairList <T> extends LinkedList<Pair>{

    private LinkedList<Pair> pairLinkedList;

    public PairList() {
        pairLinkedList = new LinkedList<Pair>();
    }
    public void addPair(T first, T second){
        //Pair p=new Pair((Comparable) first, (Comparable) second);
        Pair p = new Pair((Comparable) first, (Comparable) second);

        System.out.println(p.getFirst()+"---"+p.getSecond());
        pairLinkedList.addToEnd(p);
    }
    public void addPair(T first, T second, T search) {
        Node p = pairLinkedList.head;
        while(p.data != search){
            p = p.next;
        }
    }
    public void print(){
        Pair p= (Pair)this.pairLinkedList.head.data;
        
        System.out.println(p.getFirst()+"--"+p.getSecond());
        //this.pairLinkedList.printList();
    }
}
