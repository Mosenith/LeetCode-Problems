import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};

        System.out.println(sortedSquares2(nums));
    }
    // ***************** 1st Method ******************
    // Approach 1: Calculate the square of each element, then sort the array
    // Runtime  : 7ms           -> + 45.67%
    // Memory   : 46.20MB       -> + 91.47%
    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }

        Arrays.sort(ans);
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Compare i=0 with j=nums.len-1 and add the bigger sqr to ans[nums.len-1]
    // If nums[i] * nums[i] > nums[j] * nums[j], ++i. Otherwise, --j
    // Runtime  : 7ms           -> + 45.67%
    // Memory   : 46.20MB       -> + 91.47%
    public static int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0, j = n - 1, k = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[k--] = nums[i] * nums[i];
                ++i;
            } else {
                res[k--] = nums[j] * nums[j];
                --j;
            }
        }
        return res;
    }
    //  ***************** End of 2nd Method ******************
}
