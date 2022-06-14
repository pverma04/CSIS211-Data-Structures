/*************************************************
 * File: BigDecimal.java
 * Author: Parth Verma
 * Description: This file contains code for the BigDecimal class
 * Date: June 6, 2022
*************************************************/
package unit1;
import java.util.*;

public class BigDecimal {
    //instance variables
    private ArrayList<Char> mBigDecimalAL = new ArrayList<Char>();
    //constructors
    public BigDecimal() throws BigDecimalException{ //set the Big Decimal Array to 0, ., 0
        /*************************************************
         * mBigDecimalAL.add(new Char('0'));
         * mBigDecimalAL.add(new Char('.'));
         * mBigDecimalAL.add(new Char('0'));
        *************************************************/
        this("0.0"); //(delegate constructor)
    }
    
    public BigDecimal(String value) throws BigDecimalException { //set the Big Decimal Array to each number in the String argument 'value'
        int countDec = 0;
        
        for(int i = 0; i < value.length(); i++){
            switch (value.charAt(i)){
                case '.':
                    countDec++;
                    if(countDec > 1){ //if there are multiple decimals, throw exception
                        throw new BigDecimalException("Multiple Decimals");
                    }
                    else{
                        try {
                            mBigDecimalAL.add(new Char(value.charAt(i)));
                        } catch (CharException cE) {
                            System.out.println(cE.getMessage());
                        }
                    }
                    break;
                case '-':
                    if(i > 0){ //a '-' anywhere after the 0th index throws an exception
                        throw new BigDecimalException("Invalid Character");
                    }
                    else{
                        try {
                            mBigDecimalAL.add(new Char(value.charAt(i)));
                        } catch (CharException cE) {
                            System.out.println(cE.getMessage());
                        }
                    }
                    break; 
                default:
                    if (!Character.isDigit(value.charAt(i))) { //every other character should only be a digit
                        throw new BigDecimalException("Invalid Character");
                    } else {
                        try {
                            mBigDecimalAL.add(new Char(value.charAt(i)));
                        } catch (CharException cE) {
                            System.out.println(cE.getMessage());
                        }
                    }
                    break;
            }
        }
        
        try {
            if(countDec == 0){ //if there are no decimals, add a ".0"
                mBigDecimalAL.add(new Char('.'));
                mBigDecimalAL.add(new Char("0"));
            }
            if(value.charAt(value.length() - 1) == '.'){ //if the number ends with just a decimal, add a 0
                mBigDecimalAL.add(new Char("0"));
            }
        } catch (CharException cE) {
            System.out.println(cE.getMessage());
        }
        

    }
    
    //mutators
    /*************************************************
     * @par Name
     * setValue
     * @purpose
     * Concatenates the data section of the class with the parameter
     * @param [in] :
     * char ch
     * @return
     * Data and input char c concatenated as a String
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void setValue(char ch) throws BigDecimalException{
        if(!Character.isDigit(ch) && ch != '.'){ //if data section is being set to anything that isn't a digit or "-"
            throw new BigDecimalException("Invalid Character");
        }
        else{
            mBigDecimalAL.clear();
            try {
                mBigDecimalAL.add(new Char(ch));

            } catch (CharException cE) {
                System.out.println(cE.getMessage());
            }
        }
    }
    
    /*************************************************
     * @par Name
     * setValue
     * @purpose
     * Reset the data section to each number in the String argument 'value'
     * @param [in] :
     * String value
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void setValue(String value) throws BigDecimalException{
        int countDec = 0;
        mBigDecimalAL.clear();
        for(int i = 0; i < value.length(); i++){
            switch(value.charAt(i)){
                case '.':
                    countDec++;
                    if(countDec > 1){ //if there are multiple decimals, throw exception
                        throw new BigDecimalException("Multiple Decimals");
                    }
                    else{
                        try { 
                            mBigDecimalAL.add(new Char(value.charAt(i)));
                        } catch (CharException cE) {
                            System.out.println(cE.getMessage());
                        }
                    }
                    break;
                case '-':
                    if(i > 0){ //a '-' anywhere after the 0th index throws an exception
                        throw new BigDecimalException("Invalid Character");
                    }
                    else{
                        try {
                            mBigDecimalAL.add(new Char(value.charAt(i)));
                        } catch (CharException cE) {
                            System.out.println(cE.getMessage());
                        }
                    }
                    break;  
                default:
                    if(!Character.isDigit(value.charAt(i))){ //every other character should only be a digit
                       throw new BigDecimalException("Invalid Character");     
                    }
                    else{
                        try {
                            mBigDecimalAL.add(new Char(value.charAt(i)));
                        } catch (CharException cE) {
                            System.out.println(cE.getMessage());
                        }
                    }
                    break;
            }
        }
    }
    
    /*************************************************
     * @par Name
     * add
     * @purpose
     * Adds the two values together and returns the result as a Big Decimal
     * @param [in] :
     * BigDecimal bD
     * @return
     * BigDecimal of both values added
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/   
    public BigDecimal add(BigDecimal bD){
        int carry = 0;
        int addOn = 0;
        String rv = "";
        String smallLeftStr; //before decimal
        String smallRightStr; //after decimal
        int indexDecThis = this.toString().indexOf(".");
        int indexDecBd = bD.toString().indexOf(".");
        BigDecimal sum = null;
        
        //padding left side of decimal
        smallLeftStr = (indexDecThis > indexDecBd) ? this.toString() : bD.toString(); //smallLeftStr is set to the smaller left side
        int differenceInLengthLeft = (indexDecThis > indexDecBd) ? indexDecBd - indexDecThis : indexDecThis - indexDecBd;
        smallLeftStr = paddingZeros(smallLeftStr, differenceInLengthLeft, true); //pad the number with the smaller left side with leading zeros
        
        try {
            if (indexDecThis > indexDecBd){
                 setValue(smallLeftStr);
            }
            else{
                 bD.setValue(smallLeftStr);
            }
        } catch (BigDecimalException bDE) {
            System.out.println(bDE.getMessage());
        }
        
        //padding right side of decimal
        smallRightStr = (this.toString().length() - this.toString().indexOf(".")) < (bD.toString().length() - bD.toString().indexOf(".")) ? this.toString() : bD.toString(); //smallRightStr is set to the smaller right side
        int differenceInLengthRight = (indexDecThis > indexDecBd) ? indexDecBd - indexDecThis : indexDecThis - indexDecBd;
        smallRightStr = paddingZeros(smallRightStr, differenceInLengthRight, false); //pad the number with the smaller right side with leading zeros
        
        try {
            if ((this.toString().length() - this.toString().indexOf(".")) < (bD.toString().length() - bD.toString().indexOf("."))) {
                setValue(smallRightStr);
            } else {
                bD.setValue(smallRightStr);
            }
        } catch (BigDecimalException bDE) {
            System.out.println(bDE.getMessage());
        }
        //addition of the two BigDecimals
        for(int i = this.toString().length() - 1; i >= 0; i--){
            if(this.toString().charAt(i) == '.'){ //found a decimal in the numbers, this should also go in the answer at the same place
                rv = "." + rv;
            }
            else{
                addOn = Character.getNumericValue(this.toString().charAt(i)) + Character.getNumericValue(bD.toString().charAt(i)) + carry;
                if(addOn >= 10 && i>0 ){ //not the first digit
                    addOn %= 10; //greater than 10, so we need a carry of 1
                    carry = 1;
                }
                else{
                    carry = 0;
                }      
                rv = "" + addOn + rv; //final string value of the sum 
            }
        }
        try{
            sum = new BigDecimal(rv); //make the BigDecimal from the resulting string
        } catch(BigDecimalException bDE){
            System.out.println(bDE.getMessage());
        }
        return sum;
    }
    
    /*************************************************
     * @par Name
     * sub
     * @purpose
     * Subtracts the argument BigDecimal from the data section
     * @param [in] :
     * BigDecimal bD
     * @return
     * The difference of the two BigDecimals as a BigDecimal
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public BigDecimal sub(BigDecimal bD){
        BigDecimal answer;
        String rv = "";
        String smallLeftStr; //before decimal
        String smallRightStr; //after decimal
        int indexDecThis = this.toString().indexOf(".");
        int indexDecBd = bD.toString().indexOf(".");
        
        //padding left side of decimal
        smallLeftStr = (indexDecThis > indexDecBd) ? (smallLeftStr = this.toString()) : bD.toString(); //smallLeftStr is set to the smaller left side
        int differenceInLengthLeft = (indexDecThis > indexDecBd) ? indexDecBd - indexDecThis : indexDecThis - indexDecBd;
        smallLeftStr = paddingZeros(smallLeftStr, differenceInLengthLeft, true); //pad the number with the smaller left side with leading zeros
        
        try {
            if (indexDecThis > indexDecBd) {
                setValue(smallLeftStr);
            } else {
                bD.setValue(smallLeftStr);
            }
        } catch (BigDecimalException bDE) {
            System.out.println(bDE.getMessage());
        }
        
        //padding right side of decimal
        smallRightStr = (this.toString().length() - this.toString().indexOf(".")) < (bD.toString().length() - bD.toString().indexOf(".")) ? this.toString() : bD.toString(); //smallRightStr is set to the smaller right side
        int differenceInLengthRight = (indexDecThis > indexDecBd) ? indexDecBd - indexDecThis : indexDecThis - indexDecBd;
        smallRightStr = paddingZeros(smallRightStr, differenceInLengthRight, false); //pad the number with the smaller right side with trailing zeros
       
        try {
            if ((this.toString().length() - this.toString().indexOf(".")) < (bD.toString().length() - bD.toString().indexOf("."))) {
                setValue(smallRightStr);
            } else {
                bD.setValue(smallRightStr);
            }
        } catch (BigDecimalException bDE) {
            System.out.println(bDE.getMessage());
        }
        
        
        answer = this.add(bD.ninesComplement());
        
        if(answer.toString().length() > this.toString().length()){
            String carry = "";
            for(int i = 0; i < (answer.toString().length() - answer.toString().indexOf(".") - 2); i++){
                carry = "0" + carry;
            }
            carry = "." + carry + 1;
            try{
                answer.setValue(answer.toString().substring(1)); //cut off the first digt from the answer (following the complement rules)
            }
            catch(BigDecimalException bDE){
                System.out.println(bDE.getMessage());
            }
            try{
                answer = answer.add(new BigDecimal(carry));  
            }
            catch(BigDecimalException bDE){
                System.out.println(bDE.getMessage());
            }
        }
        else{
            try{
                answer.setValue(answer.ninesComplement().toString());
            }
            catch(BigDecimalException bDE){
                System.out.println(bDE.getMessage());
            }
            if (answer.toDouble() != 0.0){
                try {
                    answer.setValue("-" + answer.toString());
                } 
                catch (BigDecimalException bDE) {
                    System.out.println(bDE.getMessage());
                }
            }
            else{
                try{
                    answer.setValue("0.0");
                } 
                catch (BigDecimalException bDE) {
                    System.out.println(bDE.getMessage());
                }
            }
        }
        return answer;
    }
    
    /*************************************************
     * @par Name
     * ninesComplement
     * @purpose
     * Determine the nine's complement of the data section to be used in the sub method
     * @param [in] :
     * None
     * @return
     * The nine's complement of the data section as a BigDecimal
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public BigDecimal ninesComplement(){
        String rv = "";
        BigDecimal nComp = null;
        for(int i = this.toString().length() - 1; i >= 0; i--){ //starting from the one's place of the number (BigDecimal)
            if(this.toString().charAt(i) == '.'){
                rv = "." + rv;
            }
            else{
                rv = (9 - Character.getNumericValue(this.toString().charAt(i))) + rv; //creating the nine's complement
            }
        }
        if(rv.length() > this.toString().length()){
            String rv1 = "";
            for (int i = rv.length() - 1; i >= 0; i--) {
                if (this.toString().charAt(i) == '.') {
                    rv1 = "." + rv1;
                } else { //repeating the process if needed (following the nine's complement rules)
                    rv1 = (9 - Character.getNumericValue(rv.charAt(i))) + rv1;
                }
            }
            rv = rv1;
        }
        try{
            nComp = new BigDecimal(rv);
        } 
        catch (BigDecimalException bDE){
            System.out.println(bDE.getMessage());
        }
        return nComp;
    }
    
    //accessors
    /*************************************************
     * @par Name
     * toDouble
     * @purpose
     * Returns the data section of the class as a double
     * @param [in] :
     * none
     * @return
     * Data as double type
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public double toDouble(){
       String rv = "";
       for(int i = 0; i < this.mBigDecimalAL.size(); i++){
           rv += "" + this.mBigDecimalAL.get(i);
       }
       return Double.parseDouble(rv);
    }
    
    /*************************************************
     * @par Name
     * toString
     * @purpose
     * Returns the data section of the class as a String
     * @param [in] :
     * none
     * @return
     * Data as String type
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public String toString(){
        String rv = "";
        for(int i = 0; i < this.mBigDecimalAL.size(); i++){
           rv += "" + this.mBigDecimalAL.get(i);
        }
        return rv;
    }
    
    /*************************************************
     * @par Name
     * at
     * @purpose
     * Returns the value (Char: complex type char) at the given index of the data section
     * @param [in] :
     * none
     * @return
     * Complex char (Char) 
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public Char at(int index){
        return mBigDecimalAL.get(index);
    }
    
    /*************************************************
     * @par Name
     * wholeNumber
     * @purpose
     * Separates the whole number part of the data section
     * @param [in] :
     * None
     * @return
     * The whole number part of the data section as an int
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public int wholeNumber(){
        return Integer.parseInt(this.toString().substring(0, this.toString().indexOf(".")));
    }
    
    /*************************************************
     * @par Name
     * fraction
     * @purpose
     * Separates the fractional part of the data section
     * @param [in] :
     * None
     * @return
     * The fractional part of the data section as an int
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public double fraction(){
        //return Integer.parseInt(this.toString().substring(this.toString().indexOf(".")));
        return Double.parseDouble(this.toString().substring(this.toString().indexOf(".")));
    }
    
    /*************************************************
     * @par Name
     * paddingZeros
     * @purpose
     * A helper method to pad zeros in the smaller BigDecimal (to be used in add and sub methods)
     * @param [in] :
     * String input, int numZeros, boolean padInFront
     * @return
     * The padded String
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public String paddingZeros(String input, int numZeros, boolean padInFront){
        String paddedStr = input;
        if(padInFront){ //add leading zeros
            for (int i = 0; i < numZeros; i++) {
                paddedStr = "0" + paddedStr;
            }
        }
        else{ //add trailing zeros
            for (int i = 0; i < numZeros; i++) {
                paddedStr += "0";
            }
        }
        return paddedStr;
    }
}
