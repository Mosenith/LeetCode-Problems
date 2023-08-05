import java.util.ArrayDeque;
import java.util.Deque;

public class PowerXToN {
    // ***************** 1st Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 40.7MB      -> + 93.82%
    public static double myPow(double x, int n) {
        double result = 1.0;
        long power = n;

        if(power < 0) power = -1 * power;

        while(power > 0) {
            if(power % 2 == 1) {
                result = result * x;
                power = power - 1;
            } else {
                x = x * x;
                power = power / 2;
            }
            System.out.println(result + " : " + power);
        }

        if(n < 0) result = (double) 1.0 / result;
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(myPow(2.00, -2147483648));
        System.out.println(myPow(2.00, 4));

        char c='a';
        c++;
        System.out.println(c);

        Deque<Integer> deque = new ArrayDeque<>();

    }


}
