import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class ScoreOfParentheses {
    public static void main(String[] args) {
        String s1 = "(()(()))"; // 6
        String s2 = "(())(())"; // 4
        String s3 = "(())()";

        System.out.println(scoreOfParentheses2(s3));
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
    // Approach 2: Use stack when encounter '(', push score to stack and reset score
    // Otherwise, set score = stack.pop() + max(2*score, 1)
    // Runtime  : 3ms         -> + 78.07%
    // Memory   : 45.61MB     -> + 58.12%
    public static int scoreOfParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0; // Reset score for inner parentheses
            } else {
                score = stack.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }
    //  ***************** End of 2nd Method ******************
}