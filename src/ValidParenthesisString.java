import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";

        System.out.println(checkValidString2(s));
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

    // ***************** 2nd Method ******************
    // Approach 2: Use 2 stack of integer to store leftStack -> '(' & starStack -> '*'
    // When encounter ')', if !leftStack.empty(), pop it. If it is, pop starStack if it's not empty
    // If both stacks are empty, return false
    // Out of loop, if !leftStack.empty(), closing it with starStack.
    // Star elements need to be bigger than '(' in order to close it. Otherwise, return false.
    // Runtime  : 1ms         -> + 38.32%
    // Memory   : 41.30MB     -> + 57.16%
    public static boolean checkValidString2(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }
        // if there's still some leftover (, then complete it with *
        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            // for * to be ), need to be at pos > '('
            if (leftStack.peek() < starStack.peek()) {
                leftStack.pop();
                starStack.pop();
            } else {
                break;
            }
        }
        return leftStack.isEmpty();
    }
    //  ***************** End of 2nd Method ******************
}

