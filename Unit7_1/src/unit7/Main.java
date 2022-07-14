package unit7;
import java.util.Scanner;
import java.io.*;



public class Main {
    public static void main(String[] args) throws IOException {
        Scanner user = new Scanner(System.in);
        String inputFileName, outputFileName;

        // prepare the input file
        System.out.print("Input File Name: ");
        inputFileName = user.nextLine().trim();
        File input = new File(inputFileName);
        Scanner scan = new Scanner(input);
        
        
        
        
        
        /*
        HashTable h = new HashTable();
        h.add("Aa", "1234567890");
        h.add("BB", "(555) 973-1234");
        
        h.add("Noah", "(555) 973-1235");
        h.add("Rene", "(555) 973-2083");
        h.add("Rene", "2");
        h.add("Micheal", "(555) 973-2120");
        h.add("Micheal", "1");
        h.add("Aa", "34");
        
        h.printTable();
        System.out.println("Lookup BB");

        System.out.println(h.lookup("BB"));
        */
    }
}
