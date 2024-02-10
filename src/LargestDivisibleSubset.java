import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,24};

        System.out.println(largestDivisibleSubset(nums));
    }

    // 2 - 4,6,24
    // 3 - 6,24
    // 4 - 24
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 1) return List.of(nums[0]);

        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            int cur = nums[i];
            tmp.add(nums[i]);
            for(int j=0; j<nums.length; j++) {
                if(j == i) continue;
                if(cur > nums[j] && cur % nums[j] == 0
                        || cur < nums[j] && nums[j] % cur == 0) {
                    cur *= nums[j];
                    tmp.add(nums[j]);
                }
            }

            System.out.println(ans);
            System.out.println(tmp);
            if(ans.size() < tmp.size()) {
                System.out.println("Change ans list");
                ans = new ArrayList<>();
                ans = tmp;
            }

            System.out.println("*******\n");
        }

        Collections.sort(ans);
        return ans;
    }
}
