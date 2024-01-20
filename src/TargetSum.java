import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};

        TargetSum t = new TargetSum();
        System.out.println(t.findTargetSumWays2(nums,3));
    }

    // ***************** 1st Method ******************
    // Approach 1: Decision Tree of +1 or -1 to reach the target
    // curSum - target represents the amount by which we need to offset the sum to reach the target.
    // (curSum - target) / 2 is used to calculate the average offset required for each side of the expression.
    // Dividing by 2 ensures that the offsets on both sides (positive and negative) sum up to the overall offset needed to reach the target.
    // dp[] is used to keep track of the number of ways to reach each possible sum
    // Runtime  : 4ms         -> + 96.17%
    // Memory   : 51.05MB     -> + 43.93%
    public int findTargetSumWays(int[] nums, int target) {
        int curSum = 0;
        for(int n : nums) {
            curSum += n;
        }

        if(curSum < target || (curSum-target)%2 != 0) return 0;

        int targetSum = (curSum - target) / 2;
        int[] dp = new int[targetSum+1];
        dp[0] = 1;

        System.out.println("targetSum ==> " + targetSum);
        for(int n : nums) {
            System.out.println("Curr ==>> " + n);
            System.out.println("Before --> " + Arrays.toString(dp));
            for(int i=targetSum; i>=n; i--) {
                dp[i] += dp[i-n];
            }
            System.out.println(Arrays.toString(dp));
            System.out.println("*****************");
        }

        System.out.println(Arrays.toString(dp));

        return dp[targetSum];
    }


    // ***************** 2nd Method ******************
    // Approach 2: Use Map for memoization + recursion
    // Base case if total=target => 1, otherwise 0
    // If map containKeys => return value of keys
    // Otherwise, recursive with the combination(+) of total+nums[i] & total-nums[i]
    // Return map.get(key), key = index + "_" + total to prevent redundant calculations
    // Runtime  : 102ms       -> + 47.06%
    // Memory   : 45.88MB     -> + 6.04%
    Map<String,Integer> map;
    int[] nums;
    int target;
    public int findTargetSumWays2(int[] nums, int target) {
        map = new HashMap<>(); // (index_total) -> # of ways
        this.nums = nums;
        this.target = target;

        return backtrack(0, 0);
    }

    private int backtrack(int index, int total) {
        if(index == nums.length) {
            return (total == target) ? 1 : 0;
        }

        String tmp = index + "_" + total;
        if(map.containsKey(tmp))
            return map.get(tmp);


        map.put(tmp,(backtrack(index + 1, total+nums[index]) +
                backtrack(index+1, total-nums[index])));

        return map.get(tmp);
    }
    //  ***************** End of 2nd Method ******************
}
