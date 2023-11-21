package Blind75;

import java.util.HashSet;
import java.util.Set;

// 217. Contains Duplicate
public class PracticeProb217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            // can also use this => if(!set.add(n))
            if(set.contains(n))
                return true;
            set.add(n);
        }

        return false;
    }
}
