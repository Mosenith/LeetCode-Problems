import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static void main(String[] args) {
        int[] nums = {0,0};

        System.out.println(specialArray(nums));
    }

    // ***************** 1st Method ******************
    // Approach : Start from i=0 to nums.len
    // Inner loop, keep count of element >=i, if by some points cnt>i, break
    // Out of inner loop if cnt=i, return cnt
    // Runtime  : 3ms        -> + 13.96%
    // Memory   : 40.93 MB   -> + 83.20%
    public static int specialArray(int[] nums) {
        int x = nums.length;

        for(int i=0; i<=x; i++) {
            int cnt = 0;
            for(int n : nums) {
                if(n >= i) {
                    cnt++;
                }
                if(cnt > i)
                    break;
            }

            if(cnt == i) {
                return cnt;
            }
        }
        return -1;
    }
    // ***************** End of 1st Method ******************

}
