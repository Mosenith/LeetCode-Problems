public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 100;

        System.out.println(numSubarrayProductLessThanK(nums, 1));
    }

    // ***************** 1st Method ******************
    // Approach 1: Nested loop to check subArray
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.16MB     -> + 72.08%
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

}
