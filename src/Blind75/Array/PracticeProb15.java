package Blind75.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeProb15 {
    public static void main(String[] args) {
        int[] nums = {-0,1,1};

        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j=i+1;
            int k=nums.length-1;
            while(k > j) {
                int curSum = nums[i] + nums[j] + nums[k];
                if(curSum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    // get rid of dups
                    while(j<nums.length && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while(k>=0 && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else if(curSum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }


        return ans;
    }
}
