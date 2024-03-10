import java.util.*;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};

        System.out.println(Arrays.toString(nextGreaterElements2(nums)));
    }

    // ***************** 1st Method ******************
    // Approach 1:Loop from i+1 to nums.len, if encounter greater one, add to ans[i]
    // Otherwise, means next greater is not on the right, look from the left to i-1
    // If left=i, means it's the max element so ans[i]=-1
    // Runtime  : 31ms          -> + 10.98%
    // Memory   : 45.84MB       -> + 79.29%
    public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        int len = nums.length;

        for(int i=0; i<len; i++) {
            int right = i+1;
            while(right<len) {
                if(nums[right] > nums[i]) {
                    ans[i] = nums[right];
                    break;
                }
                right++;
            }
            if(right == len) {
                int left = 0;
                while(left<i) {
                    if(nums[left] > nums[i]) {
                        ans[i] = nums[left];
                        break;
                    }
                }
                if(left == i) {
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use queue(Deque) to store elements when nums[q.lastEle] >= nums[j]
    // Loop from i=0 to len*2, let j = i%n, if nums[q.lastEle] < nums[j], ans[q.polllast] = nums[j]
    // Runtime  : 6ms           -> + 83.86%
    // Memory   : 42.94MB       -> + 73.30%
    public static int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n * 2; i++) {
            int j = i % n;
            while (!q.isEmpty() && nums[q.getLast()] < nums[j]) {
                ans[q.pollLast()] = nums[j];
            }
            q.addLast(j);
        }
        return ans;
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Similar to 2nd approach but use stack
    // Runtime  : 10ms          -> + 83.62%
    // Memory   : 46.58MB       -> + 13.04%
    public static int[] nextGreaterElements3(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[nums.length];
        Arrays.fill(ret, -1);
        for(int i = 0; i < 2 * nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]){
                ret[stack.pop()] = nums[i % nums.length];
            }
            if(i < nums.length) stack.push(i);
        }
        return ret;
    }
    //  ***************** End of 3rd Method ******************

}
