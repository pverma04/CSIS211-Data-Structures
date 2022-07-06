
package unit6;

import java.io.FileReader;
import java.util.Scanner;
import java.io.*;

public class WordCount<T> extends AvlTree {
    File f;
    Scanner input;
    
    public WordCount(String filename){
        this.f = new File(filename);
        try{
            this.input = new Scanner(f);
        } catch(FileNotFoundException ex) {
            return;
        }
    }
    
    public void count() throws IOException{
        try {
            System.out.println((System.getProperty("user.dir") + "/" + this.f));
            StreamTokenizer t = new StreamTokenizer(new BufferedReader(new InputStreamReader(new FileInputStream((System.getProperty("user.dir") + "/" + this.f)))));
            
            t.eolIsSignificant(false); //do not count end of line as a token
            t.lowerCaseMode(true); //turn all words into lower case for comparision
            t.wordChars('a', 'z'); //all words can contain anything from a - z (lowercase) in the alphabet
            t.wordChars('A', 'Z'); //all words can contain anything from A - Z (uppercase) in the alphabet
            String specialCharacters = ".,!;:-*+?-=\\|/\"[](){}>< \t"; //all special characters that can appear in the file (these are to be ignored)
            for (int i = 0; i < specialCharacters.length(); i++) { //whitespaceChars will seperate the tokens by whitespaces at any and all special characters that may appear
                t.whitespaceChars(specialCharacters.charAt(i), specialCharacters.charAt(i)); 
            }
            while (t.nextToken() != StreamTokenizer.TT_EOF) { //while the next token is NOT the end of file (EOF)
                System.out.println(t.sval);
                super.insert((Comparable) t.sval);
            }
            super.printTree();
        } catch (FileNotFoundException ex) {
            System.out.println("not found");
            return;
        }
    }
    
}
