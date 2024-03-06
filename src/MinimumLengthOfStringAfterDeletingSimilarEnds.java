public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        String s = "abbbbbbbbbbbbbbbbbbba";

        System.out.println(minimumLength2(s));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use 2 pointers with base condition left < right & s.at(left) == s.at(right)
    // Increment left and decrement right as long as characters are equal
    // Also need to check if left+1<right and right-1>left
    // Each iteration, left++ & right--. After loop, return max(0,right-left+1)
    // Runtime  : 5ms           -> + 32.30%
    // Memory   : 45.00MB       -> + 87.89%
    public static int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            // Increment left and decrement right as long as characters are equal
            while (left+1 < right && s.charAt(left) == s.charAt(left+1)) {
                ++left;
            }
            while (right-1 > left && s.charAt(right) == s.charAt(right-1)) {
                --right;
            }
            left++;
            right--;
        }

        return Math.max(0, right - left + 1);
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use 2 pointers but more optimized by using less charAt
    // Between inner loop, check if left = right return 0;
    // Runtime  : 4ms           -> + 79.81%
    // Memory   : 45.04MB       -> + 73.29%
    public static int minimumLength2(String s) {
        int l = 0, r = s.length()-1;

        while(l < r) {
            char curLeft = s.charAt(l);
            char curRight = s.charAt(r);

            // if s.at(l) != s.at(r) => break;
            if(curLeft != curRight) break;

            // loop till != s.at(l)
            while(l < r && curLeft == s.charAt(l)) {
                l++;
            }

            if(l == r) return 0;

            while(r > l && curRight == s.charAt(r)) {
                r--;
            }
        }

        return r-l+1;
    }
    //  ***************** End of 2nd Method ******************

}