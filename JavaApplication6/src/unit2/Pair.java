 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unit2;

/**
 *
 * @author parthverma
 */
public class Pair<T extends Comparable<T>>{
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
    public boolean checkEquals(T current, T check){
        //if(current.getClass().getSimpleName().equals("Integer") || current.getClass().getSimpleName().equals("Double") || current.getClass().getSimpleName().equals("Char")){
        //    return current == check;
        //}
        return current.compareTo(check) == 0;
    }
    public boolean checkEquals(Pair check){
        return (this.checkEquals(this.f, (T) check.getFirst()) && this.checkEquals(this.s, (T) check.getSecond()));
    }
    
}
    
