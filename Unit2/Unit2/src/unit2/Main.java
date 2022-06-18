package unit2;

public class Main {
    
    public static void main(String[] args) {
        
        /*PairList<String> strList = new PairList<String>();
        strList.addPair("hello", "world");
        strList.addPair("bye", "everyone");
        strList.addPair("testing", "clear");
        strList.addPair("still", "test");
        //strList.printList();
        strList.deletePair("testing", "clear");
        System.out.println("--");
        strList.printList();

        System.out.println("-- clearing");
        strList.clearAll();
        strList.printList();
        */
        PairList<Integer> intList = new PairList<Integer>();
        
        System.out.println("-- Testing adding pairs");
        intList.addPair(1, 2);
        intList.addPair(3, 4);
        intList.addPair(5, 6);
        intList.addPair(7, 8);
        Pair<Integer> fifthPair = new Pair(9, 0);
        intList.addPair(fifthPair);
        intList.printList();
        System.out.println("--");
        intList.addPair(new Pair<Integer>(8, 9), 0);
        intList.printList();
        
        System.out.println("Testing get size and contains pair");
        System.out.println("size: " + intList.getSize());
        System.out.println("Contains pair 9, 0: " + intList.containsPair(new Pair<Integer>(9,0)));
        System.out.println("Contains pair 7, 5: " + intList.containsPair(7,5));
        
        System.out.println("-- Testing get first/second");
        int intF = 1; //please change this value for efficiency
        int intS = 2; //please change this value for efficiency
        Integer first = intList.getFirst(intS);
        Integer second = intList.getSecond(intF);
        System.out.println(second == null ? "First not found" : "" + second);
        System.out.println(first == null ? "Second not found" : "" + first);
        
        
        System.out.println("-- Testing add at index");
        intList.addPair(new Pair<Integer>(5,5), 2);
        intList.printList();
        
        System.out.println("-- Testing find occurences");
        System.out.println(intList.occurrences(1, true));
        
        System.out.println("-- Testing get index");
        System.out.println(intList.getIndex(5, 6));

        System.out.println("-- Testing set index");
        intList.setIndex(new Pair(67, 89), 3);
        intList.printList();
        
        System.out.println("-- Testing deleting pairs");
        intList.deletePair(9, 0);
        intList.printList();
        System.out.println("--");
        intList.deletePair(3, 4);
        intList.deletePair(0);
        intList.printList();
        
        System.out.println("-- Testing clear all");

        intList.clearAll();
        intList.printList();
    }
}
