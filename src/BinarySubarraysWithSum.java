import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;

        System.out.println(numSubarraysWithSum3(nums,2));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use memoize(cnt[]) by keeping track of sum & each iteration ++cnt[s]
    // If sum-goal>=0, add ans += cnt[sum-goal]
    // Runtime  : 3ms          -> + 73.47%
    // Memory   : 48.42MB      -> + 35.73%
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int[] cnt = new int[nums.length + 1];
        cnt[0] = 1;
        int ans = 0, s = 0;
        for (int v : nums) {
            s += v;
            if (s - goal >= 0) {
                ans += cnt[s - goal];
            }
            ++cnt[s];
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use recursion, not the best time complexity but good memory usage
    // Runtime  : 1790ms        -> + 14.09%
    // Memory   : 47.01MB       -> + 95.54%
    public static int numSubarraysWithSum2(int[] nums, int goal) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += countSubarrays(nums, goal, i);
        }
        return ans;
    }

    private static int countSubarrays(int[] nums, int goal, int start) {
        int count = 0;
        int curSum = 0;
        for (int i = start; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum == goal) {
                count++;
            } else if (curSum > goal) {
                break; // No need to continue as sum can't be achieved further
            }
        }
        return count;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Similar to 1st approach but use map
    // Runtime  : 21ms          -> + 52.78%
    // Memory   : 49.16MB       -> + 27.99%
    public static int numSubarraysWithSum3(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with 0 sum occurring once

        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    //  ***************** End of 3rd Method ******************
}
