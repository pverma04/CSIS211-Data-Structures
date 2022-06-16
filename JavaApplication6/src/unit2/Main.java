/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit2;


/**
 *
 * @author parthverma
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int int1 = 4;
        int int2 = 5;
        String str1 = "hello";
        String str2 = "world"; 
        Pair strP = new Pair(str1, str2);
                
        Pair a = new Pair(int1, int2);
        PairList<Integer> intList = new PairList<Integer>();
        intList.addPair(a);
        PairList<String> strList = new PairList<String>();
        
        strList.addPair(str1, str2);
        strList.addPair("bye", "everyone");
        strList.addPair("my", "name");
        //list.addPair("bye", "test");
        //list.addPair("hi", "ok");
        //System.out.println(list.getSecond("hello"));
        //System.out.println(list.getFirst("test"));
        System.out.println(strList.getSecond("hello"));
        strList.printList();
        //strList.deletePair(1);
        System.out.println("--");
        strList.printList();
        System.out.println("--");
        strList.addPair(new Pair("testing", "add"), 2);
        strList.printList();
        System.out.println(strList.getIndex("hey", "guys"));
    }
}
