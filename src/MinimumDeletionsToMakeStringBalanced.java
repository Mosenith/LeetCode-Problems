import java.util.Stack;

public class MinimumDeletionsToMakeStringBalanced {
    public static void main(String[] args) {
        String s = "baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb";

        System.out.println(minimumDeletions(s));
        System.out.println(minimumDeletions2(s));
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

    // ***************** 2nd Method ******************
    // Approach 2: Loop through each char in s
    // If char is 'a', increment minDelete with min(minDelete+1,bCount)
    // Else, increment bCount
    // Runtime  : 19ms     -> + 92.48%
    // Memory   : 45.24MB  -> + 77.16%
    public static int minimumDeletions2(String s) {
        int bCount = 0; // count of 'b's encountered so far
        int minDelete = 0; // minimum deletions needed

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++; // increment the count of 'b's
            } else if (c == 'a') {
                // minDelete is either delete this 'a' or delete all 'b's before this 'a'
                minDelete = Math.min(minDelete + 1, bCount);
            }
        }

        return minDelete;
    }
    //  ***************** End of 2nd Method ******************
}
