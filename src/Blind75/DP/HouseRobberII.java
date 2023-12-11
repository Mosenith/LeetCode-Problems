package Blind75.DP;

import java.util.Arrays;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};   // 3
        // 1,2,3,1

        System.out.println(rob2(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Since array => circle, max(rob(0,len-1) & rob(0,len-2)
    // Runtime  : 1ms        -> + 100.00%
    // Memory   : 40.18MB    -> + 31.67%
    public static int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
    }

    private static int rob(int[] nums, int left, int right) {
        int cur = 0, prev = 0;

        for(; left<=right; left++) {
            int tmp = Math.max(cur,prev);
            cur = prev + nums[left];
            prev = tmp;
        }
        return Math.max(cur,prev);
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Similar to the 1st approach but use dp[] to store result at each step
    // Runtime  : 1ms        -> + 100.00%
    // Memory   : 40.10MB    -> + 40.59%
    public static int rob2(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        return Math.max(rob2(nums, 0, len - 2), rob2(nums, 1, len - 1));
    }

    private static int rob2(int[] nums, int left, int right) {
        int[] dp = new int[right-left+2];
        dp[1] = nums[left++];
        int idx = 2;

        for(; left<=right && idx<dp.length; left++) {
            dp[idx] = Math.max(dp[idx-1], dp[idx-2] + nums[left]);
            idx++;
        }

        return dp[dp.length-1];
    }
    // ***************** End of 2nd Method ******************
}
