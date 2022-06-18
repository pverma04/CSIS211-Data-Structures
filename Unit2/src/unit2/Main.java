/** ***********************************************
 * File: Main.java
 * Author: Parth Verma
 * Description: This file contains code for the Main class of unit 2 (PairList)
 * Date: June 17, 2022
 ************************************************ */
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
        
        /*
        PairList<Integer> intList = new PairList<Integer>();
        
        System.out.println("-- Testing adding pairs");
        intList.addPair(1, 2);
        intList.addPair(3, 4);
        intList.addPair(5, 6);
        intList.addPair(7, 8);
        Pair<Integer> fifthPair = new Pair<Integer>(9, 0);
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
        intList.setIndex(new Pair<Integer>(67, 89), 3);
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
        */
        
        PairList<Double> dList = new PairList<Double>();

        System.out.println("-- Testing adding pairs");
        dList.addPair(1.0, 2.0);
        dList.addPair(3.0, 4.0);
        dList.addPair(5.0, 6.0);
        dList.addPair(7.0, 8.0);
        Pair<Double> fifthPair = new Pair<Double>(9.0, 0.0);
        dList.addPair(fifthPair);
        dList.printList();
        System.out.println("--");
        dList.addPair(new Pair<Double>(8.0, 9.0), 0);
        dList.printList();

        System.out.println("Testing get size and contains pair");
        System.out.println("size: " + dList.getSize());
        System.out.println("Contains pair 9, 0: " + dList.containsPair(new Pair<Double>(9.0, 0.0)));
        System.out.println("Contains pair 7, 5: " + dList.containsPair(7.0, 5.0));

        System.out.println("-- Testing get first/second");
        double intF = 1; //please change this value for efficiency
        double intS = 2; //please change this value for efficiency
        Double first = dList.getFirst(intS);
        Double second = dList.getSecond(intF);
        System.out.println(second == null ? "First not found" : "" + second);
        System.out.println(first == null ? "Second not found" : "" + first);

        System.out.println("-- Testing add at index");
        dList.addPair(new Pair<Double>(5.0, 5.0), 2);
        dList.printList();

        System.out.println("-- Testing find occurences");
        System.out.println(dList.occurrences(1.0, true));

        System.out.println("-- Testing get index");
        System.out.println(dList.getIndex(5.0, 6.0));

        System.out.println("-- Testing set index");
        dList.setIndex(new Pair<Double>(67.0, 89.0), 3);
        dList.printList();

        System.out.println("-- Testing deleting pairs");
        dList.deletePair(9.0, 0.0);
        dList.printList();
        System.out.println("--");
        dList.deletePair(3.0, 4.0);
        dList.deletePair(0);
        dList.printList();

        System.out.println("-- Testing clear all");

        dList.clearAll();
        dList.printList();
    }
}