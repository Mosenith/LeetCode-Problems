import java.util.*;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9}; // ["0->2","4->5","7"]

        System.out.println(summaryRanges2(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Brute Force
    // Runtime  : 9ms         -> + 5.94%
    // Memory   : 41.68MB     -> + 14.36%
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int cur = nums[0], start = nums[0];

        for(int i=1; i<nums.length; i++) {
            int gap = nums[i] - cur;
            if(gap != 1) {
                if(nums[i-1] == start) {
                    res.add(Integer.toString(start));
                }else {
                    res.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }

            if(i == nums.length-1) {
                if(start == nums[i]) {
                    res.add(Integer.toString(start));
                } else {
                    res.add(start + "->" + nums[i]);
                }
            }

            cur = nums[i];
        }

        if(nums.length == 1 && start == cur) {
            res.add(Integer.toString(start));
        }

        return res;
    }
    // ***************** End of 1st Method ******************

    public static List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();

        if(nums.length == 0) return res;

       List<Integer> ls = new ArrayList<>();
       int curSum = nums[0];

       for(int i=1; i<nums.length; i++) {
           if(curSum == nums[i]) {
               ls.add(curSum);
               curSum = nums[i];
           } else if(curSum+1 != nums[i]) {
               ls.add(curSum);
               ls.add(nums[i]);
               curSum = nums[i];
           } else {
               curSum++;
           }
       }

        System.out.println(ls);

        return res;
    }
}
