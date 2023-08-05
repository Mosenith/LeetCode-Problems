import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LongestValidParentheses {

    //    ***************** 1st Method ******************
    // Runtime  : 7ms        -> + 41.54%
    // Memory   : 41.9MB      -> + 92.29%%
    public static int longestValidParentheses(String s) {
        Stack<Integer> storeIndex = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                storeIndex.push(i);
            } else {
                if(storeIndex.isEmpty() || s.charAt(storeIndex.peek()) == ')')
                    storeIndex.push(i);
                else
                    storeIndex.pop();
            }
        }

        System.out.println(storeIndex);
        if(storeIndex.size() == 0) return s.length();
        int ans = storeIndex.get(0);
        for(int i=0; i<storeIndex.size()-1; i++) {
            // find max distance
            ans = Math.max(storeIndex.get(i+1)-storeIndex.get(i)-1, ans);
        }

        return Math.max(s.length()-1-storeIndex.peek(), ans);
    }
    //  ***************** End of 1st Method ******************

    //    ***************** 2nd Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 42.6MB      -> + 63.45%
    public static int longestValidParentheses2(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int[] dp = new int[n];
        int ans = 0;
        System.out.println(cs);
        for (int i = 1; i < n; ++i) {
            if (cs[i] == ')') {
                if (cs[i - 1] == '(') {
                    dp[i] = 2 + (i > 1 ? dp[i - 2] : 0);
                } else {
                    int j = i - dp[i - 1] - 1;
                    if (j >= 0 && cs[j] == '(') {
                        dp[i] = 2 + dp[i - 1] + (j > 0 ? dp[j - 1] : 0);
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }
    //  ***************** End of 2nd Method ******************

    //    ***************** 3rd Method ******************
    // Runtime  : 7ms        -> + 40.46%
    // Memory   : 42MB      -> + 87.45%
    public static int longestValidParentheses3(String s) {
        if(s.length() < 2) return 0;
        int max = 0;
        Stack<Integer> myStack = new Stack<>();
        myStack.push(-1);
        int newTop = myStack.peek();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                myStack.push(i);
                newTop = i;
            } else {
                if(myStack.peek() == -1 || s.charAt(myStack.peek()) != '(') {
                    myStack.push(i);
                    newTop = i;
                } else {
                    myStack.pop();
                    newTop = myStack.peek();
                    max = Math.max(i - newTop, max);
                }
            }
        }
        return max;
    }
    //  ***************** End of 3rd Method ******************

    public static void main(String[] args) {
//        String s = "(()";        // out : 2
//         String s = ")()())";    // out : 4
//        String s = "()(())";      // out: 6
//        String s = "()(()";         // out: 2
//        String s = "()(()()(()(";   // out : 4
//        String s = "(()))())(";     // out : 4
//        String s = "(((((((()";     // out : 2
        String s = "()((())()";     // out : 6
//        String s = ")(()((((())";     // out : 4

        System.out.println(longestValidParentheses3(s));
//        System.out.println(s.length());
//        System.out.println(s.substring(2,5));
    }
}
