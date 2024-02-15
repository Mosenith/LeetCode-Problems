public class PalindromicSubstrings {
    public static void main(String[] args) {
        // 6 - "a", "a", "a", "aa", "aa", "aaa"
        String s = "aba";

        System.out.println(countSubstrings2(s));
    }
    // ***************** 1st Method ******************
    // Approach 1: DP before optimization & no memoization
    // Keep track of the len from curIndex to min(curIndex+k, arr.len) while also update maxElement
    // Find curMax by len * maxElement and + with recursive of same function with index+1
    // Update maxSum -> max(maxSum, curSum) & return maxSum
    // Exceed time limit
    public static int countSubstrings(String s) {
        int count = s.length();

        for(int i=0; i<s.length(); i++) {
            for(int j=i+1; j<s.length(); j++) {
                if(isPalindrome(s.substring(i,j+1))) {
                    System.out.println(i + " : " + j);
                    System.out.println(s.substring(i,j));
                    count++;
                }
            }
        }

        return count;
    }
    private static boolean isPalindrome(String s) {
        for(int i=0,j=s.length()-1; i<j; i++, j--) {
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Expand from the center by start from 0 to s.len*2-1
    // Within loop, set i=k/2, j=(k+1)/2, if s.at(i)=s.at(j)
    // Have count++ and --i,j++, since at match point is the center
    // Runtime  : 2ms        -> + 95.85%
    // Memory   : 41.52MB    -> + 55.37%
    public static int countSubstrings2(String s) {
        int ans = 0;
        int n = s.length();
        for (int k = 0; k < n * 2 - 1; ++k) {
            int i = k / 2, j = (k + 1) / 2;
            // when detect the same char at i & j, that's the center
            // expand from center to i-- and j++
            while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                ++ans;
                --i;
                ++j;
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************
}
