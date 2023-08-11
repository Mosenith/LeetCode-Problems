package MostAsked100Q;

public class PowerOfThree {
    public static void main(String[] args) {
        int n = 27;

        System.out.println(isPowerOfThree(1));
    }

    // ***************** 1st Method ******************
    // Approach : Use build-in Math.pow(3,i) = cur
    // increase i at every iteration, if cur = n => true
    // Make cur a long data type to prevent overflow if n is not the pow of 3
    // Runtime  : 12 ms        -> + 86.53%
    // Memory   : 43.09 MB      -> + 42.93%
    public static boolean isPowerOfThree(int n) {
        int index = 0;
        long cur = (long) Math.pow(3,index);
        while(cur <= n) {
            if(n == cur)
                return true;
            cur = (long) Math.pow(3,++index);
        }
        return false;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : 1162261467 = 3^19 is the max value pow of 3 can hold in 32bits
    // just check if n>0 && 3^19 % n == 0 => true
    // Runtime  : 7ms           -> + 100%
    // Memory   : 42.97 MB      -> + 55.92%
    public static boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
    // ***************** End of 2nd Method ******************
}
