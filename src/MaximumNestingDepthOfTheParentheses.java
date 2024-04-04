import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";

        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        int depth = 0, curDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth = Math.max(depth, ++curDepth);
            } else if (c == ')') {
                --curDepth;
            }

            System.out.println(c);
            System.out.println(depth + " : " + curDepth);
            System.out.println("******\n");
        }

        return depth;
    }
}
