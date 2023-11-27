package Blind75.Binary;

import java.util.Arrays;

public class PracticeProb268 {
    public static void main(String[] args) {
        int[] nums = {0,1};

        System.out.println(missingNumber2(nums));
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        if(nums[0] != 0) return 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }

        return nums[nums.length-1] + 1;
    }

    // 0,1,2,3,4 = 5*4/2
    public static int missingNumber2(int[] nums) {
        int sum = (nums.length) * (nums.length-1) / 2;
        int max = 0;
        boolean hasZero = false;

        for(int n : nums) {
            if(n == 0)
                hasZero = true;
            if(n > max)
                max = n;
            sum -= n;
        }

        if(!hasZero) return 0;

        return (sum == 0) ? max + 1 : max + sum;
    }
}
