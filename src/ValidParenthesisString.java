import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";

        System.out.println(checkValidString("(*))"));
    }

    // ***************** 1st Method ******************
    // Approach 1: Init lowerBound(l) and upperBound(u) to keep track of min & max of (
    // When c='(', both +1, when c=')', both -1
    // When c='*', l-- & u++. Check if upperBound<0, return false.
    // If lowerBound<0, reset to 0. Out of loop return lowerBound=0
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.97MB     -> + 90.85%
    public static boolean checkValidString(String s) {
        int lowerBound = 0, upperBound = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                lowerBound++;
                upperBound++;
            } else if (c == ')') {
                lowerBound--;
                upperBound--;
            } else { // '*'
                lowerBound--;
                upperBound++;
            }

            // Check if upperBound becomes negative
            if (upperBound < 0) return false;

            // Reset lowerBound if it becomes negative
            if (lowerBound < 0) lowerBound = 0;
        }

        return lowerBound == 0;
    }
    //  ***************** End of 1st Method ******************
}


//        stkRight.size()+stkStar.size() == stkLeft.size() ||
//        stkLeft.size()+stkStar.size() == stkRight.size()

// 49