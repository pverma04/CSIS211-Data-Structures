/*************************************************
 * File: Char.java
 * Author: Parth Verma
 * Description: This main file contains code for running the Char and BigDecimal classes, along with reading (numbers.txt) and writing (wholeNumber.txt and fraction.txt) to .txt files
 * Date: June 6, 2022
*************************************************/
package unit1;
import java.io.*;  
import java.util.*;  
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            String bigDecStr1 = "1.0";
            String bigDecStr2 = "1.8000";
            BigDecimal bigDec1 = new BigDecimal(bigDecStr1);
            BigDecimal bigDec2 = new BigDecimal(bigDecStr2);
            System.out.println("BigDecimal 1 = " + bigDec1.toString());
            System.out.println("BigDecimal 2 = " + bigDec2.toString());
            
            System.out.println("Sum = " + bigDec1.add(bigDec2).toString());
            System.out.println("Difference = " + bigDec1.sub(bigDec2).toString());
        }
        catch(BigDecimalException bDE){
            System.out.println(bDE.getMessage());
        }
        catch(CharException cE){
            System.out.println(cE.getMessage());
        }
        
        
        //code for reading numbers.txt and writing to fraction.txt and wholeNumbers.txt
        
        ArrayList<BigDecimal> inputBD = new ArrayList<BigDecimal>();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/Numbers.txt")); //open file to read
            String str;
            while ((str = br.readLine()) != null) { //str will be set to null at the end of the file
                inputBD.add(new BigDecimal(str)); //add line to AL
            } 
            br.close(); //close file
        }
        catch(Exception exc){
            return;
        }
        //creating and writing to new files (wholeNumber.txt and fraction.txt)
        try{
            PrintWriter pwWholeNumbers = new PrintWriter(new FileWriter("wholeNumbers.txt"));
            PrintWriter pwFraction = new PrintWriter(new FileWriter("fraction.txt"));
            
            for(int i = 0; i < inputBD.size(); i++){
                    pwWholeNumbers.println("" + inputBD.get(i).wholeNumber());
                    pwFraction.println("" + inputBD.get(i).fraction() );
            }
            pwWholeNumbers.close();
            pwFraction.close();
        }
        catch(Exception exc){
                return;
        }
    }
}
