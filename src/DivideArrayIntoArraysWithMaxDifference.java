import java.util.Arrays;

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

    // ***************** 2nd Method ******************
    // Approach 2: Optimized version of 1st method
    // Sort given array and init int[][] ans = new int[n / 3][]
    // Loop from i=0 and copy array from i to i+3 -> t[]
    // Check if t[2]-t[0] > k, return new int[][] {}
    // Otherwise, have ans[i / 3] = t;
    // Runtime  : 21ms        -> + 97.20%
    // Memory   : 59.42MB     -> + 10.03%
    public int[][] divideArray2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n / 3][];
        for (int i = 0; i < n; i += 3) {
            int[] t = Arrays.copyOfRange(nums, i, i + 3);
            if (t[2] - t[0] > k) {
                return new int[][] {};
            }
            ans[i / 3] = t;
        }
        return ans;
    }
    //  ***************** End of 2nd Method ******************
}
