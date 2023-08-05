import java.util.ArrayList;
import java.util.List;

public class JumpGame {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    // ***************** 1st Method ******************
    // Runtime  : 2ms        -> + 79.97%
    // Memory   : 44.6MB      -> + 18.34%
    public static boolean canJump(int[] nums) {
        int mx = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (mx < i) {
                return false;
            }
            System.out.println("i = " + i);
            System.out.println(mx + " : " + (i + nums[i]));
            mx = Math.max(mx, i + nums[i]);
            System.out.println("***************");
        }
        return true;
    }
}