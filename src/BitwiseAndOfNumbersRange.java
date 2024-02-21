public class BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(1073741824,2147483647));
    }

    // ***************** 1st Method ******************
    // Approach 1: Work but Time Limit Exceeded
    public static int rangeBitwiseAnd(int left, int right) {
        int ans = left;
        for(int i=left+1; i<=right; i++) {
            ans = ans & i;
            if(ans == 0) {
                return 0;
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

}
