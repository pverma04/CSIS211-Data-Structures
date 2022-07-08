
package unit6;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AvlTree avl = new AvlTree();
        avl.insert(10);
        avl.insert(12);
        avl.insert(13);
        avl.insert(14);
        avl.insert(15);
        avl.insert(1);
        avl.insert(3);
        avl.insert(4);
        avl.insert(8);
        avl.insert(9);
        avl.insert(7);
        avl.insert(17);
        avl.insert(20);
        avl.insert(25);
        avl.printTree();
        System.out.println("After Remove");

        avl.remove(7);
        avl.printTree();
        

        avl.remove(17);
        avl.printTree();
        
        /*
        SearchTree st = new SearchTree();
        st.insert(10);
        
        st.insert(15);

        
        st.insert(20);
        st.insert(12);
        st.insert(25);
        st.insert(9);
        st.printTree();

        
        if (st.contains(20)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        st.printTree();
        
        System.out.println("Remove Node\n");
        st.remove(200);
        st.insert(11);
        st.printTree();

        if (st.contains(20)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        st.printTree(); 
        */

    }
}
