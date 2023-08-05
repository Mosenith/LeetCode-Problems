import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FirstMissingPositive {
    // ***************** 1st Method ******************
    // Runtime  : 11ms        -> + 16.15%
    // Memory   : 58.1MB      -> + 7.57%
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int prev = -1;
        int count = 0; // count <= elements

        for(int i=0; i<len; i++) {
            if(nums[i] <= 0){
                count++;
                continue;
            }

            if(nums[count] != 1)
                return 1;

            prev = nums[i];
            if(i<len-1 && nums[i+1]-prev > 1)
                return prev + 1;

        }

        return (prev == -1) ? 1 : nums[len-1] + 1;
    }

    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 10ms        -> + 24.50%
    // Memory   : 57.7MB      -> + 10.95%
    public static int firstMissingPositive2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums) {
            if(n > 0)
                list.add(n);

        }

        Collections.sort(list);
        if(list.isEmpty() || list.get(0) != 1)
            return 1;

        for(int i=1; i<list.size(); i++) {
            if(list.get(i) - list.get(i-1) > 1)
                return list.get(i-1) + 1;
        }

        return list.get(list.size() - 1) + 1;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Runtime  : 1ms        -> + 100%
    // Memory   : 57.7MB      -> + 10.95%
    public static int firstMissingPositive3(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                System.out.println("Before Swap: " + Arrays.toString(nums));
                swap(nums,i,nums[i] - 1);
                System.out.println("After Swap: " + Arrays.toString(nums));
            } else {
                i++;
            }
            System.out.println("************************************");
        }
        for(i = 0;i<nums.length;i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //  ***************** End of 3rd Method ******************

    // ***************** 4th Method ******************
    // Runtime  : 8ms        -> + 27.50%
    // Memory   : 57.6MB      -> + 10.95%
    public static int firstMissingPositive4(int[] nums) {
        Arrays.sort(nums);
        int track = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= 0 || i > 0 && nums[i] == nums[i-1])
                continue;

            if(nums[i] != track+1)
                return track + 1;

            track++;
        }

        return track + 1;
    }

    //  ***************** End of 4th Method ******************

    // ***************** 5th Method ******************
    // Runtime  : 8ms        -> + 27.50%
    // Memory   : 57.6MB      -> + 10.95%
    public static int firstMissingPositive5(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;

        int len = nums.length, containOne = 0;

        // step 1 :
        // if 1 exists, set containOne = 1
        // elements <= 0 & elements > len, are set to 1
        // since missing pos is between [1,len]
        for(int i=0; i<len; i++) {
            if(nums[i] == 1)
                containOne = 1;
            else if(nums[i] <= 0 || nums[i] > len) {
                nums[i] = 1;
            }
        }

        // if 1 doesn't exist, return 1 immediately
        // since 1 is the smallest missing positive number
        if(containOne == 0) return 1;

        // step 2 : TRICKY (Reduce space capacity)
        // turn each element(nums[i]) to index
        // swap the sign to negative
        for(int i=0; i<len; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        // step 3 :
        // loop through nums, get the index of the first non-negative in nums
        // return index + 1
        for(int i=0; i<len; i++) {
            if(nums[i] > 0)
                return i+1;
        }

        // if all elements in nums are negative, return the next smallest len + 1
        return len+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};   // out : 3
        int[] nums2 = {3,4,-1,1,2};   // out : 2  -> [-1, 1, 3, 4]
        int[] nums3 = {7,8,9,11,12};    // out : 1
        int[] nums4 = {1,1000};
        int[] nums5 = {0,2,2,1,1};

        System.out.println(firstMissingPositive4(nums));
        System.out.println(firstMissingPositive4(nums2));
        System.out.println(firstMissingPositive4(nums3));
        System.out.println(firstMissingPositive4(nums4));
        System.out.println(firstMissingPositive4(nums5));

//        System.out.println(firstMissingPositive2(nums));
//        System.out.println(firstMissingPositive2(nums2));
//        System.out.println(firstMissingPositive2(nums3));
//        System.out.println(firstMissingPositive2(nums4));
//        System.out.println(firstMissingPositive2(nums5));
    }
}
