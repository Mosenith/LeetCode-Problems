package MostAsked100Q;

import java.util.HashSet;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3,0,1};

        System.out.println(missingNumber2(nums));
    }

    // ***************** 1st Method ******************
    // Approach : Keep track of min & max and calculate total sum
    // min must stand with 0, otherwise return 0
    // max is used to cal expected sum (esum)
    // if esum = sum => return max + 1
    // otherwise return sum - esum
    // Runtime  : 0 ms        -> + 100%
    // Memory   : 43.44 MB      -> + 99.19%
    public static int missingNumber(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
            } else if(nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }

        if(min != 0) return 0;

        int expectSum = (max * (max+1))/2;
        return (sum == expectSum) ? max + 1 : expectSum - sum;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method : HashMap ******************
    // Approach : ^(XOR) is used to find the missing num
    // index | nums[i] | i ^ nums[i]
    // ------- | -------- | --------
    // 0     | 1        | 1
    // 1     | 2        | 0
    // 2     | 3        | 1
    // Runtime  : 0 ms          -> + 100%
    // Memory   : 43.92 MB      -> + 85.15%
    public static int missingNumber2(int[] nums) {
        int n = nums.length;
        int ans = n;
        for (int i = 0; i < n; ++i) {
            System.out.println((i ^ nums[i]) + " : " + ans);
            ans ^= (i ^ nums[i]);
            System.out.println(ans);
            System.out.println("******************");
        }
        return ans;
    }
}
