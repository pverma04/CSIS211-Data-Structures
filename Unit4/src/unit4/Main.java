package unit4;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        //System.out.println(revPolCalc("6 2 + 1 * 3 *"));
        System.out.println(inFixConversion("3 + 2 + 4 / 3"));
    }
    
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
    
    public static Double inFixConversion(String inFix){
        Stack<String> stk = new Stack<String>();
        String postFix = "";
        int index = 0;
        for(String s : inFix.split("\\s+")){
            switch (s) {
                case "+":
                    if(stk.peek() == null){
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
            index++;
        }
        while(stk.peek() != null){
            postFix += stk.peek();
            stk.pop();
        }
        System.out.println("check: " + postFix);

        return revPolCalc(postFix);
    }
}
