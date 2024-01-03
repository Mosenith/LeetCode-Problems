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

    // ***************** 2nd Method ******************
    // Approach 2: Use 2 Pointers - i->outerLoop & j->innerLoop
    // Let j=i and loop j++ until n[j+1]!=n[j]+1 (j+1<n.len)
    // Then, out of innerLoop, if i==j => add n[i] to resList
    // Otherwise, "n[i]"->"n[j]" to resList
    // Runtime  : 2ms         -> + 90.49%
    // Memory   : 41.78MB     -> + 10.90%
    public static List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();

        for(int i=0,j; i<nums.length; i=j+1) {
            j = i;
            while(j+1 < nums.length && nums[j+1] == nums[j]+1) {
                j++;
            }
            res.add(summaryUtils(nums,i,j));
        }

        return res;
    }

    private static String summaryUtils(int[] nums, int i, int j) {
        return (i == j) ? nums[i] + "" : String.format("%d->%d", nums[i], nums[j]);
    }
    // ***************** End of 2nd Method ******************
}
