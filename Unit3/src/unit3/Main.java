/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit3;

/**
 *
 * @author parthverma
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        PairList<Integer> test1 = new PairList<Integer>();
        test1.addPair(1, 2);
        test1.addPair(3, 4);
        test1.addPair(5, 6);
        test1.addPair(1, 10);
        test1.addPair(new Pair(1, 10));
        test1.insert(new Pair(5, 6), new Pair(7, 8));
        test1.insert(new Pair(1, 10), new Pair(9, 8));

        test1.printList();
        System.out.println("--");
        test1.insertAtIndex(new Pair(3.1, 4.4), 10);
        test1.printList();
        System.out.println("--");
        System.out.println(test1.getSecond(5));
        System.out.println("--occur");
        System.out.println("" + test1.occurences(1, true));
        System.out.println("--delete pair");
        test1.delete(new Pair(1, 10));
        test1.printList();
        System.out.println("--delete index");
        test1.deleteIndex(2);
        test1.printList();


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
    }
}
