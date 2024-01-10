public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(100000001));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use built-in Math.sqrt() to get square of num in int -> cur
    // If cur * cur == num => true, otherwise false
    // Runtime  : 0ms          -> + 100.00%
    // Memory   : 40.61MB      -> + 6.38%
    public static boolean isPerfectSquare(int num) {
        int cur = (int) Math.sqrt(num);

        return cur * cur == num;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: If built-in sqrt is not allowed, use loop to cal from cur=2
    // If cur*cur > num => false, If at some point == num -> true;
    // Runtime  : 2454ms       -> + 5.08%
    // Memory   : 40.75MB      -> + 6.38%
    public static boolean isPerfectSquare2(int num) {
        if(num==1) return true;

        int cur = 2;
        while (cur < num) {
            if((long) cur*cur == num) {
                System.out.println(cur);
                return true;
            }
            cur++;
        }

        return false;
    }
    //  ***************** End of 2nd Method ******************

}
