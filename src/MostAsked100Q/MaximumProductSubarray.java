package MostAsked100Q;

public class MaximumProductSubarray {
    public static void main(String[] args) {
//        int[] nums = {-2,0,-1}; // 6
        int[] nums = {-2,3,-4};
        // -2,2,2,-3
        System.out.println(maxProduct(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Keep max, min, ans & update max & min every iteration
    // max = max(max(min * n[i], max * n[i]), n[i])
    // Runtime  : 1ms            -> + 99.68%
    // Memory   : 40.71MB        -> + 89.16%
    public static int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int ans = Integer.MIN_VALUE;

        for(int i=0, j=1; j<nums.length; i++,j++) {
            int product = nums[i] * nums[j];
            ans = Math.max(ans, nums[i]);
            ans = Math.max(ans, nums[j]);
            ans = Math.max(ans, product);
        }
        return ans;
    }
}
