package unit9;

import java.util.*;

public class Graph<T> {

    ArrayList<LinkedList<T>> mVertList;
    static int mTABLE_SIZE = 53;
    ArrayList<String> mCitiesList;

    public Graph() {
        this(mTABLE_SIZE);
    }

    public Graph(int size) {
        this.mTABLE_SIZE = size;
        mVertList = new ArrayList<LinkedList<T>>(mTABLE_SIZE);
        for (int i = 0; i < mTABLE_SIZE; i++) { //populate the graph with null values
            mVertList.add(null);
        }
        mCitiesList = new ArrayList<>(); //as cities are inserted, unqiue names will be added to this list in order
    }

    /**
     * ***********************************************
     * @par Name hashFunc
     * @purpose Prints the contents of the LinkedList in order
     * @param [in] : String str
     * @return int ***********************************************
     */
    private int hashFunc(String str) {
        return Math.abs(str.hashCode() % mTABLE_SIZE);
    }

    /**
     * ***********************************************
     * @par Name insert
     * @purpose Takes a src and dest City for use with the private insert
     * method. Calls the method twice to insure both src and dest city are
     * listed as sources and are connected (in the undirected manner)
     * @param [in] : String srcCity, String destCity
     * @return void ***********************************************
     */
    public void insert(String srcCity, String destCity) {
        this.insertToGraph(srcCity, destCity);
        this.insertToGraph(destCity, srcCity);
    }

    /**
     * ***********************************************
     * @par Name insertToGraph
     * @purpose Given a source and destination city, find the correct index in
     * the hash table for the the source city, and add both as needed
     * @param [in] : String sourceCity, String destinationCity
     * @return void ***********************************************
     */
    private void insertToGraph(String sourceCity, String destinationCity) {
        if (!mCitiesList.contains(sourceCity)) { //if the city exists in the list, do not add it again
            mCitiesList.add(sourceCity);
        }
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
                    } else { //if it is null, add in as this is the first open spot
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

    /**
     * ***********************************************
     * @par Name printGraph
     * @purpose Iterates through each index of the hash table and prints out ALL
     * content in the linked list (including repeats), to check and see the
     * mapping
     * @param [in] : None
     * @return void ***********************************************
     */
    public void printGraph() {
        for (int i = 0; i < mVertList.size(); i++) {
            if (mVertList.get(i) != null) {
                mVertList.get(i).printList();
                System.out.println("\n");
            }
        }
    }

    /**
     * ***********************************************
     * @par Name dfs
     * @purpose Begins the Depth First Traversal at the index of the first city
     * that was added to the graph
     * @param [in] : None
     * @return void ***********************************************
     */
    public void dfs() {
        this.dfs(0);
    }

    /**
     * ***********************************************
     * @par Name dfs
     * @purpose Begins the Depth First Traversal at the given index (index
     * represents the order of cities as inserted into the graph)
     * @param [in] : int srcIndex
     * @return void ***********************************************
     */
    public void dfs(int srcIndex) {
        /*
        int firstNotNullIndex = srcIndex;
        for (int i = firstNotNullIndex; i < mTABLE_SIZE; i++) {
            if (mVertList.get(i) != null) {
                firstNotNullIndex = i;
                break;
            }
        }
        try {
            Node headAtPos = mVertList.get(firstNotNullIndex).getHead();
            dfsRecur(headAtPos);
        } catch (NullPointerException exc) {
            try{
                for (int i = srcIndex; i >= 0; i--) {
                    if (mVertList.get(i) != null) {
                        firstNotNullIndex = i;
                        break;
                    }
                }
                Node headAtPos = mVertList.get(firstNotNullIndex).getHead();
                dfsRecur(headAtPos);
            } catch (NullPointerException nPExc) {
                System.out.println("Empty Graph");
            }
        }
         */
        try {
            String cityName = mCitiesList.get(srcIndex); //given an index (number corresponding to the cities: 0 - first city added, 1 - second city added, etc), retreive it from the cities list array
            this.dfs(cityName);
        } catch (IndexOutOfBoundsException exc) {
            System.out.println("Given index out of bounds: Not that many cities");
        }
    }

    /**
     * ***********************************************
     * @par Name dfs
     * @purpose Begins the Depth First Traversal at the given index (index
     * represents the order of cities as inserted into the graph)
     * @param [in] : String src
     * @return void ***********************************************
     */
    public void dfs(String src) {
        try {
            int pos = this.getPos(src);
            Node headAtPos = mVertList.get(pos).getHead();
            dfsRecur(headAtPos);
            System.out.println(mCitiesList.toString());
        } catch (IndexOutOfBoundsException exc) {
            System.out.println("Item not found");
        }
    }

    /**
     * ***********************************************
     * @par Name dfsRecur
     * @purpose Beginning at the given node, traverses through the graph and
     * prints the data of the next node IF it has not been visited
     * @param [in] : Node srcNode
     * @return void ***********************************************
     */
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

    /**
     * ***********************************************
     * @par Name getPos
     * @purpose Search for and retrun the index of the given string in the graph
     * (-1 if not found)
     * @param [in] : String src
     * @return int ***********************************************
     */
    public int getPos(String src) {
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
