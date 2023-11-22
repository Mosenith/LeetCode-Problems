package Blind75.Array;

public class PracticeProb152 {
    public static void main(String[] args) {
        int[] nums1 = {2,3,-2,4,2,-1,-100};
        int[] nums2 = {-2,0,-1};

        // 2,3,-2,4,2,-1,-100
        // 0,1, 2,3,4, 5, 6

        System.out.println(maxProduct(nums1));
    }

    public static int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int max = 1, min = 1;

        for(int i=0; i<nums.length; i++) {
            int tmp = max;

            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);

            if(max > ans) {
                ans = max;
            }

        }

        return ans;
    }

}
