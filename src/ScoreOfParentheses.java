import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class ScoreOfParentheses {
    public static void main(String[] args) {
        String s1 = "(()(()))"; // 6
        String s2 = "(())(())"; // 4
        String s3 = "(())()";

        System.out.println(scoreOfParentheses(s2));
    }

    // ***************** 1st Method ******************
    // Approach 1: Init ans=0, d=0 and start from i=0, if s.at(i) = '(' -> d++
    // Else --d and check if s.at(i-1) = '(', ans += (1<<d)
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.16MB     -> + 72.08%
    public static int scoreOfParentheses(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                ++d;
            } else {
                --d;
                if (s.charAt(i - 1) == '(') {
                    ans += 1 << d; // determine the score associated with a certain depth d of parentheses
                }
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Similar approach to the 1st
    // First find freq(cnt[]) of tasks & maxFreq
    // Find #maxFreq of char in cnt[] & find interval by max(tasks.length, (maxFreq-1)*(n+1)+s)
    // Runtime  : 3ms         -> + 78.07%
    // Memory   : 45.61MB     -> + 58.12%

}