import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
class BrowserHistory {
    // ***************** 1st Method ******************
    // Approach 1: Use 2 stack - stk1 & stk2
    // stk1 - store visit history, stk2 - history from stk1 when we need to backward
    // Every visit(url), stk2 is cleared cos we don't need to store that info anymore
    // Every back(steps), stk1.pop() -> stk2, but if there's only 1 left in stk1, break;
    // Every forward(steps), pop from stk2 to stk1 by steps time, return the last 1 in stk1
    // Runtime  : 58ms         -> + 32.76%
    // Memory   : 52.17MB      -> + 26.88%
    private Deque<String> stk1 = new ArrayDeque<>();
    private Deque<String> stk2 = new ArrayDeque<>();
    public BrowserHistory(String homepage) {
        visit(homepage);
    }

    public void visit(String url) {
        stk1.push(url);
        // after visit stk2 (back history) needs to be cleared out
        stk2.clear();
    }

    public String back(int steps) {
        // when steps > stk1.size() - break when stk1 has 1 last element
        for(; steps > 0 && stk1.size() > 1; steps--) {
            stk2.push(stk1.pop());
        }

        return stk1.peek();
    }

    public String forward(int steps) {
        for(; steps > 0 && !stk2.isEmpty(); steps--) {
            stk1.push(stk2.pop());
        }

        return stk1.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */