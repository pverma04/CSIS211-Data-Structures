/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit0assignment1;
import java.util.Scanner;

/**
 *
 * @author parthverma
 */
public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[5];
        getPeople(people);
        
    }
    public static void getPeople(Person[] p){
        for(int i = 0; i < p.length; i ++){
            Scanner scanFirst = new Scanner(System.in);
            System.out.println("First name: ");
            String fName = scanFirst.next();
            Scanner scanLast = new Scanner(System.in);
            System.out.println("Last name: ");
            String lName = scanLast.next();
            Scanner scanAddress = new Scanner(System.in);
            System.out.println("Address: ");
            String address = scanAddress.next();
            p[i] = new Person(fName, lName, address);
        }
    }
    public static void printPeople(Person[] p){
        for(int i = 0; i < p.length; i ++){
            System.out.println("Person " + (int) (i + 1) + ":");
            System.out.println("Name: " + p[i].getFirstName() + " " + p[i].getLastName());
            System.out.println("Address: " + p[i].getAddress());
        }
    }
}
