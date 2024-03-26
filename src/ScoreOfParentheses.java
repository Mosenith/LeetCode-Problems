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
    // Approach 1:
    // Runtime  : 2ms         -> + 99.14%
    // Memory   : 45.15MB     -> + 93.26%
    public static int scoreOfParentheses(String s) {
        int score = 0; // since it balanced parentheses
        for(int i=0,j=s.length()-1; i<j;) {
            if(s.charAt(i) == '(' && s.charAt(i+1) != ')'
                    && s.charAt(j) == ')' && s.charAt(j-1) != '(') {
                System.out.println("2A rule");
                // (A) rule => 2*A
                score += ((j-i-1));
                break;
            } else if(s.charAt(i) == '(' && s.charAt(i+1) == ')'){
                System.out.println("Form at the front");
                score++;
                i += 2;
            } else if(s.charAt(j) == ')' && s.charAt(j-1) == '(') {
                System.out.println("Form at the back");
                score++;
                j -= 2;
            }
            System.out.println(i + " : " + j);
            System.out.println("******** " + score + " *********\n");
        }
        return score;
    }
}
// 1-6 = 6-1+1
// "()" has score 1.
// AB has score A + B, where A and B are balanced parentheses strings.
// (A) has score 2 * A, where A is a balanced parentheses string.