/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit6.pkg1;

import java.io.IOException;

/**
 *
 * @author parthverma
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AvlTree tree = new AvlTree();

        
        tree.insert(9);
        tree.insert(5);
        tree.insert(10);
        tree.insert(0);
        tree.insert(6);
        tree.insert(11);
        tree.insert(-1);
        tree.insert(1);
        tree.insert(2);
        /* The constructed AVL Tree would be
        9
        / \
        1 10
        / \ \
        0 5 11
        / / \
        -1 2 6
         */
        
        System.out.println("Preorder traversal of "
                + "constructed tree is : ");
        tree.printTree();
        
        tree.deleteNode(10);
        tree.deleteNode(6);
        
        System.out.println("");
        System.out.println("Preorder traversal after "
                + "deletion of 10 :");
        tree.printTree();
        tree.insert(8);
        tree.printTree();
        
        WordCount w = new WordCount("wordCountTest.txt");
        try{
            w.printData();
        } catch (IOException ex){
            System.out.println("file not found");
            return;
        }
    }
    
}
