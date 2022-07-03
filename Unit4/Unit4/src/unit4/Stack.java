/** ***********************************************
 * File: Stack.java
 * Author: Parth Verma
 * Description: This file contains code for the Stack class of unit 4
 * Date: June 30, 2022
 ************************************************ */
package unit4;

public class Stack<T> {
    LinkedList<T> stackList;
    Node top;
    Node bottom;
    int size;
    
    public Stack(){
        this.stackList = new LinkedList<T>();
        this.top = this.stackList.head;
        this.bottom = this.stackList.tail;
        size = 0;
    }
    
    /**
     * ***********************************************
     * @par Name push
     * @purpose Adds the given data to the top/end of the stack
     * @param [in] : T data
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void push(T data){
        this.stackList.addToEnd(data);
        this.top = this.stackList.tail;
        size++;
    }
    
    /**
     * ***********************************************
     * @par Name pop
     * @purpose Removes the data at the top/end of the stack
     * @param [in] : None
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void pop(){
        if(!this.isEmpty()){
            if(this.top == this.stackList.head){
                this.top = null;
                this.bottom = null;
            }
            else{
                this.stackList.tail.prev.next = null;
                this.stackList.tail = this.stackList.tail.prev;
                this.top = this.stackList.tail;
                this.bottom = this.stackList.head;
            }
            size--;
        }
    }
    
    /**
     * ***********************************************
     * @par Name peek
     * @purpose Returns the data at the top/end of the stack
     * @param [in] : None
     * @return T
     * @par References None
     * @par Notes None ***********************************************
     */
    public T peek(){
        if(!isEmpty()){
            return (T) this.top.data;
        }
        else{
            return null;
        }
    }
        
    /**
     * ***********************************************
     * @par Name printStack
     * @purpose Prints the contents of the Stack in order
     * @param [in] : None
     * @return None
     * @par References None
     * @par Notes None ***********************************************
     */
    public void printStack(){
        Node p = this.top;
        if(!this.isEmpty()){
            while(p != null){
                System.out.println("" + p.data);
                p = p.prev;
            }
        }
        else{
            System.out.println("Empty Stack");
        }
    }
    
    /**
     * ***********************************************
     * @par Name isEmpty
     * @purpose A helper method to determine if the Stack is empty
     * @param [in] : None
     * @return boolean
     * @par References None
     * @par Notes None ***********************************************
     */
    public boolean isEmpty(){
        return this.size == 0;
    }
}
