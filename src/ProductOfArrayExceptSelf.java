import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {-1,1,0,-3,3};

        System.out.println(Arrays.toString(productExceptSelf(nums1)));
    }

    // ***************** 3rd Method ******************
    // Approach 1: There are 3 special case
    // 1: No zero, calculate the total product in 1st loop, then 2nd, total/nums[i] -> ans[i]
    // 2: 1 zero, keep zeroIndex & cal total product without zero, ans all zero except at zeroIndex=total
    // 3: Zero >= 2 => ans all zero
    // Runtime  : 1ms            -> + 100%
    // Memory   : 51.46MB        -> + 85.96%
    public static int[] productExceptSelf(int[] nums) {
        List<Integer> zeroIndex = new ArrayList<>();
        int totalProduct = 1;
        int[] answer = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                zeroIndex.add(i);
            } else {
                totalProduct *= nums[i];
            }
        }

        if(zeroIndex.size() >= 2) {
            Arrays.fill(answer,0);
        } else if(zeroIndex.size() == 1) {
            // all zero except ZeroIndex
            Arrays.fill(answer,0);
            answer[zeroIndex.get(0)] = totalProduct;
        } else {
            for(int i=0; i<answer.length; i++) {
                answer[i] = totalProduct / nums[i];
            }
        }

        return answer;
    }
    //  ***************** End of 1st Method ******************

}
