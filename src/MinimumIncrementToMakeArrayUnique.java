import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        int[] nums = {3,2,1,2,1,7};

        System.out.println(minIncrementForUnique3(nums));
    }

    // ***************** 1st Method ******************
    // Approach : Sort the array, if nums[i] <= nums[i-1], increment nums[i] and moves++
    // Runtime  : 988ms        -> + 5.24%
    // Memory   : 60.15 MB    -> + 44.92%
    public static int minIncrementForUnique(int[] nums) {
        int moves = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length;) {
            int prev = i-1;
            if(nums[i] <= nums[prev]) {
                nums[i]++;
                moves++;
            } else {
                i++;
            }
        }
        return moves;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Optimized the 1st approach
    // Runtime  : 552ms        -> + 7.54%
    // Memory   : 59.98 MB    -> + 64.26%
    public static int minIncrementForUnique2(int[] nums) {
        int moves = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            int prev = i-1;
            while(nums[i] <= nums[prev]) {
                nums[i]++;
                moves++;
            }
        }
        return moves;
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach : Optimized the 1st & 2nd approach
    // Runtime  : 38ms        -> + 43.61%
    // Memory   : 59.99 MB    -> + 64.26%
    public static int minIncrementForUnique3(int[] nums) {
        int moves = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            int prev = i-1;
            if(nums[i] <= nums[prev]) {
                moves += Math.abs(nums[i] - nums[prev]) + 1;
                nums[i] = nums[prev] + 1;
            }
        }
        return moves;
    }
    // ***************** End of 2nd Method ******************

}
