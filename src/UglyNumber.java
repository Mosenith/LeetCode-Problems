public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(-1000));
    }

    // ***************** 1st Method ******************
    // Approach 1: Ugly number - prime factors are limited to 2, 3, and 5
    // Check if n < 1 -> false, proceed to loop n%2=0 until there's no 2 factors
    // Then, n%3=0 and n%5=0 until no 3 & 5 factor
    // Finally, if there's no other prime number n = 1 => true
    // otherwise there's other prime num factors => false;
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.46MB     -> + 24.53%
    public static boolean isUgly(int n) {
        if (n == Integer.MIN_VALUE)
            return false;

        if (n < 0)
            n = Math.abs(n);

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }
    //  ***************** End of 1st Method ******************

}
