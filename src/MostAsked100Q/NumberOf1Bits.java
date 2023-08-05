package MostAsked100Q;

public class NumberOf1Bits {
    public static void main(String[] args) {
        // 100 = 1100100
        int n = 100;

        // 1000 = 1111101000

        System.out.println(hammingWeight(1000));
    }

    // ***************** 1st Method : HashMap ******************
    // Approach 1: Input n & 1 -> will get the binary num of n from left to right
    // when we get all digits of binary n, n=0 cos we shift >>> by 1 at every loop
    // Runtime  : 0ms           -> + 100%
    // Memory   : 39.39 MB        -> + 82.36%
    // Time : O(1), Space: O(1)
    public static int hammingWeight(int n) {
        int res = 0;

        for(int i=0; i<32 && n!=0; i++) {
            if((n&1) == 1)
                res++;
            n >>>= 1;
        }

        return res;
    }
}
