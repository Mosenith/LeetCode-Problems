import java.util.Arrays;

public class RemoveArrayElement {
    //    ***************** 1st Method ******************
    // Runtime  : 1ms        -> + 100%
    // Memory   : 40.8MB      -> + 84.38%%
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for(int n : nums) {
            if(n != val)
                nums[i++] = n;
        }
        return i;
    }
    //  ***************** End of 1st Method ******************

    public static void main(String[] args) {
        // output = 2, nums = [2,2,_,_]
        int[] nums1 = {3,2,2,3};
        int val1 = 3;

        // output = 5, nums = [0,1,4,0,3,_,_,_]
        int[] nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 2;

        System.out.println(removeElement(nums2,val2));
    }
}
