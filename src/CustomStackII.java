import java.util.ArrayList;
import java.util.List;

public class CustomStackII {

    // ***************** 2nd Method ******************
    // Approach 1: Using Stack
    // Runtime  : 9ms            -> + 22.99%
    // Memory   : 44.88MB        -> + 19.07%
    List<Integer> ls;
    int maxSize;
    int curSize;
    public CustomStackII(int maxSize) {
        this.ls = new ArrayList<>();
        this.maxSize = maxSize;
        curSize = ls.size();
    }

    public void push(int x) {
        if(curSize < maxSize) {
            ls.add(x);
            curSize++;
        }
    }

    public int pop() {
        if(ls.isEmpty()) return -1;
        curSize--;
        return ls.remove(curSize);
    }

    public void increment(int k, int val) {
        for(int i=0; i<k && i<ls.size(); i++) {
            int cur = ls.get(i);
            ls.set(i,cur+val);
        }
    }
}
