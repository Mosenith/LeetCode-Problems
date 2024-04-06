import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";

        System.out.println(maxDepth(s));
    }

    // ***************** 1st Method ******************
    // Approach 1: Init 2 variables depth & curDepth
    // If encounters ( => update depth with max(depth, ++tmpDepth)
    // Else if encounters ) => --tmpDepth
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.16MB     -> + 72.08%
    public static int maxDepth(String s) {
        int depth = 0, tmpDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth = Math.max(depth, ++tmpDepth);
            } else if (c == ')') {
                --tmpDepth;
            }
        }
        return depth;
    }
    //  ***************** End of 1st Method ******************
}
