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
    public void addPair(Pair add){
        this.pairList.add(add);
    }
    /*
    public  T getFirst(T second){
        for(Pair p : pairList){
            if(p.getSecond() == second){
                return p.getFirst();
            }
        }
    }
    */
    
    public T getFirst(T second){
        Pair tempPair = null;
        for(Pair p : this.pairList){
            if(p.checkEquals(p.getSecond(), (Comparable) second)){
                tempPair = p;
                break;
            }
            /*
            if(p.getSecond().compareTo(p) < 0){
                tempPair = p;
                break;
            }
            */
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
            /*
            if(p.getFirst().compareTo(first) < 0){
                tempPair = p;
                break;
            }*/
        }
        return (T) tempPair.getSecond();
    }
    
    public void deletePair(T first, T second){
        Pair tempRemove = null;
        Pair toCheck = new Pair((Comparable) first, (Comparable) second);
        for(Pair p : this.pairList){
            if(p.checkEquals(toCheck)){
            //if(p.checkEquals(p.getFirst(), (Comparable) first) && p.checkEquals(p.getSecond(), (Comparable) second)){
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
    
}
