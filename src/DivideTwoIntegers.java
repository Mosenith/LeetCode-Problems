public class DivideTwoIntegers {
    //    ***************** 1st Method ******************
    /*
        1st outer loop
        --------------

        1st inner loop --- tmp = 6 , count = 2
        2nd inner loop --- tmp = 12, count = 4 (exit the inner loop, result = 0 + (4 >> 1) = 2)

        dividend = 10 - (12 >> 1) = 10 - 6 = 4 (4 >  divisor, so here we go second outer loop)

        2nd outer loop
        --------------
        1st inner loop --- tmp = 6, count = 2 (exit the inner loop, result = 2 + (2 >> 1) = 3)

        dividend = 4 - (6 >> 1) = 4 - 3 = 1( divisor > 1, exit outer loop, return result)
        */
    // explanation
    // https://leetcode.com/problems/divide-two-integers/solutions/13467/very-detailed-step-by-step-explanation-java-solution/?orderBy=most_votes
    // Runtime  : 1ms        -> + 100%
    // Memory   : 39.3MB      -> + 94.97%
    public static int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;
        while(absDividend >= absDivisor){
            long tmp = absDivisor, count = 1;
            while(tmp <= absDividend){
                tmp <<= 1;
                count <<= 1;
            }
            result += count >> 1;
            absDividend -= tmp >> 1;
        }
        return  isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
    //  ***************** End of 1st Method ******************

    //    ***************** 2nd Method ******************
    // explanation
    // https://leetcode.com/problems/divide-two-integers/solutions/1516367/complete-thinking-process-intuitive-explanation-all-rules-followed-c-code/?orderBy=most_votes
    // Runtime  : 1ms        -> + 100%
    // Memory   : 39.5MB      -> + 88.73%
    public static int divide2(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0) != (divisor < 0)) {
            sign = -1;
        }
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);
        long tot = 0;
        System.out.println("x = " + x + ", y = " + y);
        while (x >= y) {
            int cnt = 0;
            while (x >= (y << (cnt + 1))) {
                System.out.print("cnt+1 : " + (cnt+1) + ", Shift : ");
                System.out.println(y << (cnt + 1));
                cnt++;
            }
//            System.out.println(cnt);
            tot += 1L << cnt;
//            System.out.println("1L = " + 1L + ", cnt = " + cnt);
            x -= y << cnt;
            System.out.println("x = " + x);
        }
        long ans = sign * tot;
        if (ans >= Integer.MIN_VALUE && ans <= Integer.MAX_VALUE) {
            return (int) ans;
        }
        return Integer.MAX_VALUE;
    }
    //  ***************** End of 2nd Method ******************

    public static void main(String[] args) {
//        int dividend = 10, divisor = 3;     // output : 3
        int dividend = -7, divisor = -2;     // output : -2
//        int dividend = -2147483648, divisor = 1;     // output : -2
//        int dividend = -1, divisor = 1;

        System.out.println(divide2(dividend,divisor));
    }
}
