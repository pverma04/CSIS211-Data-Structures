
package unit4;

public class Main {

    public static void main(String[] args) {
        
        System.out.println(revPolCalc("5 3 1 + *"));

    }
    
    public static Integer revPolCalc(String input) {
        Stack<Integer> stk = new Stack<Integer>();
        Integer firstInteger;
        Integer secondInteger;
        
        for(String s : input.split("\\s+")){
            switch (s) {
                case "1":
                    stk.push(1);
                    break;
                case "2":
                    stk.push(2);
                    break;
                    
                case "3":
                    stk.push(3);
                    break;
                    
                case "4":
                    stk.push(4);
                    break;
                    
                case "5":
                    stk.push(5);
                    break;
                    
                case "6":
                    stk.push(6);
                    break;
                    
                case "7":
                    stk.push(7);
                    break;
                    
                case "8":
                    stk.push(8);
                    break;
                    
                case "9":
                    stk.push(9);
                    break;
                    
                case "0":
                    stk.push(0);
                    break;
                
                case "+":
                    secondInteger = stk.peek();
                    stk.pop();
                    firstInteger = stk.peek();
                    stk.pop();
                    stk.push(firstInteger + secondInteger);
                    break;
                    
                case "-":
                    secondInteger = stk.peek();
                    stk.pop();
                    firstInteger = stk.peek();
                    stk.pop();
                    stk.push(firstInteger - secondInteger);
                    break;
                    
                case "*":
                    secondInteger = stk.peek();
                    stk.pop();
                    firstInteger = stk.peek();
                    stk.pop();
                    stk.push(firstInteger * secondInteger);
                    break;
                    
                case "/":
                    secondInteger = stk.peek();
                    stk.pop();
                    firstInteger = stk.peek();
                    stk.pop();
                    stk.push(firstInteger / secondInteger);
                    break;
                    
                default:
                    throw new AssertionError();
            }
        }
        return (Integer) stk.peek();
    }
    
}
