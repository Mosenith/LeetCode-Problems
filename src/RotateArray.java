import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        // out: 5,6,7,1,2,3,4
        int[] nums = {1,2};
        int k = 3;

        rotate2(nums, k);
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

    public static void rotate2(int[] nums, int k) {
        int left = 0, right = nums.length-1;

        while(k > 0) {
            right--;
            k--;
            if(right < left) right = nums.length-1;
        }

        System.out.println(left + " : " + right);
        right++;
        // right+1 then swap with left
        while(right < nums.length) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            right++;
            left++;
        }

        System.out.println(Arrays.toString(nums));
    }
    // 1,2,3,4,5,6,7 - 1-5

    public static void rotate3(int[] nums, int k) {
        if (nums == null || nums.length==0 || k < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }
        if(k > nums.length){
            k = k % nums.length;
        }

        //length of first part
        int a = nums.length - k;
        reverse(nums, 0, a-1);
        reverse(nums, a, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    public static void reverse(int[] arr, int left, int right) {
        if(arr == null || arr.length == 1)
            return;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

    }
}






