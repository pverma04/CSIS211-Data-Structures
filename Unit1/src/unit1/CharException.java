/*************************************************
 * File: Char.java
 * Author: Parth Verma
 * Description: This file contains code for the CharException inheriting Exception
 * Date: June 6, 2022
*************************************************/
package unit1;

public class CharException extends Exception{
    public CharException(String message){
        super(message);
    }
    public String getMessage(){
        return super.getMessage();
    }
}
