import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        System.out.println(majorityElement(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use map to store num and its occurrence
    // If at one point, map.get(n) > nums.len/2, return n
    // Runtime  : 16ms           -> + 15.59%
    // Memory   : 49.10MB        -> + 70.64%
    public static int majorityElement(int[] nums) {
        int major = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
            if(map.get(n) > major) {
                return n;
            }
        }
        return 0;
    }
    //  ***************** End of 1st Method ******************

}
