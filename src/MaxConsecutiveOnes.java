public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};

        System.out.println("final => " + findMaxConsecutiveOnes(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use max & curMax with curMax++ every 1
    // When element = 0 => max = max(max,curMax) & set curMax=0
    // Return max(max,curMax)
    // Runtime  : 2ms         -> + 88.35%
    // Memory   : 45.42MB     -> + 35.79%
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, curMax = 0;

        for(int n : nums) {
            if(n == 0) {
                max = Math.max(max, curMax);
                curMax = 0;
            } else {
                curMax++;
            }
            System.out.println(max + " : " + curMax);
        }

        return Math.max(max, curMax);
    }
    //  ***************** End of 1st Method ******************

}
