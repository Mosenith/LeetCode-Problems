public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 1;

        System.out.println(isPowerOfTwo4(32));
    }

    // ***************** 1st Method ******************
    // Approach 1: Calculate 2 to the power of 2, starting from power = 0
    // If at some point 2^power = n => true
    // If bigger than n, exit loop & return false
    // Runtime  : 1ms         -> + 82.09%
    // Memory   : 41.36MB     -> + 5.92%
    public static boolean isPowerOfTwo(int n) {
        if(n != 1 && n % 2 != 0) {
            return false;
        }
        int power = 0;

        while(Math.pow(2,power) <= n) {
            if(Math.pow(2,power) == n) {
                return true;
            }
            power++;
        }

        return false;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Calculate remain & reduce n /= 2 at every iteration
    // Loop while remain == 0 && n > 1, return remain == 0
    // Runtime  : 1ms         -> + 82.09%
    // Memory   : 40.75MB     -> + 13.76%
    public static boolean isPowerOfTwo2(int n) {
        if(n < 1) return false;

        int remain = 0;
        while(remain == 0 && n > 1) {
            remain = n % 2;
            n /= 2;
        }

        return remain == 0;
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Use bit manipulation
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.85MB     -> + 10.54%
    public static boolean isPowerOfTwo3(int n) {
        return n > 0 && (1 << 30) % n == 0;
    }
    // ***************** End of 3rd Method ******************

    // ***************** 4th Method ******************
    // Approach 4: Use recursion of the same method
    // Runtime  : 1ms         -> + 49.23%
    // Memory   : 40.78MB     -> + 56.93%
    public static boolean isPowerOfTwo4(int n) {
        if(n == 1) return true;
        return n > 0 && n % 2 == 0 && isPowerOfTwo(n/2);
    }
    // ***************** End of 4th Method ******************
}
