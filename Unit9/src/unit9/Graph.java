package unit9;

import java.util.*;

public class Graph<T> {

    ArrayList<LinkedList<T>> mVertList;
    static int mTABLE_SIZE = 53;

    public Graph() {
        this(mTABLE_SIZE);
    }

    public Graph(int size) {
        this.mTABLE_SIZE = size;
        mVertList = new ArrayList<LinkedList<T>>(mTABLE_SIZE);
        for (int i = 0; i < mTABLE_SIZE; i++) {
            mVertList.add(null);
        }
    }

    private int hashFunc(String str) {
        return Math.abs(str.hashCode() % mTABLE_SIZE);
    }

    public void insert(String sourceCity, String destinationCity) {
        int pos = this.hashFunc(sourceCity);
        LinkedList listAtPos = this.mVertList.get(pos);
        int count = pos;
        if (listAtPos == null) { //list is empty at pos, add src and then dest city
            listAtPos = new LinkedList();
            listAtPos.addToEnd(sourceCity);
            listAtPos.addToEnd(destinationCity);
        } else { //pos has SOME linked list
            if (listAtPos.getHead().mData.equals(sourceCity)) { //if the head of listAtPos is src city, add dest city
                listAtPos.addToEnd(destinationCity);
            } else { //if the head of listAtPos is NOT src city, then move to next open spot (linear traversing)
                for (int i = pos + 1; i < mTABLE_SIZE; i++) {
                    count = i;
                    listAtPos = mVertList.get(i);
                    if (listAtPos != null) { //there is SOME list
                        if (listAtPos.getHead().mData.equals(sourceCity)) { //found the pos with the src city
                            listAtPos.addToEnd(destinationCity);
                            break;
                        }
                    } else {
                        listAtPos = new LinkedList();
                        listAtPos.addToEnd(sourceCity);
                        listAtPos.addToEnd(destinationCity);
                        break;
                    }
                }
            }
        }
        this.mVertList.set(count, listAtPos);
    }

    public void printGraph() {
        for (int i = 0; i < mVertList.size(); i++) {
            if (mVertList.get(i) != null) {
                mVertList.get(i).printList();
                System.out.println("\n");
            } 
        }
    }
    
    public void dfs() {
        this.dfs(0);
    }
    public void dfs(int srcIndex) {
        Node headAtPos = mVertList.get(srcIndex).getHead();
        dfsRecur(headAtPos);
    }
    public void dfs (String src) {
        int pos = this.getPos(src);
        Node headAtPos = mVertList.get(pos).getHead();
        dfsRecur(headAtPos);
    }
    
    private void dfsRecur(Node srcNode) {
        srcNode.mVisited = true;

        int pos = getPos("" + srcNode.mData);
        Node p = mVertList.get(pos).getHead();
        System.out.println(p.mData);
        
        while (p.mNext != null) {
            p = p.mNext;
            int posHead = this.getPos("" + p.mData);
            Node h = this.mVertList.get(posHead).getHead();
            if (!h.mVisited) {
                dfsRecur(h);
            }
        }
    }
    

    
    public int getPos (String src) {
        int hashPos = this.hashFunc(src);
        for (int i = hashPos; i < mTABLE_SIZE; i++) {
            if (mVertList.get(i) != null) {
                if (mVertList.get(i).getHead().mData.equals(src)) {
                    return i;
                }
            } 
        }
        for (int i = 0; i < hashPos; i++) {
            if (mVertList.get(i) != null) {
                if (mVertList.get(i).getHead().mData.equals(src)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
}
