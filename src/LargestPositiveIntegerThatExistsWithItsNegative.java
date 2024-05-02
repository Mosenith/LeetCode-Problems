import java.util.HashMap;
import java.util.Map;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {
        int[] nums = {-9,-43,24,-23,-16,-30,-38,-30};

        System.out.println(findMaxK(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use map. If n>0, check if map.contain(-n)
    // If n<0, check if map.contain(+n), init ans=-1 if either condition true
    // Update ans = max(ans,abs(n))
    // Runtime  : 6ms       -> + 64.14%
    // Memory   : 44.77MB   -> + 59.62%
    public static int findMaxK(int[] nums) {
        int ans = -1;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            int n = nums[i];
            if(n>0 && map.containsKey(n*(-1)) || n<0 && map.containsKey(n*(-1))) {
                ans = Math.max(ans,Math.abs(n));
            } else {
                map.put(n,i);
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************
}
