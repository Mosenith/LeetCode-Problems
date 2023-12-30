import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
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

    // ***************** 2nd Method ******************
    // Approach 2: Use map to store nums[i] as key, values don't matter
    // Since key is unique, if curElement exists in map, we can call map.getOrDefault()
    // Use i - map.getOrDefault(curElement, -1111) <= k => true (value doesn't matter)
    // Runtime  : 47ms        -> + 10.29%
    // Memory   : 60.04MB     -> + 5.67%
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if (i - map.getOrDefault(nums[i], -1000000) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    // ***************** End of 2nd Method ******************

}
