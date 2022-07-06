/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit6;

import java.io.IOException;

/**
 *
 * @author parthverma
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        WordCount w = new WordCount("wordCountTest.txt");
        w.print();
    }
}
