public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;

        System.out.println(numSubarrayProductLessThanK2(nums, k));
    }

    // ***************** 1st Method ******************
    // Approach 1: Nested loop to check subArray
    // Runtime  : 851ms       -> + 16.13%
    // Memory   : 47.90MB     -> + 15.67%
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= k) continue;
            int cur = nums[i];
            cnt++;

            for(int j=i+1; j<nums.length; j++) {
                if(cur * nums[j] >= k) break;
                cnt++;
                cur *= nums[j];
            }
        }
        return cnt;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method : Sliding window ******************
    // Approach 2: Use 2 pointers i & j for sliding window and s to keep product under k
    // Iterate from left to right (i=0) while updating s *= nums[i]
    // Check if s>=k means current window is too large => shrink the j(j++) until s<k
    // Each iteration update ans by calculate the distance between i & j
    // Runtime  : 4ms       -> + 99.99%
    // Memory   : 47.71MB   -> + 31.98%
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        int ans = 0;
        for (int i=0, j=0, s=1; i<nums.length; ++i) {
            s *= nums[i];
            while (j<=i && s>=k) {
                s /= nums[j++]; // too large divide by nums[j++] to make sure s<k
            }
            ans += i - j + 1;
        }
        return ans;
    }
    //  ***************** End of 2nd Method ******************
}