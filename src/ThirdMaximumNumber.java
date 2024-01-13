import java.util.*;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,2,5,3,5};

        System.out.println(thirdMax(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Sort the array & get each element from len-1 to the list
    // Each iteration, skip elements that == previous added element
    // If ls.size<3, return the 0 index element of ls
    // Otherwise, return last element ls.get(ls.size()-1)
    // Runtime  : 4ms         -> + 57.87%
    // Memory   : 42.62MB     -> + 94.27%
    public static int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];

        Arrays.sort(nums);
        int index = nums.length-1;
        List<Integer> ls = new ArrayList<>();

        while (index >= 0 && ls.size() != 3) {
            if(ls.isEmpty() || ls.get(ls.size()-1) != nums[index]) {
                ls.add(nums[index]);
            }
            index--;
        }

        if(ls.size() < 3) {
            return ls.get(0);
        }
        return ls.get(ls.size()-1);
    }
    //  ***************** End of 1st Method ******************

}
