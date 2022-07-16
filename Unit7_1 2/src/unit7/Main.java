/**
 * ***********************************************
 * File: Main.java
 * Author: Parth Verma
 * Description: This file contains code for the Main class (Reads from a file
 * and inputs to a HashTable)
 * Date: July 14, 2022
 * ***********************************************
 */
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
            String str; //to read each line
            String name; //to be inputted
            String number; //to be inputted
            String[] data; //will contain name and number
            HashTable ht = new HashTable();
            while ((str = br.readLine()) != null) { //str will be set to null at the end of the file
                data = str.split(";"); //split at the ";", as given in the data file
                name = data[0].trim(); //trim off white-spaces
                number = data[1].trim(); //trim off white-spaces
                ht.add(name, number);
            }
            String option = printMenu(); //print the menu from helper method
            boolean continueLoop = true;

            while (continueLoop) {
                switch (option) {

                    case "1": //user selects to add a person
                        Scanner nameIn = new Scanner(System.in);
                        System.out.print("Please input the Name: ");
                        String newName = nameIn.nextLine();
                        Scanner numIn = new Scanner(System.in);
                        System.out.print("Please input the Number: ");
                        String newNum = numIn.nextLine();
                        ht.add(newName, newNum);

                        if (detContinueLoop()) { //calls helper method to determine if code should continue running, or break the loop
                            option = printMenu(); //saves user's new option choide
                        } else { //if user says "N", terminate
                            continueLoop = false;
                            System.out.println("Thank you! Have a good day");
                        }
                        break;

                    case "2":
                        Scanner searchNameIn = new Scanner(System.in);
                        System.out.print("Please input the Name to search for: ");
                        String searchName = searchNameIn.nextLine();
                        System.out.println(ht.lookup(searchName));

                        if (detContinueLoop()) { //calls helper method to determine if code should continue running, or break the loop
                            option = printMenu(); //saves user's new option choide
                        } else { //if user says "N", terminate
                            continueLoop = false;
                            System.out.println("Thank you! Have a good day");
                        }
                        break;

                    case "3":
                        ht.printTable();

                        if (detContinueLoop()) { //calls helper method to determine if code should continue running, or break the loop
                            option = printMenu(); //saves user's new option choide
                        } else { //if user says "N", terminate
                            continueLoop = false;
                            System.out.println("Thank you! Have a good day");
                        }
                        break;

                    case "4": //autmoatically terminate
                        continueLoop = false;
                        System.out.println("Thank you! Have a good day");
                        break;

                    default:
                        throw new AssertionError();
                }
            }
            br.close();
        } catch (Exception exc) {
            return;
        }
    }

    /**
     * ***********************************************
     * @par Name printMenu
     * @purpose A helper method to print out a menu for use with the HashTable
     * and .txt data file
     * @param [in] : None
     * @return String***********************************************
     */
    public static String printMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease select a number option from the menu\n"
                + "1. Add person and number to table\n"
                + "2. Lookup a person by name in the Table\n"
                + "3. Print table\n"
                + "4. Quit\n");
        String option = input.nextLine(); //user input to be returned
        return option;
    }

    /**
     * ***********************************************
     * @par Name detContinueLoop
     * @purpose A helper method to determine if the program should stop or run
     * (depending on the Y/N input the user gives)
     * @param [in] : None
     * @return Boolean***********************************************
     */
    public static boolean detContinueLoop() {
        Scanner cont = new Scanner(System.in);
        System.out.print("Would you like to continue? Y/N: ");
        if (cont.nextLine().equals("Y")) { //if user selects yes (to continue)
            return true;
        } else {
            return false;
        }
    }
}
