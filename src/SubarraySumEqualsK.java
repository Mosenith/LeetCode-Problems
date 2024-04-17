import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,-1,0}; // 4
        int k = 0;

        System.out.println(subarraySum2(nums, k));

        int n = 25;
        System.out.println(String.valueOf((char) (n + 'a')));
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
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use map with key as curSum and value is its frequency
    // Each iteration update ans with value of curSum
    // Runtime  : 3ms         -> + 78.07%
    // Memory   : 45.61MB     -> + 58.12%
    public static int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);
        int ans = 0, curSum = 0;
        for (int num : nums) {
            curSum += num;
            ans += counter.getOrDefault(curSum - k, 0);
            counter.put(curSum, counter.getOrDefault(curSum, 0) + 1);
        }
        return ans;
    }
    //  ***************** End of 2nd Method ******************
}
