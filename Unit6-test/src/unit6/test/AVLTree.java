package unit6.test;


import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {
	Node<T> root;

	public AVLTree() {
		root = null;
	}

	public T Maximum() {
		Node<T> local = root;
		if (local == null)
			return null;
		while (local.getRight() != null)
			local = local.getRight();
		return local.getData();
	}

	public T Minimum() {
		Node<T> local = root;
		if (local == null)
			return null;
		while (local.getLeft() != null) {
			local = local.getLeft();
		}
		return local.getData();
	}

	private int depth(Node<T> node) {
		if (node == null)
			return 0;
		return node.getDepth();
		// 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
	}

	public Node<T> insert(T data) {
		root = insert(root, data);
		switch (balanceNumber(root)) {
		case 1:
			root = rotateLeft(root);
			break;
		case -1:
			root = rotateRight(root);
			break;
		default:
			break;
		}
		return root;
	}

	public Node<T> insert(Node<T> node, T data) {
		if (node == null)
			return new Node<T>(data);
		if (node.getData().compareTo(data) > 0) {
			node = new Node<T>(node.getData(), insert(node.getLeft(), data),
					node.getRight());
			// node.setLeft(insert(node.getLeft(), data));
		} else if (node.getData().compareTo(data) < 0) {
			// node.setRight(insert(node.getRight(), data));
			node = new Node<T>(node.getData(), node.getLeft(), insert(
					node.getRight(), data));
		}
		// After insert the new node, check and rebalance the current node if
		// necessary.
		switch (balanceNumber(node)) {
		case 1:
			node = rotateLeft(node);
			break;
		case -1:
			node = rotateRight(node);
			break;
		default:
			return node;
		}
		return node;
	}

	private int balanceNumber(Node<T> node) {
		int L = depth(node.getLeft());
		int R = depth(node.getRight());
		if (L - R >= 2)
			return -1;
		else if (L - R <= -2)
			return 1;
		return 0;
	}
        
        //public void rotateLeft() {
        //    this.root = this.rotateLeft(this.root);
        //}
/*
        private Node rotateLeft(Node n) { //the imbalance begins at Node n and is left heavy //works opposite as rotateR
            Node x = n.right;
            Node y = x.left;
            x.left = n;
            n.right = y;
            
            //updateHeight(x);
            //updateHeight(n);
            return x;
        }
        */
        
	private Node<T> rotateLeft(Node<T> node) {
		Node<T> q = node;
		Node<T> p = q.getRight();
		Node<T> c = q.getLeft();
		Node<T> a = p.getLeft();
		Node<T> b = p.getRight();
		q = new Node<T>(q.getData(), c, a);
		p = new Node<T>(p.getData(), q, b);
		return p;
	}
        
        //public void rotateRight() {
          //  this.root = this.rotateRight(this.root);
        //}
        /*
        private Node rotateRight(Node n) { //the imbalance begins at Node n and is left heavy
            Node x = n.left;
            Node y = x.right;
            x.right = n;
            n.left = y;
            //updateHeight(x);
            //updateHeight(n);
            return x;
        }
        */
        
	private Node<T> rotateRight(Node<T> node) {
		Node<T> q = node;
		Node<T> p = q.getLeft();
		Node<T> c = q.getRight();
		Node<T> a = p.getLeft();
		Node<T> b = p.getRight();
		q = new Node<T>(q.getData(), b, c);
		p = new Node<T>(p.getData(), a, q);
		return p;
	}
        
	public boolean search(T data) {
		Node<T> local = root;
		while (local != null) {
			if (local.getData().compareTo(data) == 0)
				return true;
			else if (local.getData().compareTo(data) > 0)
				local = local.getLeft();
			else
				local = local.getRight();
		}
		return false;
	}

	public String toString() {
		return root.toString();
	}

	   public void printTree() {
        System.out.println("root=" + this.root.data);
        //n.data + " count " + n.count + " height " + n.height + " left: " + (n.left == null ? "null" : n.left.data) + " right: " + (n.right == null ? "null" : n.right.data));

        this.printTree(this.root);
    }

    private void printTree(Node n) {
        if (n != null) { //if tree isnt empty
            System.out.println(n.data + " left: " + (n.left == null ? "null" : n.left.data) + " right: " + (n.right == null ? "null" : n.right.data));

            this.printTree(n.left); //traverse through left
            this.printTree(n.right); //traverse through right
        }
    }
}