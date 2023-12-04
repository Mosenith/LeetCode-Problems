package Blind75.DP;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int[] nums2 = {2,1,1,2};

        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+1];

        return dp[nums.length];
    }
}
