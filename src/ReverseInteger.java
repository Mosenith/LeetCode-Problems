import java.lang.Math;
import java.time.temporal.ValueRange;
import java.util.*;

public class ReverseInteger {
    public static int reverseInt(int x) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        int copyX = (x < 0) ? -x : x;
        int output = 0;

        // get digit of x
        while(copyX > 0){
            int remain = copyX % 10;
            num.add(remain);
            copyX = copyX / 10;
        }

        int pow = num.size() - 1;
        for (Integer integer : num) {
            output += integer * Math.pow(10, pow);
            pow--;
        }

        if(output == 2147483647 || output ==-2147483648)
            return 0;

        return (x < 0) ? -output : output;
    }
    public static int reverseInt2(int x){
        //ArrayList<Integer> num = new ArrayList<Integer>();
        int copyX = (x < 0) ? -x : x;
        int output = 0, digit = 0;

        // get digit of x
        while(copyX > 0){
            copyX = copyX / 10;
            digit++;
        }

        copyX = (x < 0) ? -x : x;
        for(int i=digit-1; i>=0; i--){
            output += (copyX%10) * Math.pow(10,i);
            copyX = copyX / 10;
        }

        if(output == 2147483647 || output ==-2147483648)
            return 0;

        return (x < 0) ? -output : output;
    }

    public static int reverseInt3(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;		// remainder
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
            System.out.println("pop: " + pop + ", rev: " + rev );
        }
        return rev;
    }

    public static int reverseInt4(int x){
        int output = 0;

        while(x != 0){
            int remain = x % 10;
            x /= 10;
            output = output * 10 + remain;
            if(output > Integer.MAX_VALUE/10 || output < Integer.MIN_VALUE/10) return 0;
        }

        return output;
    }

    public static int reverse(int x) {
        if (x == 0) return 0;
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
            x /= 10;
        }
        return (int) res;
    }
    public static void main(String[] args) {

        int num = 1638474129;   // overflow

        System.out.println(reverse(num));
        //System.out.println(123 / 10);
    }
}
