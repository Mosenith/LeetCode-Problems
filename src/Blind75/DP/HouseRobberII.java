package Blind75.DP;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2};   // 3
        // 1,2,3,1

        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
    }

    private static int rob(int[] nums, int left, int right) {
        System.out.println(left + " : " + right);
        int cur = 0, prev = 0;

        for(; left<=right; left++) {
            int tmp = Math.max(cur,prev);
            cur = prev + nums[left];
            prev = tmp;
            System.out.println(cur + " * " + prev);
        }
        System.out.println("-----\n");
        return Math.max(cur,prev);
    }
}
