/*************************************************
 * File: Pair.java
 * Author: Parth Verma
 * Description: This file contains code for the Pair class (used in PairList)
 * Date: June 17, 2022
*************************************************/
package unit3;

public class Pair<T>{
    //instance variable of type T
    private T f;
    private T s;
    
    public Pair(T first, T second){ //working constructor
        this.f = first;
        this.s = second;
    }
    
    /*************************************************
     * @par Name
     * getFirst
     * @purpose
     * returns the first of the data section
     * @param [in] :
     * none
     * @return
     * T
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public T getFirst(){
        return f;
    }
    
    /*************************************************
     * @par Name
     * getSecond
     * @purpose
     * returns the second of the data section
     * @param [in] :
     * none
     * @return
     * T
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public T getSecond(){
        return s;
    }   
    
    /*************************************************
     * @par Name
     * setFirst
     * @purpose
     * sets the first of the data section
     * @param [in] :
     * T first
     * @return
     * none
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void setFirst(T first){
        this.f = first;
    }
    
    /*************************************************
     * @par Name
     * setSecond
     * @purpose
     * sets the second of the data section
     * @param [in] :
     * T second
     * @return
     * none
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void setSecond(T second){
        this.s = second;
    }
    
    /*************************************************
     * @par Name
     * checkEquals
     * @purpose
     * Checks if the current T value is equal to the given T value (T value could represent a first or a second)
     * @param [in] :
     * T current, T check
     * @return
     * boolean
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public boolean checkEquals(T current, T check){
        return current.equals(check);
    }
    
    /*************************************************
     * @par Name
     * checkEquals
     * @purpose
     * Checks if the current Pair is equal to the given Pair
     * @param [in] :
     * Pair current
     * @return
     * boolean
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public boolean checkEquals(Pair check){
        return (this.checkEquals(this.f, (T) check.getFirst()) && this.checkEquals(this.s, (T) check.getSecond()));
    }
    public String toString(){
        return this.getFirst() + ", " + this.getSecond();
    }
}
    
