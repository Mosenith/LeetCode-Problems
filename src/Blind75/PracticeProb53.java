package Blind75;

public class PracticeProb53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];

        int curMax = nums[0];
        int ansMax = nums[0];

        for(int i=1; i<nums.length; i++) {
            curMax = Math.max(nums[i], curMax+nums[i]);
            ansMax = Math.max(ansMax, curMax);
        }

        return ansMax;
    }
}
