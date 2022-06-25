
package unit4;

public class Main {

    public static void main(String[] args) {
        
        Stack<Integer> stk = new Stack<Integer>();
        System.out.println("size" + stk.size);
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        stk.print();
        System.out.println("--");        
        System.out.println("Peek: " + stk.peek());
        stk.pop();
        stk.print();
        System.out.println("Peek: " + stk.peek());
        System.out.println("--");
        stk.pop();
        stk.pop();
        stk.print();
        System.out.println("Peek: " + stk.peek());
        stk.pop();
        stk.print();
        System.out.println("Peek: " + stk.peek());
        System.out.println("size" + stk.size);
        stk.pop();
        stk.print();
        System.out.println("Peek: " + stk.peek());




    }
    
}
