package unit4;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        System.out.println(isNumeric("1"));
        System.out.println(revPolCalc("6 2 1 3 * + /"));
    }
    
    public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
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
    
}
