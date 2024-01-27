import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
class BrowserHistory {

    private Deque<String> stk1 = new ArrayDeque<>();
    private Deque<String> stk2 = new ArrayDeque<>();
    public BrowserHistory(String homepage) {
        visit(homepage);
    }

    public void visit(String url) {
        stk1.push(url);
    }

    public String back(int steps) {

    }

    public String forward(int steps) {
        // can't move forward return cur

    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */