import java.util.Arrays;

public class PredictTheWinner {
    public static void main(String[] args) {
        int[] nums = {1,5,2};

        System.out.println(predictTheWinner(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use DP & Memoization
    // Recursive function considers two choices for player 1 at each step: choosing the leftmost or rightmost element
    // Opponent's Score: These choices are evaluated based on the opponent's potential score in the remaining subarray after that choice.
    // dp() essentially simulates both possibilities and picks the choice that guarantees the highest score for player 1.
    // By iterating through all subarrays, the overall predictTheWinner function determines
    // if player 1 can always choose a path that leads to a non-negative score at the end (meaning they "win" or at least tie).
    // Runtime  : 2ms         -> + 88.35%
    // Memory   : 45.42MB     -> + 35.79%
    public static boolean predictTheWinner(int[] nums) {
        // For memoization
        int[][] cache = new int[nums.length][nums.length];

        return dp(nums, cache,0,nums.length-1) >= 0;
    }

    private static int dp(int[] nums, int[][] cache, int left, int right) {
        if(left > right) {
            return 0;
        }

        // if it had been calculated before
        if(cache[left][right] != 0) {
            return cache[left][right];
        }

        // Choose the leftmost element --> nums[left] - dp(nums, cache, left+1, right)
        // Choose the rightmost element --> nums[right] - dp(nums, cache, left, right-1)
        return cache[left][right] = Math.max(nums[left] - dp(nums,cache,left+1,right),
                nums[right] - dp(nums,cache,left,right-1));
    }
    //  ***************** End of 1st Method ******************
}