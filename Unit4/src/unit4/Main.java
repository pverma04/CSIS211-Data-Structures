
package unit4;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.printStack();
        stk.pop();
        stk.printStack();
        //System.out.println("--");
        //stk.printStack();
        //System.out.println("Peek: " + stk.peek());
        stk.pop();
        stk.pop();
        stk.pop();
        stk.pop();
        stk.printStack();

    }
    
}
