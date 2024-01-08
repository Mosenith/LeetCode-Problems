public class PowerOfFour {
    public static void main(String[] args) {

    }

    // ***************** 1st Method ******************
    // Approach 1: Base condition if n<=0 => false
    // Loop with each iteration check if n % 4 != 0 => false
    // Loop until n == 1 and each iteration n /= 4
    // Out of loop -> true
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.46MB     -> + 24.53%
    public boolean isPowerOfFour(int n) {
        if(n == Integer.MIN_VALUE) return false;

        while(n > 1) {
            if(n % 4 != 0)
                return false;
            n /= 4;
        }

        return true;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 1st Method ******************
    // Approach 2: Use recursion of given method
    // Base case, n=0 -> false, n=1 true
    // Recursion with n%4=0 && isPowerOfFour(n/4)
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.72MB     -> + 17.69%
    public boolean isPowerOfFour2(int n) {
        if(n==0) return false;
        if(n==1) return true;
        return (n%4 ==0) && isPowerOfFour(n/4);
    }
    //  ***************** End of 2nd Method ******************

}
