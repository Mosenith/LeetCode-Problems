import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BrowserHistory {
    List<String> sites;
    int cur = 0;
    public BrowserHistory(String homepage) {
        BrowserHistory bh = new BrowserHistory(homepage);
        sites = new ArrayList<>();
    }

    public void visit(String url) {
        int prevSize = sites.size();
        while(cur < prevSize-1) {
            sites.remove(cur++);
        }

        cur = sites.size();
        sites.add(url);
        cur++;
    }

    public String back(int steps) {
        // move back over Home
        if(cur - steps < 0) {
            // return home
            return sites.get(0);
        }

        cur -= steps;
        return sites.get(cur);
    }

    public String forward(int steps) {
        // can't move forward return cur
        if(cur + steps > sites.size()) {
            return sites.get(cur);
        }

        cur += steps;
        return sites.get(cur);
    }
}
