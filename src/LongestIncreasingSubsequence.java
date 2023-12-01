import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18}; // 4

        System.out.println(lengthOfLIS(nums));
    }

    // ***************** 1st Method ******************
    // Approach : Dynamic Programming
    // dp := store the length of the longest increasing subsequence at each index
    // len of the increasing subsequence ending at any index is at least 1 (the element itself)
    // if curNum[i] > prevNum[j], update[i] to min(dp[i],dp[j]+1)
    // maxLen is the max element in dp[]
    // Runtime  : 40ms           -> + 59.27%
    // Memory   : 43.18 MB      -> + 54.18%
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i=1; i<nums.length; i++) {
            int cur = nums[i];
            for(int j=i-1; j>=0; j--) {
                if(cur > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = Arrays.stream(dp).max().getAsInt();
        return maxLength;
    }
    // ***************** End of 1st Method ******************
}
