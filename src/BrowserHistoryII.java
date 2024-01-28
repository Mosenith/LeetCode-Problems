import java.util.ArrayList;
import java.util.List;

public class BrowserHistoryII {
    // ***************** 2nd Method ******************
    // Approach 2: Use 1 list, cur - cur Position, stepBack - num of backward
    // In visit(), clear out the list from cur+1 to ls.size()
    // In back() & forward(), check if cur+/-steps is over the limit of the given algorithms
    // Runtime  : 53ms         -> + 53.42%
    // Memory   : 50.56MB      -> + 43.81%
    List<String> ls = new ArrayList<>();
    int cur = 0;

    public BrowserHistoryII(String homepage) {
        ls.add(homepage);
    }

    public void visit(String url) {
        ls.subList(cur + 1, ls.size()).clear(); // Clear forward history
        ls.add(url);
        cur++;
    }

    public String back(int steps) {
        if(cur - steps < 0) {
            cur = 0;
            return ls.get(0);
        }

        cur -= steps;
        return ls.get(cur);
    }

    public String forward(int steps) {
        if(cur + steps >= ls.size()) {
            cur = ls.size()-1;
            return ls.get(cur);
        }

        cur += steps;
        return ls.get(cur);
    }
    //  ***************** End of 2nd Method ******************
}
