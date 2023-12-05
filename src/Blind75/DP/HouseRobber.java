package Blind75.DP;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int[] nums2 = {4,1,2,7,5,3,1};
        int[] nums3 = {2,1,1,2};

        System.out.println(rob(nums));
    }

    // ***************** 1st Method ******************
    // Approach : Dynamic Programming
    // Runtime  : 1ms        -> + 100.00%
    // Memory   : 39.77MB    -> + 61.89%
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];

        for(int i=2; i<=nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return dp[nums.length];
    }

}
