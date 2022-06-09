/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unit0assignment1;

/**
 *
 * @author parthverma
 */
public class Person {
    //class attributes
    private String firstName;
    private String lastName;
    private String address;
    
    //mutator methods
    public void setFirstName(String first){
        this.firstName = first;
    }
    public void setLastName(String last){
        this.lastName = last;
    }
    public void setAddress(String address){
        this.address = address;
    }
    //accessor methods
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getAddress(){
        return this.address;
    }
    
    //constructors
    public Person(){//default
        this.firstName = "";
        this.lastName = "";
        this.address = "";
    }
    public Person(String first, String last){
        this.firstName = first;
        this.lastName = last;
        this.address = "";
    }
    public Person(String first, String last, String address){
        this.firstName = first;
        this.lastName = last;
        this.address = address;
    }
    
}
