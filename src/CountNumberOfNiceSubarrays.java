import java.util.ArrayList;
import java.util.List;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;

        System.out.println(numberOfSubarrays(nums,k));
    }

    // ***************** 1st Method ******************
    // Approach 1: Find all odd positions in nums and store in oddPos
    // If oddPos.size() == nums.length, return nums.length
    // Loop from 0 to oddPos.size()-k, find left and right from oddPos at i-th and i+k-1-th
    // Find leftCount and rightCount while checking if i == 0 or i+k == oddPos.size()
    // If i==0, leftCount = left + 1. Else, leftCount = left - oddPos.get(i-1)
    // If i+k == oddPos.size(), rightCount = nums.length - right. Else, rightCount = oddPos.get(i+k) - right
    // count += leftCount * rightCount
    // Runtime  : 10ms      -> + 80.88%
    // Memory   : 54.16MB   -> + 93.63%
    public static int numberOfSubarrays(int[] nums, int k) {
        List<Integer> oddPos = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 2 == 1) {
                oddPos.add(i);
            }
        }
        if(oddPos.size() == nums.length) return nums.length;
        int count = 0;
        for(int i=0; i+k<=oddPos.size(); i++) {
            int left = oddPos.get(i);
            int right = oddPos.get(i+k-1);

            int leftCount;
            int rightCount;
            if(i == 0) {
                leftCount = left + 1;
            } else {
                leftCount = left - oddPos.get(i-1);
            }
            if(i+k == oddPos.size()) {
                rightCount = nums.length - right;
            } else {
                rightCount = oddPos.get(i+k) - right;
            }
            count += leftCount * rightCount;
        }
        return count;
    }
    //  ***************** End of 1st Method ******************
}
