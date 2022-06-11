/*************************************************
 * File: Char.java
 * Author: Parth Verma
 * Description: This file contains code for complex type char
 * Date: June 6, 2022
*************************************************/
package unit1;

/**
 *
 * @author parthverma
 */
public class Char { //complex type which includes primitive type 'char'
    //instance variable
    private char mData;
    //constructors
    public Char() throws CharException{ //set data to null 
        //this.data = '\0';
        this('\0'); //(delegate constructor)
    }
    public Char(char c) throws CharException{ //set data to arg char
        this.mData = c; //working constructor
        if((int) c < 32 || (int) c > 127){
            throw new CharException("Invalid character");
        }
    }
    public Char(int c) throws CharException{ //set data to int type casted as char
        //this.data = (char) c;
        this((char) c); //(delegate constructor)
    }
    public Char(final Char c) throws CharException{ //set data to data of separate instance of Char class
        //this.data = c.toChar();
        this(c.toChar()); //(delegate constructor)
    }
    public Char(String c) throws CharException{ //set data to first letter of arg String
        //this.data = c.charAt(0);
        this(c.charAt(0)); //(delegate constructor)
    }
    //mutators
    
    /*************************************************
     * 
     * @param c 
     * @par Name
     * setChar
     * @purpose
     * Sets the data section to the data section of the argument
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void setChar(final Char c){
        this.mData = c.toChar();
    }
    /*************************************************
     * @par Name
     * setChar
     * @purpose
     * Sets the data section to the primitive argument
     * @param [in] :
     * char c
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/

    public void setChar(char c){
        this.mData = c;
    }
    /*************************************************
     * @par Name
     * setChar
     * @purpose
     * Sets the data section of the class as a character from the int argument
     * @param [in] :
     * int c
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/

    public void setChar(int c) throws CharException{
        if(c < 32 || c > 127){
            throw new CharException("Invalid Character");
        }
        else{
            this.mData = (char) c;
        }
    }
    
    //accessors
    
    /*************************************************
     * @par Name
     * toChar
     * @purpose
     * Returns the data section of the class as a char
     * @param [in] :
     * none
     * @return
     * Data as char type
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/

    public char toChar(){
        return this.mData;
    }
    /*************************************************
     * @par Name
     * toInt
     * @purpose
     * Returns the data section of the class as an int
     * @param [in] :
     * none
     * @return
     * Data as int type
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/

    public int toInt(){
        return (int) this.mData;
    }
    /*************************************************
     * @par Name
     * toString
     * @purpose
     * Returns the data section of the class as a string
     * @param [in] :
     * none
     * @return
     * Data as a String
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/

    public String toString(){
        return "" + this.mData;
    }
    /*************************************************
    * @par Name
    * toHexString
    * @purpose
    * Returns the data section of the class as a hexadecimal valued string (from the Professor's Discussion post)
    * @param [in] :
    * none
    * @return
    * Data as Hex String
    * @par References
    * None
    * @par Notes
    * None
    *************************************************/

    public String toHexString(){
        return Integer.toHexString((int) this.mData);
    }
    /*************************************************
     * @par Name
     * add
     * @purpose
     * Concatenates the data section of the class with the parameter
     * @param [in] :
     * char c
     * @return
     * Data and input char c concatenated as a String
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    
    public String add(char c){
        return "" + this.mData + c;
    }
    /*************************************************
     * @par Name
     * add
     * @purpose
     * Concatenates the data section of the class with the data section of the parameter
     * @param [in] :
     * final Char c
     * @return
     * The two characters as a string
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/

    public String add(final Char c){
        return "" + this.mData + c.toChar();
    }
}
