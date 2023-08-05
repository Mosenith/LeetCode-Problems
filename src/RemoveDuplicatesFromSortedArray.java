import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    //    ***************** 1st Method ******************
    // Runtime  : 1ms        -> + 100%
    // Memory   : 44.1MB      -> + 71.30%
    public static int removeDuplicates(int[] nums) {
        int index = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index] = nums[i + 1];
                index++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return index;
    }
    //  ***************** End of 1st Method ******************

    //    ***************** 2nd Method ******************
    // Runtime  : 1ms        -> + 100%
    // Memory   : 44.4MB      -> + 60.96%
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 1 || num != nums[i - 1]) {
                nums[i++] = num;
            }
        }
        return i;
    }

    //  ***************** End of 1st Method ******************
    public static void main(String[] args) {
        // output = 2; nums1 = {1,2,_};
        int[] nums1 = {1,1,2};

        // output = 5; nums1 = {0,1,2,3,4,_,_,_,_,_};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};

        int[] nums3 = {1, 1, 1, 1, 2};

//        System.out.println(nums2.length);
        System.out.println(removeDuplicates2(nums2));
    }
}
