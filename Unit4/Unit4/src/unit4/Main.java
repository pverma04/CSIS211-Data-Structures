/** ***********************************************
 * File: Main.java
 * Author: Parth Verma
 * Description: This file contains code for the Main class of unit 4 (including 
 * the Reverse Polish Notation Calculator and the Infix to Postfix conversion 
 * Calculator)
 * Date: June 30, 2022
 ************************************************ */
package unit4;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        //System.out.println(revPolCalc("20 5 - 47 9  / +"));
        System.out.println(inFixConversion("( 20 + ( ( ( 10       / 5 ) ) )  * 70 )"));
    }
    
    /**
     * ***********************************************
     * @par Name isNumeric
     * @purpose A helper method to determine if a given string is numeric
     * @param [in] : String strNum
     * @return boolean
     * @par References None
     * @par Notes None ***********************************************
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } 
        catch (NumberFormatException nfe) { 
            return false;
        }
        return true;
    }
    
    /**
     * ***********************************************
     * @par Name precedence
     * @purpose A helper method to determine the operating precedence of a 
     * given operator
     * @param [in] : String operator
     * @return int
     * @par References None
     * @par Notes None ***********************************************
     */
    public static int precedence(String operator){
        int rv = 0;
        switch (operator) {
            case "+":
                rv = 1;
                break;
            case "-":
                rv = 1;
                break;
                
            case "*":
                rv = 2;
                break;
                
            case "/":
                rv = 2;
                break;
        }
        return rv;
    }
    
    /**
     * ***********************************************
     * @par Name revPolCalc
     * @purpose Given a string in postFix notation, calculate the answer
     * @param [in] : String input
     * @return Double
     * @par References None
     * @par Notes None ***********************************************
     */
    public static Double revPolCalc(String input) {
        Stack<Double> stk = new Stack<Double>();
        Double firstDouble;
        Double secondDouble;
        
        for(String s : input.split("\\s+")){
            
                switch (s) {
                    case "+":
                        secondDouble = stk.peek();
                        stk.pop();
                        firstDouble = stk.peek();
                        stk.pop();
                        stk.push(firstDouble + secondDouble);
                        break;

                    case "-":
                        secondDouble = stk.peek();
                        stk.pop();
                        firstDouble = stk.peek();
                        stk.pop();
                        stk.push(firstDouble - secondDouble);
                        break;

                    case "*":
                        secondDouble = stk.peek();
                        stk.pop();
                        firstDouble = stk.peek();
                        stk.pop();
                        stk.push(firstDouble * secondDouble);
                        break;

                    case "/":
                        secondDouble = stk.peek();
                        stk.pop();
                        firstDouble = stk.peek();
                        stk.pop();
                        stk.push(firstDouble / secondDouble);
                        break;

                    default:
                    if(isNumeric(s)){
                        stk.push((Double) Double.parseDouble(s));
                    }
                }
            }
        return (Double) stk.peek();
    }    
    
    /**
     * ***********************************************
     * @par Name inFixConversion
     * @purpose Given a string in inFix notation, convert it to postFix and 
     * then solve for the answer
     * @param [in] : String inFix
     * @return Double
     * @par References None
     * @par Notes None ***********************************************
     */
    public static Double inFixConversion(String inFix){
        Stack<String> stk = new Stack<String>();
        String postFix = "";
        int openParentheses = 0;
        int closeParentheses = 0;
        for(String s : inFix.split("\\s+")){
            if(s.equals("(")){
                openParentheses++;
            }
            if(s.equals(")")){
                closeParentheses++;
            }
        }
        if(openParentheses == closeParentheses){
            for (String s : inFix.split("\\s+")) {
                switch (s) {
                    case "+":
                        if (stk.peek() == null) {
                            stk.push(s);
                        } else if (precedence(s) <= precedence(stk.peek())) {
                            postFix += stk.peek() + " ";
                            stk.pop();
                            stk.push(s);
                        } else {
                            stk.push(s);
                        }
                        break;

                    case "-":
                        if (stk.peek() == null) {
                            stk.push(s);
                        } else if (precedence(s) <= precedence(stk.peek())) {
                            postFix += stk.peek() + " ";
                            stk.pop();
                            stk.push(s);
                        } else {
                            stk.push(s);
                        }
                        break;

                    case "*":
                        if (stk.peek() == null) {
                            stk.push(s);
                        } else if (precedence(s) <= precedence(stk.peek())) {
                            postFix += stk.peek() + " ";
                            stk.pop();
                            stk.push(s);
                        } else {
                            stk.push(s);
                        }
                        break;

                    case "/":
                        if (stk.peek() == null) {
                            stk.push(s);
                        } else if (precedence(s) <= precedence(stk.peek())) {
                            postFix += stk.peek() + " ";
                            stk.pop();
                            stk.push(s);
                        } else {
                            stk.push(s);
                        }
                        break;

                    case "(":
                        stk.push(s);
                        break;

                    case ")":
                        while (!stk.peek().equals("(")) {
                            postFix += stk.peek() + " ";
                            stk.pop();
                        }
                        stk.pop(); //pop "("
                        break;

                    default:
                        if (isNumeric(s)) {
                            postFix += s + " ";
                        }
                }
            }
            while (stk.peek() != null) {
                postFix += stk.peek() + " ";
                stk.pop();
            }
            System.out.println("check: " + postFix);

            return revPolCalc(postFix);
        }
        else{
            System.out.println("Mismatched Parentheses");
            return null;
        }
    }
}
