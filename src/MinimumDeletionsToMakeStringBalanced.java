import java.util.Stack;

public class MinimumDeletionsToMakeStringBalanced {
    public static void main(String[] args) {
        String s = "baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb";

        System.out.println(minimumDeletions(s));
    }

    // ***************** 1st Method ******************
    // Approach 1: Loop through each char in s
    // If char is 'a', increment minDelete with min(minDelete+1,stk.size())
    // Else, add 'b' to stack
    // Runtime  : 38ms     -> + 43.18%
    // Memory   : 45.48MB  -> + 39.55%
    public static int minimumDeletions(String s) {
        Stack<Character> stk = new Stack<>();
        int minDelete = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                minDelete = Math.min(minDelete + 1, stk.size());
            } else {
                stk.add('b');
            }
        }

        return minDelete;
    }
    //  ***************** End of 1st Method ******************
}
