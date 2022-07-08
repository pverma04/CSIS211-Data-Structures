/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unit6.pkg1;

/**
 *
 * @author parthverma
 */
public class Node<T> {

    T data;

    Node left;
    Node right;

    public Node() {
        this(null);
    }

    public Node(T data) {
        this.data = data;
    }
}
