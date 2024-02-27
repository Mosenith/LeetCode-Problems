import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};

        System.out.println(Arrays.toString(rearrangeArray2(nums)));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use 2 queues to store positive and negative num separately
    // Add elements from both queues to array with i%2=0-> positive queues
    // Otherwise, negative queues
    // Runtime  : 16ms           -> + 5.32%
    // Memory   : 82.18MB        -> + 14.30%
    public static int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        Queue<Integer> positive = new ArrayDeque<>();
        Queue<Integer> negative = new ArrayDeque<>();

        for(int n : nums) {
            if(n > 0) {
                positive.add(n);
            } else {
                negative.add(n);
            }
        }

        for(int i=0; i<ans.length; i++) {
            if(i % 2 == 0) {
                ans[i] = positive.poll();
            } else {
                ans[i] = negative.poll();
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use 2 indices, i for >0, j for <0
    // Loop through nums[], if >0, have ans[i] = n, then i+=2
    // Similarly for <0
    // Runtime  : 3ms        -> + 100.00%
    // Memory   : 77.20MB    -> + 42.75%
    public static int[] rearrangeArray2(int[] nums) {
        int[] ans = new int[nums.length];
        int i=0, j=1;   // i for positive, j for negative

        for(int n : nums) {
            if(n > 0) {
                ans[i] = n;
                i += 2;
            } else {
                ans[j] = n;
                j += 2;
            }
        }

        return ans;
    }
    //  ***************** End of 2nd Method ******************

}
