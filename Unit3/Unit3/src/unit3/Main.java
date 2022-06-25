/** ***********************************************
 * File: Main.java
 * Author: Parth Verma
 * Description: This file contains code for the Main class of unit 3
 * Date: June 23, 2022
 ************************************************ */
package unit3;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        
        test1.addPair(1, 2);
        test1.addPair(3, 4);
        //test1.addPair(5, 6);
        test1.printList();
        */
        
        //PairList<Integer> test1 = new PairList<Integer>();
        
        
       
        /*
        System.out.println("--");
        test1.printList();
        System.out.println("--");
        test1.addPair(new Pair(11, 12));
        test1.printList();
        System.out.println( test1.contains(new Pair(1, 10)));
        System.out.println("--");
        System.out.println(test1.getFirstPair().toString());
        System.out.println(test1.getLastPair().toString());
        */
        
        
        PairList<String> test1 = new PairList<String>();
        test1.addPair("1", "2");
        test1.addPair("3", "4");
        test1.addPair("5", "6");
        test1.addPair("1", "10");
        test1.addPair(new Pair("1", "10"));
        test1.insert(new Pair("5", "6"), new Pair("7", "8"));
        test1.insert(new Pair("1", "10"), new Pair("9", "8"));
        test1.printList();
        System.out.println("--");
        
        test1.insertAtIndex(new Pair("3.1", "4.4"), 10);
        test1.printList();
        System.out.println("--");
        
        System.out.println(test1.getSecond("5"));
        
        System.out.println("--occur");
        System.out.println("" + test1.occurrences("1", true));
        
        System.out.println("--delete pair");
        test1.delete(new Pair("1", "10"));
        test1.printList();
        
        System.out.println("--delete index");
        test1.deleteIndex(2);
        test1.printList();
        
        System.out.println(test1.getSize());
        System.out.println("--contains " + test1.contains(new Pair("3.1", "4.4")));
    }
}
