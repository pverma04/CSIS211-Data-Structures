/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unit2.parthverma;

/**
 *
 * @author parthverma
 */
public class Pair<T> {
    //instance variable of type T
    private T f;
    private T s;
    
    public Pair(T first, T second){ //working constructor
        this.f = first;
        this.s = second;
    }
    
    public T getFirst(){
        return f;
    }
    public T getSecond(){
        return s;
    }
    public void setFirst(T first){
        this.f = first;
    }
    public void setSecond(T second){
        this.s = second;
    }
}
    
