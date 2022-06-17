/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit2;

public class Main {

    /**
     * @param args the command line arguments
     */
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
        intList.addPair(1, 2);
        intList.addPair(1, 4);
        intList.addPair(1, 6);
        intList.addPair(7, 0);
        intList.addPair(9, 0);
        intList.printList();
        intList.deletePair(9, 0);
        System.out.println("--");
        intList.printList();
        //System.out.println(intList.getSize());
        intList.addPair(new Pair<Integer>(8,9),0);
        System.out.println(intList.getSize());
        System.out.println(intList.containsPair(new Pair<Integer>(9,0)));
        System.out.println(intList.containsPair(7,5));
        System.out.println(intList.getSecond(0)==null?"First not found":intList.getSecond(0));
        System.out.println(intList.getFirst(0)==null?"Second not found":intList.getFirst(0));
        System.out.println("-- add at index");
        intList.addPair(new Pair<Integer>(5,5), 9);
        System.out.println("-- Find occurences");

        System.out.println(intList.occurrences(1, true));

        System.out.println("-- remove at index");
        intList.deletePair(4);
        System.out.println(intList.occurrences(9, true));
        
        
        //intList.clearAll();
        intList.printList();
    }
}
