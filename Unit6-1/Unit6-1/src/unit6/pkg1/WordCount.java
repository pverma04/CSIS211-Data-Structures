/**
 * ***********************************************
 * File: WordCount.java
 * Author: Parth Verma
 * Description: This file contains code for the Word Count class 
 * (extends AvlTree)
 * Date: July 10, 2022
 * ***********************************************
 */
package unit6.pkg1;

import java.io.FileReader;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

public class WordCount<T> extends AvlTree {

    File f;
    //Scanner input;
    String fileContent;

    public WordCount(String filename) {
        this.f = new File(filename);
        Path p = Paths.get(System.getProperty("user.dir") + "/" + this.f);
        try {
            this.fileContent = Files.readString(p);
        } catch (IOException exc) {
            System.out.println("wrong path");
            return;
        }
    }

    /**
     * ***********************************************
     * @par Name removePunctuations
     * @purpose A helper method to remove all punctuation from the source file's
     * content, and return the "cleaned up" string
     * @param [in] : String source (Contents of the string before punctuation
     * removal)
     * @return String***********************************************
     */
    public String removePunctuations(String source) {
        /* System.out.println(source); */
        String rv = source.replaceAll("[\\p{P}&&[^\u0027]]", " "); //remove all punctation in the string aside from apostrophe
        rv = rv.replaceAll("'", ""); //at every instance of an apostrophe with an empty space
        return rv;
    }

    /**
     * ***********************************************
     * @par Name removePunctuations
     * @purpose A helper method to remove all punctuation from the source file's
     * content, and return the "cleaned up" string
     * @param [in] : String source (Contents of the string before punctuation
     * removal)
     * @return String***********************************************
     */
    public void printData() throws IOException {
        String textWOPunct = removePunctuations(this.fileContent).toLowerCase(); //contents of the file w/o punctuation 
        /* System.out.println(textWOPunct); */
        String[] arrWords = textWOPunct.split("\\s+"); //split string at every white space
        for (String s : arrWords) {
            super.insert((Comparable) s); //insert s if not already found in the tree (if found, super.insert will automatcially update the count)
        }
        super.printTree();
    }

}
