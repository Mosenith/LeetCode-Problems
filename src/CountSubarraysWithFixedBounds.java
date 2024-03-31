import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,7,5}; // 2 => [1,3,5] & [1,3,5,2]
        int minK = 1, maxK = 1;

        System.out.println(countSubarrays2(nums,minK,5));
    }

    // ***************** 1st Method ******************
    // Approach 1: Init 3 variables to -1
    // j1-minK index, j2-maxK index, k-out of range of minK & maxK
    // Each iteration update ans += 0 or min(j1-j2)-k
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 41.16MB     -> + 72.08%
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int j1 = -1, j2 = -1, k = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                k = i;
            }
            if (nums[i] == minK) {
                j1 = i;
            }
            if (nums[i] == maxK) {
                j2 = i;
            }
            ans += Math.max(0, Math.min(j1, j2) - k); // make sure it's non-negative
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Similar approach to the 1st just use while and init right(i) = 0
    // Runtime  : 5ms         -> + 100.00%
    // Memory   : 59.44MB     -> + 83.03%
    public static long countSubarrays2(int[] nums, int minK, int maxK) {
        int minI = -1, maxI = -1, left = -1, right = 0;
        long count = 0;
        while(right < nums.length){
            // out of range min & max
            if(nums[right] < minK || nums[right] > maxK){
                minI = right;
                maxI = right;
                left = right;
            }
            minI = nums[right] == minK ? right : minI;
            maxI = nums[right] == maxK ?  right : maxI;
            count += Math.min(minI, maxI) - left;
            right++;
        }
        return count;
    }
    //  ***************** End of 2nd Method ******************
}
