import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static void main(String[] args) {
        int[] nums = {82,81,95,75,20};

        System.out.println(minDifference(nums));
    }

    // ***************** 1st Method ******************
    // Approach : Sort array and init minDiff to Integer.MAX_VALUE
    // Then, find the minimum by leaving out the 3 smallest
    // Then, find the minimum by leaving out the 3 largest
    // Then, find the minimum by leaving out the 2 smallest and 1 largest
    // Then, find the minimum by leaving out the 1 smallest and 2 largest
    // Runtime  : 15ms        -> + 96.33%
    // Memory   : 58.04MB     -> + 5.13%
    public static int minDifference(int[] nums) {
        if(nums.length <= 4) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int minDiff = Integer.MAX_VALUE;

        minDiff = Math.min(minDiff,nums[len-1]-nums[3]);
        minDiff = Math.min(minDiff,nums[len-4]-nums[0]);
        minDiff = Math.min(minDiff,nums[len-2]-nums[2]);
        minDiff = Math.min(minDiff,nums[len-3]-nums[1]);

        return minDiff;
    }
    // ***************** End of 1st Method ******************
}
