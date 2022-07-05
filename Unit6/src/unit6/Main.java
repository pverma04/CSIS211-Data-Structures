/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit6;

/**
 *
 * @author parthverma
 */
public class Main {

    public static void main(String[] args) {
        SearchTree<Integer> st = new SearchTree();
        st.insert(10);
        st.insert(15);
        st.insert(20);
        st.insert(12);
        st.insert(25);
        if (st.contains(20)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        st.printTree();
        System.out.println("Remove Node\n");
        st.remove(300);
        st.printTree();

        if (st.contains(20))
            System.out.println("Found");
        else
            System.out.println("Not Found");
    }
    
}
