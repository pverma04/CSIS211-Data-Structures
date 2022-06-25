
package unit4;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.printQueue();
        System.out.println("__" + q.peek());
        q.dequeue();
        System.out.println("__" + q.peek());
        q.dequeue();
        System.out.println("__" + q.peek());
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.printQueue();

        System.out.println("__size" + q.size);

        
        
        /*
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
        */

    }
    
}
