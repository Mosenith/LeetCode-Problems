import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,-1,0}; // 4
        int k = 0;

        System.out.println(subarraySum(nums, k));
    }

    // ***************** 1st Method ******************
    // Approach 1: Brute force - nested loop
    // Runtime  : 1117ms      -> + 9.64%
    // Memory   : 46.31MB     -> + 54.20%
    public static int subarraySum(int[] nums, int k) {
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            int curSum = 0;
            int nextIndex = i;
            while(nextIndex<nums.length) {
                curSum += nums[nextIndex];
                if(curSum == k) {
                    count++;
                }
                nextIndex++;
            }
        }

        return count;
    }
}
