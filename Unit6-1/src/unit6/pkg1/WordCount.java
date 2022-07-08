
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

    public String removePunctuations(String source) {
        System.out.println(source);
        String rv = source.replaceAll("[\\p{P}&&[^\u0027]]", " "); //remove all punctation in the string aside from apostrophe
        rv = rv.replaceAll("'", ""); //at every instance of an apostrophe with an empty space
        return rv;
    }

    public void printData() throws IOException {
        String textWOPunct = removePunctuations(this.fileContent).toLowerCase();
        System.out.println(textWOPunct);
        String[] arrWords = textWOPunct.split("\\s+");
        for (String s : arrWords) {
            super.insert((Comparable) s);
        }
        super.printTree();
    }

}
