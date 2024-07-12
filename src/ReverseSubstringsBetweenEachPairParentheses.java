import java.util.*;

public class ReverseSubstringsBetweenEachPairParentheses {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";

        System.out.println(reverseParentheses(s));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use stack to store the index of '('
    // Loop through s, if s[i] == '(', push i to stack
    // If s[i] == ')', pop from stack and assign d[i] = tmp and d[tmp] = i
    // Loop through s, if s[i] == '(' or ')', i = d[i] and x = -x
    // Else, append s[i] to sb. Return sb.toString()
    // Runtime  : 1ms         -> + 62.26%
    // Memory   : 41.62MB     -> + 55.05%
    public static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int[] d = new int[s.length()];
        Deque<Integer> stk = new ArrayDeque<>();

        for(int i=0; i<s.length(); ++i) {
            if(s.charAt(i) == '(') {
                stk.push(i);
            } else if(s.charAt(i) == ')') {
                int tmp = stk.pop();
                d[i] = tmp;
                d[tmp] = i;
            }
        }

        int i=0, x=1;
        while(i < s.length()) {
            if(s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = d[i];
                x = -x;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
