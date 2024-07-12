import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        String s = "aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha";

        System.out.println(maximumGain(s,1926,4320));
    }


    // ***************** 1st Method ******************
    // Approach 1: Use 2 stacks to store the characters of s
    // XStack for x > y and YStack for y > x
    // For x>y, if cur char is b and top of XStack is a, pop and increment numX
    // Out of loop, check leftover "ba" in XStack,
    // if b is top of XStack and a is top of YStack, pop both and increment numY
    // Otherwiser, push to YStack.
    // For x<y, if cur char is a and top of YStack is b, pop and increment numY
    // Similar to the above, check leftover "ab" in YStack
    // Runtime  : 142ms       -> + 60.00%
    // Memory   : 46.69MB     -> + 41.90%
    public static int maximumGain(String s, int x, int y) {
        Stack<Character> stkX = new Stack<>();
        Stack<Character> stkY = new Stack<>();
        int numX = 0;
        int numY = 0;

        if(x > y) {
            // "ab"
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == 'b' && !stkX.isEmpty() && stkX.peek() == 'a') {
                    stkX.pop();
                    numX++;
                } else {
                    stkX.push(s.charAt(i));
                }
            }
            // check leftover "ba"
            while(!stkX.isEmpty()) {
                if(stkX.peek() == 'b' && !stkY.isEmpty() && stkY.peek() == 'a') {
                    stkY.pop();
                    stkX.pop();
                    numY++;
                } else {
                    stkY.push(stkX.pop());
                }
            }
        } else {
            // "ba"
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == 'a' && !stkY.isEmpty() && stkY.peek() == 'b') {
                    stkY.pop();
                    numY++;
                } else {
                    stkY.push(s.charAt(i));
                }
            }

            // check leftover "ab"
            while(!stkY.isEmpty()) {
                if(stkY.peek() == 'a' && !stkX.isEmpty() && stkX.peek() == 'b') {
                    stkX.pop();
                    stkY.pop();
                    numX++;
                } else {
                    stkX.push(stkY.pop());
                }
            }
        }
        return numX*x + numY*y;
    }
    // ***************** End of 1st Method ******************
}
