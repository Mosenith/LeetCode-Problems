import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class MyStack {
    private Stack<Integer> stack;
    public MyStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
