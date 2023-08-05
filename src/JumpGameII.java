import java.util.ArrayList;
import java.util.List;

public class JumpGameII {
    // ***************** 1st Method ******************
    // Runtime  : 1ms        -> + 99.52%%
    // Memory   : 43MB      -> + 23.43%
    public static int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            System.out.println("curFarthest = " + curFarthest + ", nums[i] = " + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
    //  ***************** End of 1st Method ******************



    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};   // out = 2
        int[] nums = {2,3,0,1,4};

        System.out.println(jump(nums));
    }
}
