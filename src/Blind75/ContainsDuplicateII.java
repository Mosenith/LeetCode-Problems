package Blind75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {99,99};
        int k = 2;

        System.out.println(containsNearbyDuplicate(nums,k));
    }
    // ***************** 1st Method ******************
    // Approach 1: Nested loop & inner loop from i+1 to i+k
    // Within inner loop, check if n[i] == n[j] => true
    // Otherwise, finally return false
    // Runtime  : 1249ms        -> + 5.02%
    // Memory   : 54.68MB       -> + 91.78%
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<=i+k && j<nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    // ***************** End of 1st Method ******************

}
