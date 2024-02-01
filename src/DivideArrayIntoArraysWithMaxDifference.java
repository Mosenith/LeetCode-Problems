import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        // [[1,1,3],[3,4,5],[7,8,9]]
        int[] nums = {1,3,4,8,7,9,3,5,1};
        int k = 2;

        System.out.println(Arrays.deepToString(divideArray(nums,k)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Check if given array.len % 3 != 0 -> return new int[0][];
    // Return  int[][] ans = new int[nums.length/3][3], then sort given array
    // Add the first 3 element of sorted array to ans
    // While checking nums[i+2]-nums[i] > k, if so return new int[0][];
    // Runtime  : 23ms        -> + 93.20%
    // Memory   : 58.26MB     -> + 25.80%
    public static int[][] divideArray(int[] nums, int k) {
        if(nums.length%3 != 0) {
            return new int[0][];
        }

        int[][] ans = new int[nums.length/3][3];

        Arrays.sort(nums);
        int col = 0; // 0 - 3
        int i=0;
        while(i<=nums.length-3) {
            // initial state
            if(nums[i+2] - nums[i] > k) {
                return new int[0][];
            }

            ans[col][0] = nums[i];
            ans[col][1] = nums[i+1];
            ans[col][2] = nums[i+2];

            col++;
            i += 3;
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

}
