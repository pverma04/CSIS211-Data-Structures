package unit9;

public class LinkedList<T> {

    Node mHead;
    Node mTail;

    public LinkedList() {

    }

    /**
     * ***********************************************
     * @par Name addToEnd
     * @purpose Adds the given data to the end of the Linked List
     * @param [in] : T data
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void addToEnd(T data) {
        Node add = new Node(data);
        if (this.mHead == null) {
            this.mHead = add;
            this.mTail = add;
        } else {
            this.mTail.mNext = add;
            this.mTail = add;
        }
    }

//    /**
//     * ***********************************************
//     * @par Name printList
//     * @purpose Prints the contents of the LinkedList in order
//     * @param [in] : None
//     * @return None ***********************************************
//     */
    public void printList() {
        Node p = this.mHead; //to traverse
        if (p != null) {
            while (p != null) { //traverse all the way to the end
                System.out.print("" + p.mData + " -> ");
                p = p.mNext;
            }
            System.out.print("||");
        } else {
            System.out.println("Empty List");
        }
    }

    /**
     * ***********************************************
     * @par Name getHead
     * @purpose Returns head node of the linked list
     * @param [in] : None
     * @return Node ***********************************************
     */
    public Node getHead() {
        return this.mHead;
    }

    /**
     * ***********************************************
     * @par Name getTail
     * @purpose Returns tail node of the linked list
     * @param [in] : None
     * @return Node ***********************************************
     */
    public Node getTail() {
        return this.mTail;
    }
    
}
