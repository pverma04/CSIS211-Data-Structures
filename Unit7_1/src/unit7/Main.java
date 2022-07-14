package unit7;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Hashdata.txt")); //open file to read
            String str;
            String name;
            String number;
            String[] data;
            HashTable ht = new HashTable();
            while ((str = br.readLine()) != null) { //str will be set to null at the end of the file
                data = str.split(";");
                name = data[0].trim();
                number = data[1].trim();
                //System.out.println(name + " " + number + " " + ht.hashFunc(name));
                ht.add(name, number);
            }
            String option = printMenu();
            Scanner cont = null;
            String answer;
            boolean continueLoop = true;
            while (continueLoop) {
                switch (option) {
                    case "1":
                        Scanner nameIn = new Scanner(System.in);
                        System.out.print("Please input the Name: ");
                        String newName = nameIn.nextLine();
                        Scanner numIn = new Scanner(System.in);
                        System.out.print("Please input the Number: ");
                        String newNum = numIn.nextLine();
                        ht.add(newName, newNum);
                        
                        if(detContinueLoop()) {
                            option = printMenu();
                            
                        } else {
                            continueLoop = false;
                            System.out.println("Thank you! Have a good day");
                        }
                        /*
                        cont = new Scanner(System.in);
                        System.out.print("Would you like to continue? Y/N: ");
                        answer = cont.nextLine();
                        if(answer.equals("Y")) {
                            option = printMenu();
                        } else {
                            System.out.println("Thank you! Have a good day");
                            continueLoop = false;
                        }
                        */
                        break;

                    case "2":
                        Scanner searchNameIn = new Scanner(System.in);
                        System.out.print("Please input the Name to search for: ");
                        String searchName = searchNameIn.nextLine();
                        System.out.println(ht.lookup(searchName));
                        
                        cont = new Scanner(System.in);
                        System.out.print("Would you like to continue? Y/N: ");
                        answer = cont.nextLine();
                        if (answer.equals("Y")) {
                            option = printMenu();
                        } else {
                            System.out.println("Thank you! Have a good day");
                            continueLoop = false;
                        }
                        break;

                    case "3":
                        ht.printTable();
                        
                        if (detContinueLoop()) {
                            option = printMenu();

                        } else {
                            continueLoop = false;
                            System.out.println("Thank you! Have a good day");
                        }
                        break;
                        
                    case "4":
                        continueLoop = false;
                        System.out.println("Thank you! Have a good day");

                        break;

                    default:
                        throw new AssertionError();
                } 
            }
            //br.close(); //close file
        } catch (Exception exc) {
            return;
        }
        
    }
    public static String printMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nPlease select a number option from the menu\n"
                + "1. Add person and number to table\n"
                + "2. Lookup a person by name in the Table\n"
                + "3. Print table\n"
                + "4. Quit\n");
        String option = input.nextLine();
        return option;
    }
    public static boolean detContinueLoop () {
        Scanner cont = null;
        String answer;
        boolean continueLoop = true;
        cont = new Scanner(System.in);
        System.out.print("Would you like to continue? Y/N: ");
        answer = cont.nextLine();
        if (answer.equals("Y")) {
            //option = printMenu();
            return true;
        } else {
            //System.out.println("Thank you! Have a good day");
            return false;
        }
    }
}