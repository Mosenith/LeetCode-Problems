import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        // out: 5,6,7,1,2,3,4
        int[] nums = {1,2};
        int k = 3;

        rotate(nums, k);
    }

    // ***************** 1st Method ******************
    // Approach 1: Keep track of index to remove to the front
    // Runtime  : 1ms          -> + 51.16%
    // Memory   : 55.32MB      -> + 70.73%
    public static void rotate(int[] nums, int k) {
        if(nums.length <= 1) return;
        int start = nums.length -1;
        int[] tmpArr = new int[nums.length];
        while(k > 0) {
            start--;
            k--;
            if(start < 0 ) start = nums.length-1;
        }

        int index = 0;
        for(int i=start+1; i<tmpArr.length; i++) {
            tmpArr[index++] = nums[i];
        }

        for(int i=0; i<=start; i++) {
            tmpArr[index++] = nums[i];
        }

        for(int i=0; i<nums.length; i++) {
            nums[i] = tmpArr[i];
        }
    }
    // ***************** End of 1st Method ******************

}






