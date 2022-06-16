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
        
    }
    public <T> void addPair(T first, T second){
        pairList.add(new Pair(first, second));
    }
    /*
    public  T getFirst(T second){
        for(Pair p : pairList){
            if(p.getSecond() == second){
                return (T)p.getFirst();
            }
        }
    }
    */
    
    public  T getFirst(T second){
      Pair tmpPair=null;
        for(Pair p : pairList){
            if(p.getSecond() == second){
                tmpPair=p;
                break;
            }
        }
        return (T)tmpPair.getFirst();

    }
/*
    public T getSecond(T first){
        for(Pair p : pairList){
            if(p.getFirst() == first){
                return p.getSecond();
            }
        }
    }
    public void deletePair(T first, T second){
        for(Pair p : pairList){
            if(p.getFirst() == first || p.getSecond() == second){
                pairList.remove(p);
            }
        }
    }
    public int occurencesFirst(T first){
        int count = 0;
    }
    */
}
