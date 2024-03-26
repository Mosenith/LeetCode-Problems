import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class ScoreOfParentheses {
    public static void main(String[] args) {
        String s1 = "(()(()))";
        String s2 = "(())";
        String s3 = "()";

        System.out.println(s1.length());
        System.out.println(scoreOfParentheses(s1));
    }

    // ***************** 1st Method ******************
    // Approach 1:
    // Runtime  : 2ms         -> + 99.14%
    // Memory   : 45.15MB     -> + 93.26%
    public static int scoreOfParentheses(String s) {
        int score = s.length()/2; // since it balanced parentheses
        Stack<Character> stk = new Stack<>();

        for(char c : s.toCharArray()) {
            stk.push(c);
        }
        System.out.println(stk);

        for(int i=0; i<s.length()/2; i++) {
            if(stk.size()>2 && s.charAt(i) == '(' && stk.peek() == ')') {
                // (A) rule => 2*A
                score += (stk.size()-2);
            }
        }
        return score;
    }
}
// 1-6 = 6-1+1
// "()" has score 1.
// AB has score A + B, where A and B are balanced parentheses strings.
// (A) has score 2 * A, where A is a balanced parentheses string.