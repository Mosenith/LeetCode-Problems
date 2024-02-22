public class BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd2(5,7));
    }

    // 4 - 0100
    // 5 - 1001
    // 6 - 1100
    // 7 - 1101
    // 8 - 1000
    // ***************** 1st Method ******************
    // Approach 1: let ans = left & right, continue ans &= (left+1) & (right-1)
    // After loop, check if i=j -> ans &= i, then return ans
    // Passed all tests but Time Limit Exceeded
    public static int rangeBitwiseAnd(int left, int right) {
        int ans = left & right;
        int i=left+1,j=right-1;

        // i>0 to avoid overflow
        for(; i<j && i>0; i++,j--) {
            if(ans == 0) {
                return 0;
            }
            ans = ans & (i & j);
        }
        if(i == j) {
            ans &= i;
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: start from right and & with (right-1) until right <= left
    // Runtime  : 3ms        -> + 100.00%
    // Memory   : 77.20MB    -> + 42.75%
    public static int rangeBitwiseAnd2(int left, int right) {
        while (left < right) {
            System.out.println(left + " : " + right);
            right &= (right - 1);
        }
        return right;
    }
    //  ***************** End of 2nd Method ******************
}
