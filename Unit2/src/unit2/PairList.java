/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unit2;

import java.util.ArrayList;

/**
 *
 * @author parthverma
 */
public class PairList<T> extends ArrayList<Pair>{
    //intance variable
    private ArrayList<Pair> pairList = new ArrayList<Pair>();
    
    public PairList(){
        //pairList = null;
    }
    
    /*************************************************
     * @par Name
     * addPair
     * @purpose
     * Create and add a new pair to the data section
     * @param [in] :
     * T first, T second
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void addPair(T first, T second){
        this.pairList.add(new Pair((Comparable) first, (Comparable) second));
    }
    
    /*************************************************
     * @par Name
     * addPair
     * @purpose
     * Create and add a new pair to the data section at the given index, and move every following Pair one index to the right
     * @param [in] :
     * T first, T second, int index
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void addPair(T first, T second, int index){
        //this.pairList.add(index, new Pair((Comparable) first, (Comparable) second));
        if(index < this.pairList.size() && index >= 0){
            ArrayList<Pair> tempList = new ArrayList<Pair>();
            for (int i = 0; i < index; i++) {
                tempList.add(this.getPair(i));
            }
            tempList.add(new Pair((Comparable) first, (Comparable) second));
            for (int i = index; i < this.pairList.size(); i++) {
                tempList.add(this.getPair(i));
            }
            this.pairList = tempList;
        }
        else{
          System.out.println("Invalid index");
        }
    }
    
    /*************************************************
     * @par Name
     * addPair
     * @purpose
     * Add a new pair from the argument to the data section
     * @param [in] :
     * Pair addOn
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void addPair(Pair addOn){
        this.pairList.add(addOn);
    }
    
    /*************************************************
     * @par Name
     * addPair
     * @purpose
     * Add a new pair from the argument to the data section to the specified index, and moves every following Pair value to the right
     * @param [in] :
     * Pair addOn, int index
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void addPair(Pair addOn, int index){
        if(index < this.pairList.size() && index >= 0){
            ArrayList<Pair> tempList = new ArrayList<Pair>();
            /*
            //from looking at the Java source code for ArrayList.add() and found arraycopy from there
            Object[] currentPair = this.pairList.toArray();
            Object[] tempPairs = tempList.toArray(); 
            System.arraycopy(currentPair, 0, tempPairs, 0, index - 1);
            tempList.add(addOn);
            System.arraycopy(currentPair, index, tempPairs, index + 1, this.pairList.size() - 1);
            */
            for (int i = 0; i < index; i++) {
                tempList.add(this.getPair(i));
            }
            tempList.add(addOn);
            for (int i = index; i < this.pairList.size(); i++) {
                tempList.add(this.getPair(i));
            }
            this.pairList = tempList;  
        }
        else{
            System.out.println("Invalid index");
        }
    } 
    
    /*************************************************
     * @par Name
     * getFirst
     * @purpose
     * Find the corresponding 'second' to the given 'first' (both of type T) by finding the pair they are apart of
     * @param [in] :
     * T second
     * @return
     * Type T first
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public T getFirst(T second){
        Pair tempPair = new Pair(null, null);
        for(Pair p : this.pairList){
            if(p.checkEquals(p.getSecond(), (Comparable) second)){
                tempPair = p;
                break;
            }
        }
        return (T) tempPair.getFirst();
    }
    
     /*************************************************
     * @par Name
     * getSecond
     * @purpose
     * Find the corresponding 'first' to the given 'second' (both of type T) by finding the pair they are apart of
     * @param [in] :
     * T first
     * @return
     * Type T second
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public T getSecond(T first){
        Pair tempPair = new Pair(null, null);
        for(Pair p : this.pairList){
            if (p.checkEquals(p.getFirst(), (Comparable) first)){
                tempPair = p;
                break;
            }
        }
        return (T) tempPair.getSecond();
    }
    
    /*************************************************
     * @par Name
     * deletePair
     * @purpose
     * Takes a first and second, and finds and deletes the corresponding pair in the data section
     * @param [in] :
     * T first, T second
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void deletePair(T first, T second){
        Pair tempRemove = null;
        Pair toCheck = new Pair((Comparable) first, (Comparable) second);
        for(Pair p : this.pairList){
            if(p.checkEquals(toCheck)){
                tempRemove = p;
            }
        }
        
        this.pairList.remove(tempRemove);
    }
    
    /*************************************************
     * @par Name
     * deletePair
     * @purpose
     * Finds and removes the given Pair from the data section
     * @param [in] :
     * Pair toRemove
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void deletePair(Pair toRemove){
        Pair tempRemove = null;
        for(Pair p : this.pairList){
            if(p.checkEquals(toRemove)){
                tempRemove = p;
            }
        }
        this.pairList.remove(tempRemove);  
    }
    
    /*************************************************
     * @par Name
     * deletePair
     * @purpose
     * Finds and removes the Pair at the given index of the data section
     * @param [in] :
     * int index
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void deletePair(int index){
        //this.pairList.remove(index);
        if (index < this.pairList.size() && index >= 0){
            ArrayList<Pair> tempList = new ArrayList<Pair>();
            for (int i = 0; i < index; i++) {
                tempList.add(this.getPair(i));
            }
            for (int i = index + 1; i < this.pairList.size(); i++) {
                tempList.add(this.getPair(i));
            }
            this.pairList = tempList;
        }
        else{
            System.out.println("Invalid index");
        }
    }
    
    /*************************************************
     * @par Name
     * printList
     * @purpose
     * Iterates through and prints out each pair on a new line
     * @param [in] :
     * None
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void printList(){
        for(Pair p : this.pairList){
            System.out.println(p.getFirst() + ", " + p.getSecond());
        }
    }
    
    /*************************************************
     * @par Name
     * occurrences
     * @purpose
     * Finds the number of occurrences of a given T value, either as a first or second (as determined by the given boolean)
     * @param [in] :
     * T check, boolean isFirst
     * @return
     * int
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public int occurrences(T check, boolean isFirst){
        int count = 0;
        if(isFirst){// check for First
            for (Pair p : this.pairList) {
                if (p.checkEquals(p.getFirst(), (Comparable) check)) {
                    count++;
                }
            }
        }
        else{ //Check for Second
            for (Pair p : this.pairList) {
                if (p.checkEquals(p.getSecond(), (Comparable) check)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    /*************************************************
     * @par Name
     * getIndex
     * @purpose
     * Finds the index of a pair in the data section given a first and second value
     * @param [in] :
     * T first, T second
     * @return
     * int
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public int getIndex(T first, T second){
        Pair pairAtIndex = new Pair((Comparable) first, (Comparable) second);
        for(int i = 0; i < this.pairList.size(); i++){
            if(this.getPair(i).checkEquals(pairAtIndex)){
                return i;
            }
        }
        return -1;
    }
    
    /*************************************************
     * @par Name
     * getIndex
     * @purpose
     * Finds the index of a pair in the data section given a first and second value (returns -1 if not found)
     * @param [in] :
     * T first, T second
     * @return
     * int
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public int getIndex(Pair pairAtIndex) {
        for (int i = 0; i < this.pairList.size(); i++) {
            if (this.getPair(i).checkEquals(pairAtIndex)) {
                return i;
            }
        }
        return -1;
    }
    
    /*************************************************
     * @par Name
     * containsPair
     * @purpose
     * Determines whether or not a pair is found in the data section, given a first and second value
     * @param [in] :
     * T first, T second
     * @return
     * boolean
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public boolean containsPair(T first, T second){
        return this.getIndex(first, second) >= 0;
    }
    
    /*************************************************
     * @par Name
     * containsPair
     * @purpose
     * Determines whether or not a given pair is found in the data section
     * @param [in] :
     * Pair check
     * @return
     * boolean
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public boolean containsPair(Pair check){
        return this.getIndex(check) >= 0;
    }
    
    /*************************************************
     * @par Name
     * setIndex
     * @purpose
     * Changes the Pair at the given index to the given Pair toSet
     * @param [in] :
     * Pair toSet, int index
     * @return
     * none
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void setIndex(Pair toSet, int index){
        if (index < this.pairList.size() && index >= 0) {
            ArrayList<Pair> tempList = new ArrayList<Pair>();
            for (int i = 0; i < index; i++) {
                tempList.add(this.getPair(i));
            }
            tempList.add(toSet);
            for (int i = index + 1; i < this.pairList.size(); i++) {
                tempList.add(this.getPair(i));
            }
            this.pairList = tempList;
        } else {
            System.out.println("Invalid index");
        }
    }
    
    /*************************************************
     * @par Name
     * setIndex
     * @purpose
     * Changes the Pair at the given index to a new Pair given the first and second values
     * @param [in] :
     * T first, T second, int index
     * @return
     * none
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void setIndex(T first, T second, int index) {
        if (index < this.pairList.size() && index >= 0) {
            ArrayList<Pair> tempList = new ArrayList<Pair>();
            Pair toSet = new Pair((Comparable) first, (Comparable) second);
            for (int i = 0; i < index; i++) {
                tempList.add(this.getPair(i));
            }
            tempList.add(toSet);
            for (int i = index + 1; i < this.pairList.size(); i++) {
                tempList.add(this.getPair(i));
            }
            this.pairList = tempList;
        } else {
            System.out.println("Invalid index");
        }
    }
    
    /*************************************************
     * @par Name
     * clearAll
     * @purpose
     * Clears the entire data section
     * @param [in] :
     * none
     * @return
     * none
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void clearAll(){
        int size = this.getSize();
        for(int i = 0; i < size; i++){
            this.deletePair(0);
        }
    }
    
    /*************************************************
     * @par Name
     * getSize
     * @purpose
     * returns length of data section as an int
     * @param [in] :
     * none
     * @return
     * int
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public int getSize(){
        int count = 0;
        for(Pair p : this.pairList){
            count++;
        }
        return count;
    }
    
    /*************************************************
     * @par Name
     * getPair
     * @purpose
     * returns Pair at the given index of the data section
     * @param [in] :
     * int index
     * @return
     * T 
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public Pair getPair(int index){
        Pair tempPair = null;
        if(index < this.getSize() && index >= 0){
            int count = 0;
            for(Pair p : this.pairList){
                if(count == index){
                    tempPair = p;
                }
                count++;
            }
        }
        return tempPair;
    }
}
