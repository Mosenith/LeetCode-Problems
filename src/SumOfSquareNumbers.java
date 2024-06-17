public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(100000));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use two pointers i and r
    // Start from 0 and r = sqrt(c)
    // If i^2 + r^2 > c, r--. If i^2 + r^2 < c, i++. Else, return true
    // Runtime  : 3ms       -> + 97.79%
    // Memory   : 40.74MB   -> + 9.53%
    public static boolean judgeSquareSum(int c) {
        if(c == 1) return true;
        long r = (int) Math.sqrt(c);

        for(int i=0; i<=r;) {
            if(((long) i*i) + (r*r) > c) {
                r--;
            } else if(((long) i *i) + (r*r) < c) {
                i++;
            } else {
                return true;
            }
        }

        return false;
    }
    //  ***************** End of 1st Method ******************

}
