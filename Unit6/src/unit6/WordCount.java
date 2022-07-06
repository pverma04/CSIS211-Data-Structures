package unit6;

import java.io.FileReader;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

public class WordCount<T> extends AvlTree {
    File f;
    //Scanner input;
    String fileContent;
    
    public WordCount(String filename){
        this.f = new File(filename);
        Path p = Paths.get(System.getProperty("user.dir") + "/" + this.f);
        try{
            this.fileContent = Files.readString(p);
        } catch (IOException exc){
            System.out.println("wrong path");
            return;
        }
    }
    public String removePunctuations(String source) {
        System.out.println(source);
        String rv = source.replaceAll("[\\p{P}&&[^\u0027]]", " "); //remove all punctation in the string aside from apostrophe
        rv = rv.replaceAll("'", ""); //at every instance of an apostrophe with an empty space
        return rv;
    }
    
    public void print() throws IOException{
        /*
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
        */
        
        String textWOPunct = removePunctuations(this.fileContent);
        System.out.println(textWOPunct);
        String[] arrWords = textWOPunct.split("\\s+");
        for(String s : arrWords){
            super.insert((Comparable) s);
        }
        super.printTree();
    }
    
}
