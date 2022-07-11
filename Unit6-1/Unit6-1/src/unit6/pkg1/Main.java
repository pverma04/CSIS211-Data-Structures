/**
 * ***********************************************
 * File: Main.java
 * Author: Parth Verma
 * Description: This file contains code for the Main class of unit 6
 * Date: July 10, 2022
 * ***********************************************
 */
package unit6.pkg1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        WordCount w = new WordCount("wordCountTest.txt"); //file name can be changed and be found in user directory
        try{
            w.printData();
        } catch (IOException ex){
            System.out.println("file not found");
            return;
        }
    }
    
}
