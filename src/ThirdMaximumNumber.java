import java.util.*;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {1,1,2};

        System.out.println(thirdMax2(nums));
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

    // ***************** 1st Method ******************
    // Approach 1: Assign 3 long val to Long.MIN_VALUE
    // Loop through each element in nums[] and skip elements =m1 or =m2 or =m3
    // If element > m1, update m3-> m2, m2-> m1, m1->num
    // Else if element > m2, update m3-> m2, m2->num
    // Else if element > m3, update m3-> num
    // Return m3 but if m3=Long.MIN_VALUE, return m1
    // Runtime  : 1ms         -> + 93.00%
    // Memory   : 42.81MB     -> + 86.02%
    public static int thirdMax2(int[] nums) {
        long m1 = Long.MIN_VALUE;
        long m2 = Long.MIN_VALUE;
        long m3 = Long.MIN_VALUE;
        for (int num : nums) {
            // skip the duplicate elements
            if (num == m1 || num == m2 || num == m3) {
                continue;
            }
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (num > m2) {
                m3 = m2;
                m2 = num;
            } else if (num > m3) {
                m3 = num;
            }
        }
        return (int) (m3 != Long.MIN_VALUE ? m3 : m1);
    }
    //  ***************** End of 2nd Method ******************
}
