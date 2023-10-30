import java.util.Arrays;

public class CustomStackIII {
    public static void main(String[] args) {
        CustomStackIII cs = new CustomStackIII(3);
        cs.push(1);
        cs.push(2);
        cs.push(3);
        cs.increment(5,100);
        cs.increment(2, 100);

        cs.pop();
    }

    // ***************** 3rd Method ******************
    // Approach 3: Using 2 Arrays => stk-track push elements, add-increment
    // In pop(), we get the popElement from stk[--curSize] + add[curSize]
    // Then check curSize > 0, update total add => add[curSize - 1] += add[curSize]
    // Then set add[curSize] to 0
    // In increment(), index to update add to value => Math.min(curSize, k) - 1
    // Runtime  : 4ms            -> + 100%
    // Memory   : 44.24MB        -> + 55.62%
    private int[] stk;
    private int[] add;
    private int curSize;

    public CustomStackIII(int maxSize) {
        stk = new int[maxSize];
        add = new int[maxSize];
    }

    public void push(int x) {
        if (curSize < stk.length) {
            stk[curSize++] = x;
        }
    }
    // 1,2,3
    public int pop() {
        if (curSize <= 0) {
            return -1;
        }
        int ans = stk[--curSize] + add[curSize];

        if (curSize > 0) {
            add[curSize - 1] += add[curSize];
        }
        add[curSize] = 0;
        return ans;
    }

    public void increment(int k, int val) {
        if (curSize > 0) {
            add[Math.min(curSize, k) - 1] += val;
        }
    }
    // ***************** End of 3rd Method ******************

}
