import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

// Instruction -> use only 2 queues
// ***************** 1st Method ******************
// Approach 1: Other than 2 queues, we can also use List
// In push(), if q1 not empty, add all elements in q1 to q2 first
// Then, add new element to q1 before removing all elements in q2 to q1 again
// This ensures that pop(),peek() of stack will return the last added element
// Runtime  : 0ms           -> + 100.00%
// Memory   : 41.20MB       -> + 10.11%
public class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        if(q1.isEmpty()) q1.add(x);
        else {
            while(!q1.isEmpty()) {
                q2.add(q1.remove());    // use remove so that if q1.isEmpty => return exception not null
            }
            q1.add(x);
            while(!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
