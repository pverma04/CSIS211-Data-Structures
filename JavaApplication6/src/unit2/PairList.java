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
    public void addPair(T first, T second){
        this.pairList.add(new Pair((Comparable) first, (Comparable) second));
    }
    public void addPair(T first, T second, int index){
        //this.pairList.add(index, new Pair((Comparable) first, (Comparable) second));
        if(index < this.pairList.size() && index >= 0){
            ArrayList<Pair> tempList = new ArrayList<Pair>();
            for (int i = 0; i < index; i++) {
                tempList.add(this.pairList.get(i));
            }
            tempList.add(new Pair((Comparable) first, (Comparable) second));
            for (int i = index; i < this.pairList.size(); i++) {
                tempList.add(pairList.get(index));
            }
            this.pairList = tempList;
        }
        else{
          System.out.println("Invalid index");
        }
    }
    public void addPair(Pair add){
        this.pairList.add(add);
    }
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
                tempList.add(this.pairList.get(i));
            }
            tempList.add(addOn);
            for (int i = index; i < this.pairList.size(); i++) {
                tempList.add(pairList.get(index));
            }
            this.pairList = tempList;  
        }
        else{
            System.out.println("Invalid index");
        }
    } 
    public T getFirst(T second){
        Pair tempPair = null;
        for(Pair p : this.pairList){
            if(p.checkEquals(p.getSecond(), (Comparable) second)){
                tempPair = p;
                break;
            }
        }
        return (T) tempPair.getFirst();
    }
    public T getSecond(T first){
        Pair tempPair = null;
        for(Pair p : this.pairList){
            if (p.checkEquals(p.getFirst(), (Comparable) first)){
                tempPair = p;
                break;
            }
        }
        return (T) tempPair.getSecond();
    }
    
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
    public void deletePair(Pair toRemove){
        Pair tempRemove = null;
        for(Pair p : this.pairList){
            if(p.checkEquals(toRemove)){
                tempRemove = p;
            }
        }
        this.pairList.remove(tempRemove);  
    }
    public void deletePair(int index){
        //this.pairList.remove(index);
        if (index < this.pairList.size() && index >= 0){
            ArrayList<Pair> tempList = new ArrayList<Pair>();
            for (int i = 0; i < index; i++) {
                tempList.add(this.pairList.get(i));
            }
            for (int i = index + 1; i < this.pairList.size(); i++) {
                tempList.add(pairList.get(index));
            }
            this.pairList = tempList;
        }
        else{
            System.out.println("Invalid index");
        }
    }
    public void printList(){
        for(Pair p : this.pairList){
            System.out.println(p.getFirst() + ", " + p.getSecond());
        }
    }
    public int occurencesFirst(T first){ //could be made as just "occurnces"?
        int count = 0;
        for(Pair p : this.pairList){
            if(p.checkEquals(p.getFirst(), (Comparable) first)){
                count++;
            }
        }
        return count;
    }
    public int occurencesSecond(T second) { //could be made as just "occurnces"?
        int count = 0;
        for (Pair p : this.pairList) {
            if (p.checkEquals(p.getSecond(), (Comparable) second)) {
                count++;
            }
        }
        return count;
    }
    public int getIndex(T first, T second){
        Pair pairAtIndex = new Pair((Comparable) first, (Comparable) second);
        for(int i = 0; i < this.pairList.size(); i++){
            if(this.pairList.get(i).checkEquals(pairAtIndex)){
                return i;
            }
        }
        return -1;
    }
    public int getIndex(Pair pairAtIndex) {
        for (int i = 0; i < this.pairList.size(); i++) {
            if (this.pairList.get(i).checkEquals(pairAtIndex)) {
                return i;
            }
        }
        return -1;
    }
    public boolean containsPair(T first, T second){
        return this.getIndex(first, second) >= 0;
    }
    public boolean containsPair(Pair check){
        return this.getIndex(check) >= 0;
    }
    public void setIndex(Pair toSet, int index){
        if (index < this.pairList.size() && index >= 0) {
            ArrayList<Pair> tempList = new ArrayList<Pair>();
            for (int i = 0; i < index; i++) {
                tempList.add(this.pairList.get(i));
            }
            tempList.add(toSet);
            for (int i = index + 1; i < this.pairList.size(); i++) {
                tempList.add(pairList.get(index));
            }
            this.pairList = tempList;
        } else {
            System.out.println("Invalid index");
        }
    }
    public void setIndex(T first, T second, int index) {
        if (index < this.pairList.size() && index >= 0) {
            ArrayList<Pair> tempList = new ArrayList<Pair>();
            Pair toSet = new Pair((Comparable) first, (Comparable) second);
            for (int i = 0; i < index; i++) {
                tempList.add(this.pairList.get(i));
            }
            tempList.add(toSet);
            for (int i = index + 1; i < this.pairList.size(); i++) {
                tempList.add(pairList.get(index));
            }
            this.pairList = tempList;
        } else {
            System.out.println("Invalid index");
        }
    }
    public void clearAll(){
        for(int i = 0; i < this.pairList.size(); i++){
            this.set(i, new Pair(null, null));
        }
    }
}
