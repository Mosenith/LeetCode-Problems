package MostAsked100Q;

public class MaximumProductSubarray {
    public static void main(String[] args) {
//        int[] nums = {2,3,-2,4}; // 6
        int[] nums = {-1,-1,0};
        int[] nums1 = {-1,0,-3};
        //-1,-1,0
        // -2,2,0,2,-3
        System.out.println(maxProduct(nums));
        System.out.println("*****");
        System.out.println(maxProduct(nums1));

    }

    // ***************** 1st Method ******************
    // Approach 1: Keep max, min, ans & update max & min every iteration
    // Get temp <- max before update max = max(max(min * n[i], max * n[i]), n[i])
    // Check if max > ans, set ans = max
    // Runtime  : 1ms            -> + 99.68%
    // Memory   : 40.71MB        -> + 89.16%
    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;  // store the max because before updating min your max will already be updated

            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            if (max > ans) {
                ans = max;
            }
        }

        return ans;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: 2 pointers => left & right
    // check if left & right = 0, then set to 1. Otherwise, left & right
    // Left *= nums[i], Right *= nums[len-1-i]
    // Ans = max(nums[i], max(left,right))
    // Runtime  : 1ms            -> + 86.72%
    // Memory   : 43.24MB        -> + 47.55%
    public static int maxProduct2(int[] nums) {
        int n = nums.length;
        int l=1,r=1;
        int ans=nums[0];

        for(int i=0;i<n;i++){

            //if any of l or r become 0 then update it to 1
            l = l==0 ? 1 : l;
            r = r==0 ? 1 : r;

            l *= nums[i];   //prefix product
            r *= nums[n-1-i];    //suffix product

            ans = Math.max(ans,Math.max(l,r));

        }
        return ans;
    }
    // ***************** End of 2nd Method ******************


}
