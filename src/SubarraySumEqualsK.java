import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1};
        int k = 3;

        System.out.println(subarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            int curKey = k - nums[i];
            if(!map.containsKey(nums[i])) {
                map.put(curKey,i);
                count++;
            } else {
                break;
            }

            System.out.println(map);
        }

        return count+1;
    }
}
