/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit1;
import java.io.*;  
import java.util.*;  
import java.util.Scanner;

/**
 *
 * @author parthverma
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            BigDecimal a = new BigDecimal("1.0");
            BigDecimal b = new BigDecimal("1.8000");
            System.out.println("new a " + a.toString());
            System.out.println(b.toString());
            
            System.out.println("Sum="+a.add(b).toString());
            //System.out.println("Subtraction="+a.sub(b).toString());
        }
        catch(BigDecimalException bDE){
            System.out.println(bDE.getMessage());
        }
        catch(CharException cE){
            System.out.println(cE.getMessage());
        }
        
        
        
        /*
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
        */
        
    }
}
