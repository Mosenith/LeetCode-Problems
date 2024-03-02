import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};

        System.out.println(sortedSquares(nums));
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

}
