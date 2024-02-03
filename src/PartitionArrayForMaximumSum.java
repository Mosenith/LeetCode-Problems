import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[]  arr = {1,4,1,5,7,3,6,1,9,9,3};
        int k = 4;

        System.out.println(maxSumAfterPartitioning2(arr,k));
    }

    // ***************** 1st Method ******************
    // Approach 1: DP before optimization & no memoization
    // Keep track of the len from curIndex to min(curIndex+k, arr.len) while also update maxElement
    // Find curMax by len * maxElement and + with recursive of same function with index+1
    // Update maxSum -> max(maxSum, curSum) & return maxSum
    // Exceed time limit
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        return dfs(arr,k,0);
    }
    private static int dfs(int[] arr, int k, int index) {
        if(index == arr.length) {
            return 0;
        }

        int len = 0;
        int maxElement = Integer.MIN_VALUE; // find max element in arr
        int maxSum = Integer.MIN_VALUE;

        // each partition size is max k
        for(int i=index; i<Math.min(index+k, arr.length); i++) {
            len++;
            maxElement = Math.max(maxElement, arr[i]);
            // find current max sum & find the next maxSum
            int curSum = (len * maxElement) + dfs(arr, k, i+1);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
    //  ***************** End of 1st Method ******************


    // ***************** 2nd Method ******************
    // Approach 2: DP with memoization using dp[arr.len]
    // If dp[index] != 0 return dp[index] without having to enter loop
    // Set dp[index] = maxSum after loop & return it
    // Runtime  : 6ms        -> + 93.17%
    // Memory   : 42.18MB    -> + 39.03%
    public static int maxSumAfterPartitioning2(int[] arr, int k) {
        int[] dp = new int[arr.length];
        return dfs2(arr,k,0,dp);
    }
    private static int dfs2(int[] arr, int k, int index, int[] dp) {
        if(index == arr.length) {
            return 0;
        }

        if(dp[index] != 0) {
            return dp[index];
        }

        int len = 0;
        int maxElement = Integer.MIN_VALUE; // find max element in arr
        int maxSum = Integer.MIN_VALUE;

        // each partition size is max k
        for(int i=index; i<Math.min(index+k, arr.length); i++) {
            len++;
            maxElement = Math.max(maxElement, arr[i]);
            // find current max sum & find the next maxSum
            int curSum = (len * maxElement) + dfs2(arr, k, i+1,dp);
            maxSum = Math.max(maxSum, curSum);
        }
        System.out.println("final dp => " + Arrays.toString(dp));
        return dp[index] = maxSum;
    }
    //  ***************** End of 2nd Method ******************

}


