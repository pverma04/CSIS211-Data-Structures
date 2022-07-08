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
        AvlTree avl = new AvlTree();
        avl.insert(23);
        avl.insert(18);
        avl.insert(44);
        avl.insert(6);
        avl.insert(12);
        avl.insert(52);
        avl.insert(14);
        avl.insert(8);
        avl.insert(14);

        avl.printTree();
        System.out.println("After Remove");

        avl.remove(52);
        avl.printTree();
    }
}
