import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

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
    public static int[] rearrangeArray2(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0;
        Queue<Integer> positive = new ArrayDeque<>();
        Queue<Integer> negative = new ArrayDeque<>();

        for(int n : nums) {
            if(index%2==0 && n<0) {
                negative.add(n);
                continue;
            } else if(index%2!=0 && n>0) {
                positive.add(n);
                continue;
            }

            if(n>0 && positive.isEmpty()) {
                ans[index] = n;
            } else if(n>0 && !positive.isEmpty()){
                positive.add(n);
                ans[index] = positive.poll();
            } else if(n<0 && negative.isEmpty()) {
                ans[index] = n;
            } else {
                negative.add(n);
                ans[index] = negative.poll();
            }
            index++;
        }

        while(index < ans.length) {
            if(index % 2 == 0) {
                ans[index++] = positive.poll();
            } else {
                ans[index++] = negative.poll();
            }
        }

        return ans;
    }
}
