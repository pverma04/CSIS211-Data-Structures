package unit1;
import java.util.*;
// for github
/**
 *
 * @author parthverma
 */
public class BigDecimal {
    //instance variables
    private ArrayList<Char> mBigDecimalAL = new ArrayList<Char>();
    //constructors
    public BigDecimal(){ //set the Big Decimal Array to 0, ., 0
        /*************************************************
         * mBigDecimalAL.add(new Char('0'));
         * mBigDecimalAL.add(new Char('.'));
         * mBigDecimalAL.add(new Char('0'));
        *************************************************/
        this("0.0"); //(delegate constructor)
    }
    public BigDecimal(String value){ //set the Big Decimal Array to each number in the String argument 'value'
        for(int i = 0; i < value.length(); i++){
            mBigDecimalAL.add(new Char(value.charAt(i))); //(working consturctor)
        }
        if(value.indexOf(".") < 0){
            mBigDecimalAL.add(new Char('.'));
            mBigDecimalAL.add(new Char("0"));
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
    public void setValue(char ch){
        
    }
    /*************************************************
     * @par Name
     * setValue
     * @purpose
     * Reset the Big Decimal Array to each number in the String argument 'value'
     * @param [in] :
     * String value
     * @return
     * None
     * @par References
     * None
     * @par Notes
     * None
    *************************************************/
    public void setValue(String value){
        mBigDecimalAL.clear();
        for(int i = 0; i < value.length(); i++){
            mBigDecimalAL.add(new Char(value.charAt(i)));
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
        
        if(indexDecThis < indexDecBd){
            smallLeftStr =this.toString();
            for(int i = 0; i < (indexDecBd - indexDecThis); i++){
                smallLeftStr = "0" + smallLeftStr;
            }
            setValue(smallLeftStr);
        }
        else if(indexDecThis > indexDecBd){
            smallLeftStr = bD.toString();
                   
            for(int i = 0; i < (indexDecThis - indexDecBd); i++){
                smallLeftStr = "0" + smallLeftStr;
            }
            bD.setValue(smallLeftStr);
        }
        
        
        if((this.toString().length() - this.toString().indexOf(".")) < (bD.toString().length() - bD.toString().indexOf("."))){
            smallRightStr = this.toString();
            for(int i = 0; i < ((bD.toString().length() - bD.toString().indexOf(".")) - ( this.toString().length() - this.toString().indexOf("."))); i++){
                smallRightStr += "0";
            }
            setValue(smallRightStr);
        }
        else if((this.toString().length() - this.toString().indexOf(".")) > (bD.toString().length() - bD.toString().indexOf("."))){
            smallRightStr = bD.toString();
            for(int i = 0; i < ((this.toString().length() - this.toString().indexOf(".")) - (bD.toString().length() - bD.toString().indexOf("."))); i++){
                smallRightStr += "0";
            }
            bD.setValue(smallRightStr);
        }
        
        //System.out.println(this.toString());
        //System.out.println(bD.toString());
        
        for(int i = this.toString().length() - 1; i >= 0; i--){
            if(this.toString().charAt(i) == '.'){
                rv = "." + rv;
            }
            
            else{
                addOn = Character.getNumericValue(this.toString().charAt(i)) + Character.getNumericValue(bD.toString().charAt(i)) + carry;
                if(addOn >= 10){
                    addOn %= 10;
                    carry = 1;
                }
                else{
                    carry = 0;
                }      
                rv = "" + addOn + rv;
            }
        }
        
        return new BigDecimal(rv);
    }
    
    
    public BigDecimal sub(BigDecimal bD){
        BigDecimal answer;
        String rv = "";
        String smallLeftStr; //before decimal
        String smallRightStr; //after decimal
        int indexDecThis = this.toString().indexOf(".");
        int indexDecBd = bD.toString().indexOf(".");
        
        if(indexDecThis < indexDecBd){
            smallLeftStr = this.toString();
            for(int i = 0; i < (indexDecBd - indexDecThis); i++){
                smallLeftStr = "0" + smallLeftStr;
            }
            setValue(smallLeftStr);
        }
        else if(indexDecThis > indexDecBd){
            smallLeftStr = bD.toString();
                   
            for(int i = 0; i < (indexDecThis - indexDecBd); i++){
                smallLeftStr = "0" + smallLeftStr;
            }
            bD.setValue(smallLeftStr);
        }
        
        
        if((this.toString().length() - this.toString().indexOf(".")) < (bD.toString().length() - bD.toString().indexOf("."))){
            smallRightStr = this.toString();
            for(int i = 0; i < ((bD.toString().length() - bD.toString().indexOf(".")) - (this.toString().length() - this.toString().indexOf("."))); i++){
                smallRightStr += "0";
            }
            setValue(smallRightStr);
        }
        else if((this.toString().length() - this.toString().indexOf(".")) > (bD.toString().length() - bD.toString().indexOf("."))){
            smallRightStr = bD.toString();
            for(int i = 0; i < ((this.toString().length() - this.toString().indexOf(".")) - (bD.toString().length() - bD.toString().indexOf("."))); i++){
                smallRightStr += "0";
            }
            bD.setValue(smallRightStr);
        }
        answer = this.add(bD.ninesComplement());
        
        if(answer.toString().length() > this.toString().length()){
            answer.setValue(answer.toString().substring(1));
            String carry = ".";
            for(int i = 0; i < (answer.toString().length() - answer.toString().indexOf(".") - 1); i++){
                carry = "0" + carry;
            }
            carry = "." + carry + 1;
            answer = answer.add(new BigDecimal(carry));
        }
        else{
            answer.setValue("-" + answer.ninesComplement().toString());
        }
        return answer;
    }
    
    public BigDecimal ninesComplement(){
        String rv = "";
        for(int i = this.toString().length() - 1; i >= 0; i--){
            if(this.toString().charAt(i) == '.'){
                rv = "." + rv;
            }
            else{
                rv = (9 - Character.getNumericValue(this.toString().charAt(i))) + rv;
            }
        }
        return new BigDecimal(rv);
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
}
