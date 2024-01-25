import java.util.ArrayList;
import java.util.List;

class BrowserHistory {

    List<String> sites;
    int cur = 0;
    public BrowserHistory(String homepage) {
        sites = new ArrayList<>();
        sites.add(homepage);
    }

    public void visit(String url) {
        int lastest = sites.size()-1;
        while(cur < lastest) {
            sites.remove(lastest);
            lastest = sites.size()-1;
        }

        cur = sites.size();
        sites.add(url);

    }

    public String back(int steps) {
        // move back over Home
        if(cur - steps <= 0) {
            // return home
            return sites.get(0);
        }

        cur -= steps;
        return sites.get(cur);
    }

    public String forward(int steps) {
        // can't move forward return cur
        if(cur + steps >= sites.size()) {
            return sites.get(cur);
        }

        cur += steps;
        return sites.get(cur);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */