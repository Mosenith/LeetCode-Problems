import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // ***************** 1st Method ******************
    // Runtime  : 85ms        -> + 24.69%
    // Memory   : 42.9MB      -> + 29.27%
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for(int i=0, j=i+1; i<nums.length-1; j++) {
            System.out.println("i = " + i + ", j = " + j);
            if(nums[i] + nums[j] != target) {
                if(j == nums.length-1) {
                    i++;
                    j = i;
                }
            } else {
                result[0] = i;
                result[1] = j;
                break;
            }

        }

        return result;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 2ms        -> + 81.88%
    // Memory   : 42.5MB      -> + 62.73%
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;; i++) {
            int complement = target - nums[i];
            System.out.println(complement);
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
            System.out.println(map);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }
}
