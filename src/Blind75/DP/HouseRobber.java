package Blind75.DP;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int[] nums2 = {2,1,3};

        System.out.println(rob(nums2));
    }

    // skip 1, 2, 3 < len-2
    // start 0, 1,
    public static int rob(int[] nums) {
        if(nums.length <= 2) {
            return Arrays.stream(nums).max().getAsInt();
        }

        int[] dp = new int[nums.length+1];

        helper(nums,dp,0,0,1);

        System.out.println(Arrays.toString(dp));
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);

        return max;
    }

    private static void helper(int[] nums, int[] dp, int index, int start, int skip) {
        System.out.println(index + " : " + start);

        if(start >= nums.length-2) {
            if(skip < nums.length-2) {
                start = 0;
                skip += 1;
            } else {
                return;
            }
        }

        for(int i=start; i<nums.length && index < dp.length; i+=skip+1) {
            dp[index] += nums[i];
        }

        System.out.println(Arrays.toString(dp));
        helper(nums,dp,index+1, start+1,skip);

    }
}
