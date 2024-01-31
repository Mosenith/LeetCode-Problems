import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

        DailyTemperatures dt = new DailyTemperatures();
        System.out.println(Arrays.toString(dt.dailyTemperatures(temperatures)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Stack to store index in temp[]
    // Keep checking last element with temp[i], if it's decreasing + !stk.empty
    // Pop and update ans[popIndex] = i - popIndex;
    // Runtime  : 64ms         -> + 53.82%
    // Memory   : 62.94MB      -> + 17.35%
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<temperatures.length; i++) {
            while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int prev = stk.pop();
                ans[prev] = i - prev;
            }
            stk.push(i);
        }

        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Optimized 1st approach by using ArrayDeque
    // Runtime  : 22ms         -> + 92.33%
    // Memory   : 56.22MB      -> + 85.26%
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]) {
                int j = stk.pop();
                ans[j] = i - j;
            }
            stk.push(i);
        }
        return ans;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: brute force : work but over time limit
    public int[] dailyTemperatures3(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];

        for(int i=0; i<len-1; i++) {
            int j = i+1;
            while(j<len && temperatures[i] >= temperatures[j]) {
                j++;
            }

            if(j >= len || temperatures[i] > temperatures[j]) {
                ans[i] = 0;
            } else {
                ans[i] = (j-i);
            }
        }

        return ans;
    }
    //  ***************** End of 3rd Method ******************

}
