package MostAsked100Q;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    // ***************** 1st Method ******************
    // Approach : Use Deque - ArrayDeque
    // Runtime  : 5ms        -> + 91.2%
    // Memory   : 46.9MB      -> + 76.79%
    private Deque<Integer> stk1 = new ArrayDeque<>();
    private Deque<Integer> stk2 = new ArrayDeque<>();

    // initializes the stack object
    public MinStack() {
        stk2.push(Integer.MAX_VALUE);
    }

    // pushes the element val onto the stack
    public void push(int val) {
        stk1.push(val);
        stk2.push(Math.min(stk2.peek(), val));
    }

    // removes the element on the top of the stack
    public void pop() {
        stk1.pop();
        stk2.pop();
    }

    // gets the top element of the stack
    public int top() {
        return stk1.peek();
    }

    // retrieves the minimum element in the stack
    public int getMin() {
        return stk2.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();


        obj.push(-2);

        obj.push(0);

        obj.push(-3);

        System.out.println(obj.getMin());

        System.out.println(obj.top());

        System.out.println(obj.getMin());

    }
}
