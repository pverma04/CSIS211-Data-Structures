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
        /*
        LinkedList<Integer> test = new LinkedList<Integer>();
        test.addToEnd(1);
        test.addToEnd(2);
        test.addToEnd(3);
        test.addToEnd(4);
        test.addToEnd(5);
        test.printList();
        System.out.println("--");
        test.insert(1, 7);
        test.printList();
        System.out.println("--");
        test.delete(4);
        test.printList();
        System.out.println("--");
        test.delete(7);
        test.printList();
        System.out.println("--");
        System.out.println(test.contains(10));
        System.out.println("--");
        System.out.println(test.getSize());
        */
        
        PairList<Integer> test1 = new PairList<Integer>();
        test1.addPair(1, 2);
        test1.print();
        //test1.addPair(3, 4);
        //test1.addPair(5, 6);
        //test1.print();

    }
    
}
