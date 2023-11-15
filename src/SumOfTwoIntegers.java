public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(2,3));
    }

    // ***************** 1st Method ******************
    // Approach 1: Bit manipulation use &, ^, << 1
    // Store c <= a & b, then renew a = a ^ b
    // Renew b = c << 1
    // Loop this till b == 0, return a
    // Runtime  : 0ms          -> + 100%
    // Memory   : 38.80MB      -> + 87.85%
    public static int getSum(int a, int b) {
        int c;
        while(b != 0) {
            c = (a&b);
            a = a ^ b;
            b = (c)<<1;
        }
        return a;
    }
    // a:2 = 0010, b:3 = 0011
    // a & b = 0010:c = 2
    // a ^ b = 0001:a = 1
    // c << 1= 0100:b = 4

    // a=1-0001, b=4-0100, c=2-0010
    // a & b = 0000:c = 0
    // a ^ b = 0101:a = 5
    // c << 1 = 0000:b = 0
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2:
    // Runtime  : 0ms          -> + 100%
    // Memory   : 39.26MB      -> + 31.49%
    public static int getSum2(int a, int b) {
        return Math.addExact(a,b);
    }
}



