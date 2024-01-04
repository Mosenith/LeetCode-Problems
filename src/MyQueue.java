import java.util.Stack;

// ***************** 1st Method ******************
// Approach 1: Using 2 stacks to create a Queue
// Runtime  : 0ms         -> + 100.00%
// Memory   : 41.27MB     -> + 14.29%
public class MyQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    // add 5
    // q: 1,2,3,4,5
    // s: 1,2,3,4,5
    public void push(int x) {
        stk1.add(x);
    }
    // pop
    // q: 1
    // s:
    public int pop() {
        transferElements();
        int popElement = stk1.pop();
        reputElements();

        return popElement;
    }

    // 5,4,3,2,1
    public int peek() {
        transferElements();
        int peekElement = stk1.peek();
        reputElements();

        return peekElement;
    }

    public boolean empty() {
        return stk1.isEmpty();
    }

    private void reputElements() {
        // Re-put elements stk1 back
        while(!stk2.isEmpty()) {
            stk1.add(stk2.pop());
        }
    }

    private void transferElements() {
        // transfer stk1 to stk2 until stk1 has only 1 last element
        while(stk1.size() != 1) {
            stk2.add(stk1.pop());
        }
    }
}
