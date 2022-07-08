
package unit6test2;

/**
 *
 * @author parthverma
 */
public class Unit6test2 {

    
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insertNode(tree.root, 10);
        tree.root = tree.insertNode(tree.root, 12);
        tree.root = tree.insertNode(tree.root, 13);
        tree.root = tree.insertNode(tree.root, 14);
        tree.root = tree.insertNode(tree.root, 15);
        tree.root = tree.insertNode(tree.root, 1);
        tree.root = tree.insertNode(tree.root, 3);
        tree.root = tree.insertNode(tree.root, 4);
        tree.root = tree.insertNode(tree.root, 8);
        tree.root = tree.insertNode(tree.root, 9);
        tree.root = tree.insertNode(tree.root, 7);
        tree.root = tree.insertNode(tree.root, 17);
        tree.root = tree.insertNode(tree.root, 20);
        tree.root = tree.insertNode(tree.root, 25);
        tree.printTree();
        System.out.println("After Remove");

        //avl.remove(52);
        tree.printTree();
        /*
        AVLTree tree = new AVLTree();
        tree.root = tree.insertNode(tree.root, 33);
        tree.root = tree.insertNode(tree.root, 13);
        tree.root = tree.insertNode(tree.root, 53);
        tree.root = tree.insertNode(tree.root, 9);
        tree.root = tree.insertNode(tree.root, 21);
        tree.root = tree.insertNode(tree.root, 61);
        tree.root = tree.insertNode(tree.root, 8);
        tree.root = tree.insertNode(tree.root, 11);
        tree.printTree();
        tree.root = tree.deleteNode(tree.root, 13);
        System.out.println("After Deletion: ");
        tree.printTree();
        */
    }
    
}
