/*************************************************
 * File: Char.java
 * Author: Parth Verma
 * Description: This file contains code for the BigDecimal Exception inheriting CharException
 * Date: June 6, 2022
*************************************************/
package unit1;

public class BigDecimalException extends CharException{
    public BigDecimalException(String message){
        super(message);
    }
    public String getMessage(){
        return super.getMessage();
    }
}
