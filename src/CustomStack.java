import java.util.Stack;

public class CustomStack {
    // ***************** 1st Method ******************
    // Approach 1: Using Stack
    // Runtime  : 70ms            -> + 6.35%
    // Memory   : 45.38MB        -> + 6.26%
    Stack<Integer> stack;
    int size;
    public CustomStack(int maxSize) {
        this.stack = new Stack<>();
        this.size = maxSize;
    }

    public void push(int x) {
        if(stack.size() < size) {
            stack.push(x);
        }
    }

    public int pop() {
        return stack.isEmpty() ? -1 : stack.pop();
    }

    public void increment(int k, int val) {
        Stack<Integer> tmp = new Stack<>();

        while(!stack.isEmpty()) {
            tmp.push(stack.pop());
        }

        while(!tmp.isEmpty()) {
            if(k > 0) {
                stack.push(tmp.pop() + val);
                k--;
            } else {
                stack.push(tmp.pop());
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */