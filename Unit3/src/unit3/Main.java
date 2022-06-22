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
        System.out.println("----------");
        test1.addPair(1, 2);
        test1.addPair(3, 4);
        test1.insert(new Pair(1, 2), new Pair(5, 6));
        test1.printList();
        System.out.println("----------");
        test1.delete(new Pair(1, 2));
        test1.printList();

        
        
        
        
        
        
        
        
        
        
        /*
        //Here is an example of the LinkedList insert method working as expected
       
        System.out.println("----------");
        //test1.addPair(10, 11, new Pair(3, 4));// addPair(T data,
        LinkedList<Integer> lL = new LinkedList<Integer>();
        lL.addToEnd(1);
        lL.addToEnd(2);
        lL.printList();
        System.out.println("----------");
        lL.insert(1, 3);
        lL.printList();
        System.out.println("----------");
        lL.delete(1);
        lL.printList();
        */

    }
}
