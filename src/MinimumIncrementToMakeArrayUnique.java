import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        int[] nums = {1,2,2};

        System.out.println(minIncrementForUnique(nums));
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
}
