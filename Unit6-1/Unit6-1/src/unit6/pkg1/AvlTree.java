/**
 * ***********************************************
 * File: AvlTree.java
 * Author: Parth Verma
 * Description: This file contains code for the AvlTree class (uses AvlNode)
 * Date: July 10, 2022
 * ***********************************************
 */
package unit6.pkg1;

public class AvlTree <T extends Comparable<T>> {
    AvlNode root;
    
    public AvlTree() {
        this.root = null;
    }
    
    /**
     * ***********************************************
     * @par Name height
     * @purpose A helper method that will return the height of a given Node
     * @param [in] : AvlNode n
     * @return Int***********************************************
     */
    private int height (AvlNode n) {
        return (n == null) ? 0 : n.mHeight;
    }
    
    /**
     * ***********************************************
     * @par Name updateHeight
     * @purpose A helper method that will update the height of a given Node
     * @param [in] : AvlNode n
     * @return Void***********************************************
     */
    private void updateHeight(AvlNode n) {
        n.mHeight = Math.max(height(n.mLeft), height(n.mRight)) +1; //max of right and left is the height (add one to account for the root node as well)
    }
    
    /**
     * ***********************************************
     * @par Name rightRotate
     * @purpose Given a left-heavy root AvlNode, this method will rotate this
     * tree once to the right
     * @param [in] : AvlNode a
     * @return AvlNode (root of the rotated
     * tree)***********************************************
     */
    private AvlNode rightRotate(AvlNode a) {
        AvlNode b = a.mLeft; //to become the new root
        AvlNode subT = b.mRight; //everything to follow (T2 will represent the "root") that will be carried in the same position
        b.mRight = a; //switching
        a.mLeft = subT; //switching
        updateHeight(a);
        updateHeight(b);
      
        return b; //the new root
    }
    
    /**
     * ***********************************************
     * @par Name leftRotate
     * @purpose Given a right-heavy root AvlNode, this method will rotate this
     * tree once to the left
     * @param [in] : AvlNode a
     * @return AvlNode (root of the rotated
     * tree)***********************************************
     */
    private AvlNode leftRotate(AvlNode a) {
        AvlNode b = a.mRight; //to become the new root
        AvlNode T2 = b.mLeft; //everything to follow (T2 will represent the "root") that will be carried in the same position
        b.mLeft = a; //switching
        a.mRight = T2; //switching
        updateHeight(a);
        updateHeight(b);
        
        return b; //the new root
    }
    
    /**
     * ***********************************************
     * @par Name getBalance
     * @purpose Given a root Node of a tree, return the balance factor
     * @param [in] : AvlNode n
     * @return int (difference between left and right branch
     * heights)***********************************************
     */
    private int getBalance(AvlNode n) {
        return (n == null) ? 0 : height(n.mLeft) - height(n.mRight); //left - right for height
    }
    
    /**
     * ***********************************************
     * @par Name insert
     * @purpose Add a new node with the given data to the correct position of
     * the tree (runs the private method)
     * @param [in] : T data
     * @return void***********************************************
     */
    public void insert(T data) {
        this.root = this.insert(this.root, data);
    }
    
    /**
     * ***********************************************
     * @par Name insert
     * @purpose Add a new node with the given data to the correct position of
     * the tree given its root node, and balances the tree
     * @param [in] : AvlNode n, T data
     * @return AvlNode(the root with the inserted
     * data)***********************************************
     */
    private AvlNode insert(AvlNode n, T data) {
        if (n == null) { //new AvlNode is the only node in the list, just retunn that as the root
            return (new AvlNode(data));
        } else if (data.compareTo((T) n.mData) < 0) { //going to the left
            n.mLeft = insert(n.mLeft, data); //recurse
        } else if (data.compareTo((T) n.mData) > 0) { //going to the right
            n.mRight = insert(n.mRight, data); //recurse
        } else { //if the data already exists in an AvlNode, don't add it. Return the original root, but update the count of the node
            n.mCount++;
            return n;
        }
        updateHeight(n);
        
        int bal = getBalance(n);
        
        if (bal > 1 && data.compareTo((T) n.mLeft.mData) < 0) { //left case
            return rightRotate(n);
        } if (bal < -1 && data.compareTo((T) n.mRight.mData) > 0) { //right case
            return leftRotate(n);
        } if (bal > 1 && data.compareTo((T) n.mLeft.mData) > 0) { //left-right case
            n.mLeft = leftRotate(n.mLeft);
            return rightRotate(n);
        } if (bal < -1 && data.compareTo((T) n.mRight.mData) < 0) { //right-left case
            n.mRight = rightRotate(n.mRight);
            return leftRotate(n);
        } else { //if tree was already balanced
            return n;
        }
    }
    
    /**
     * ***********************************************
     * @par Name minValueNode
     * @purpose Returns the node with the smallest value in the tree
     * @param [in] : AvlNode n
     * @return AvlNode(the node with the smallest
     * data)***********************************************
     */
    private AvlNode minValueNode(AvlNode n) {
        AvlNode r = n; //reference node
        while (r.mLeft != null) { //traverse left side to find smallest data
            r = r.mLeft;
        }
        return r;
    }
    
    /**
     * ***********************************************
     * @par Name maxValueNode
     * @purpose Returns the node with the largest value in the tree
     * @param [in] : AvlNode n
     * @return AvlNode(the node with the largest
     * data)***********************************************
     */
    private AvlNode maxValueNode(AvlNode n) {
        AvlNode r = n; //reference node

        while (r.mRight != null) { //traverse right side to find greatest data
            r = r.mRight;
        }
        return r;
    }
    
    /**
     * ***********************************************
     * @par Name deleteNode
     * @purpose Removes the given data from the tree if found (runs the private
     * method)
     * @param [in] : T data
     * @return Void***********************************************
     */
    public void deleteNode(T data) {
        this.root = this.deleteNode(this.root, data);
    }
    
    /**
     * ***********************************************
     * @par Name deleteNode
     * @purpose Searches for and removes the node with the given data from the 
     * tree given its root and balances the tree
     * @param [in] : AvlNode n, T data
     * @return AVlNode (root of the tree with the node removed)***********************************************
     */
    private AvlNode deleteNode(AvlNode n, T data) {
        if (n == null) { //if null then empty tree, return null
            return n;
        } else if (data.compareTo((T) n.mData) < 0) { //go down left side
            n.mLeft = deleteNode(n.mLeft, data);
        } else if (data.compareTo((T) n.mData) > 0) { //go down right side
            n.mRight = deleteNode(n.mRight, data);
        } else { //if not greater or less than data, we have found the node to be deleted
            if ((n.mLeft == null) || (n.mRight == null)) { //one or no children
                AvlNode temp = null;

                if (temp == n.mLeft) { //determine node to hold as temp
                    temp = n.mRight;
                } else {
                    temp = n.mLeft;
                }

                if (temp == null) { //if no children
                    temp = n;
                    n = null;
                } else { //for one child case, set root node = temp
                    n = temp;
                }
            } else { //2 children
                AvlNode temp = minValueNode(n.mRight);
                n.mData = temp.mData;
                n.mRight = deleteNode(n.mRight, (T) temp.mData);
            }
        }

        if (n == null) { //if tree root was null, there is nothing to delete (root stays null and unchanged)
            return n;
        }

        updateHeight(n);
        int bal = getBalance(n);

        if (bal > 1 && getBalance(n.mLeft) >= 0) { //left case
            return rightRotate(n);
        }
        if (bal < -1 && getBalance(n.mRight) <= 0) { //right case
            return leftRotate(n);
        }
        if (bal > 1 && getBalance(n.mLeft) < 0) { //left-right case
            n.mLeft = leftRotate(n.mLeft);
            return rightRotate(n);
        }
        if (bal < -1 && getBalance(n.mRight) > 0) { //right-right case
            n.mRight = rightRotate(n.mRight);
            return leftRotate(n);
        } else { //if tree is balanced already
            return n;
        }
    }
    
    /**
     * ***********************************************
     * @par Name printTree
     * @purpose Prints all contents of the tree (uses the private method)
     * @param [in] : None
     * @return Void***********************************************
     */
    public void printTree() {
        //System.out.println("root = " + this.root.mData);
        this.printTree(this.root);
    }

    /**
     * ***********************************************
     * @par Name printTree
     * @purpose Traverses through the tree given its root node and prints all 
     * contents of the tree
     * @param [in] : AvlNode n
     * @return Void***********************************************
     */
    private void printTree(AvlNode n) {
        if (n != null) { //if tree isnt empty
            System.out.println(n.mData + " -- count: " + n.mCount);
            /* print with additional funcationality
            System.out.println(n.mData + " count " + n.mCount + " height " + n.mHeight + " left: " + (n.mLeft == null ? "null" : n.mLeft.mData) + " right: " + (n.mRight == null ? "null" : n.mRight.mData));
            */
            this.printTree(n.mLeft); //traverse through left
            this.printTree(n.mRight); //traverse through right
        }
    }
    
    /**
     * ***********************************************
     * @par Name contains
     * @purpose Traverses through the tree and returns whether the given data 
     * was found to match the data of a Node in the tree 
     * @param [in] : T data
     * @return Boolean***********************************************
     */
    public boolean contains(T data) {
        AvlNode n = this.root;
        if (n != null) { //populated tree
            while(n != null) {
                if (data.compareTo((T) n.mData) > 0) { //data is less than current n.mData
                    n = n.mRight;
                } else if (data.compareTo((T) n.mData) < 0) { //data is greater than current n.mData
                    n = n.mLeft;
                } else { //data is equal to current n.mData
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * ***********************************************
     * @par Name isTreeEmpty
     * @purpose A helper method to determine whether the tree is populated or 
     * empty
     * @param [in] : None
     * @return Boolean***********************************************
     */
    public boolean isTreeEmpty() {
        return this.root == null;
    }
    
    /**
     * ***********************************************
     * @par Name makeEmpty
     * @purpose A helper method to depopulate the tree
     * @param [in] : None
     * @return Void***********************************************
     */
    public void makeEmpty() {
        this.root = null;
    }
    
}
