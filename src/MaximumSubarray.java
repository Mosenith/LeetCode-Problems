public class MaximumSubarray {
    // ***************** 1st Method ******************
    // Brutal Force
    // Worked but Takes too long
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int counter = 0;

        while(counter<nums.length) {
            for(int i=0; i<nums.length-counter; i++) {
                int step = 0;
                int tempSum = 0;

                for(int j=i; step<=counter; j++, step++) {
                    tempSum += nums[j];
                }
                maxSum = (maxSum >= tempSum) ? maxSum : tempSum;
            }
            counter++;
        }
        return maxSum;
    }

    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Using Kadane's Algorithm
    // Runtime  : 1ms        -> + 100%
    // Memory   : 51.7MB      -> + 52.81%
    public static int maxSubArray2(int[] nums) {
        int finalMaxSum = nums[0];
        int currentMaxSum = nums[0];

        System.out.println("Initial current & final max sum :");
        System.out.println(currentMaxSum + " : " + finalMaxSum);
        System.out.println("************************************");
        for(int i=1; i<nums.length; i++) {
            currentMaxSum = Math.max(nums[i], nums[i] + currentMaxSum);
            finalMaxSum = Math.max(currentMaxSum, finalMaxSum);
        }

        return finalMaxSum;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Using DP to optimize brutal force
    // Runtime  : 1ms        -> + 100%
    // Memory   : 52.1MB      -> + 19.56%
    public static int maxSubArray3(int[] nums) {
        int n = nums.length;
        //dp[i] means the maximum subarray ending with A[i];
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    //  ***************** End of 3rd Method ******************
    public static void main(String[] args) {
        // out : 6
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        // out : 23
//        int[] nums = {5,4,-1,7,8};

        // out : 1
//        int[] nums = {1};

        System.out.println(maxSubArray3(nums));
    }

}
