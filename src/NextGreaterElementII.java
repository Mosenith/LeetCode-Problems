import java.util.*;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};

        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    // ***************** 1st Method ******************
    // Approach 1:Loop from i+1 to nums.len, if encounter greater one, add to ans[i]
    // Otherwise, means next greater is not on the right, look from the left to i-1
    // If left=i, means it's the max element so ans[i]=-1
    // Runtime  : 31ms          -> + 10.98%
    // Memory   : 45.84MB       -> + 79.29%
    public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        int len = nums.length;

        for(int i=0; i<len; i++) {
            int right = i+1;
            while(right<len) {
                if(nums[right] > nums[i]) {
                    ans[i] = nums[right];
                    break;
                }
                right++;
            }
            if(right == len) {
                int left = 0;
                while(left<i) {
                    if(nums[left] > nums[i]) {
                        ans[i] = nums[left];
                        break;
                    }
                }
                if(left == i) {
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

}
