package MostAsked100Q;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MoveZeroes {
    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12};

        // out: [4, 2, 4, 3, 5, 1, 0, 0, 0, 0]
//        int[] nums = {4,2,4,0,0,3,0,5,1,0};

        // out: [1, 1, 0]
        int[] nums = {1,0,1};

        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    // ***************** 1st Method ******************
    // Approach : Use 2 Pointers to loop through array
    // swap if arr[left] = 0 && arr[right] != 0 && if arr[left] != 0 => left++
    // at every iteration => right++
    // Runtime  : 3 ms        -> + 19.13%
    // Memory   : 44.86 MB    -> + 93.39%
    public static void moveZeroes(int[] nums) {
        int cur = 0, next = 1;

        while(next < nums.length && cur < next) {
            if(nums[cur] == 0 && nums[next] != 0) {
                // swap place
                int tmp = nums[cur];
                nums[cur] = nums[next];
                nums[next] = tmp;
                cur++;
            } else if(nums[cur] != 0) {
                cur++;
            }
            next++;
        }
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method : Best Method ******************
    // f
    // Runtime  : 1ms           -> + 100%
    // Memory   : 44.72 MB      -> + 96.50%
    public static void moveZeroes2(int[] nums) {
        int nonZeroIndex = 0;

        for(int n : nums) {
            if(n != 0)
                nums[nonZeroIndex++] = n;
        }

        while(nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
    }
    // ***************** End of 1st Method ******************
}
