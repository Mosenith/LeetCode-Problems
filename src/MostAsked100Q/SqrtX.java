package MostAsked100Q;


import java.util.ArrayList;
import java.util.List;

public class SqrtX {
    // ***************** 1st Method ******************
    // Approach :
    // Runtime  : 34ms           -> + 10.55%
    // Memory   : 39.71 MB      -> + 65.96%
    public static int mySqrt(int x) {
        int ans = 0;
        while((long) ans * ans < x) {
            ans++;
        }
        return ((long) ans * ans == x) ? ans : ans-1;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach :
    // Runtime  : 3ms           -> + 17.28%
    // Memory   : 42.4 MB      -> + 5.44%
    public static int mySqrt2(int x) {
        if(x <= 1) return x;
        int pre = 0;
        int cur = x/2;
        Long multiply = (long) ((long) cur * cur);
        System.out.println("copyX = " + cur);

        while(multiply > x) {
            pre = cur;
            cur /= 2;
            multiply = ((long) cur * cur);
            System.out.println("copyX = " + cur);

            if(pre < cur) return cur;
            while(multiply < x) {
                if(pre - cur == 1) return cur;
                cur = (pre + cur) / 2;
                multiply = ((long) cur * cur);
            }
            System.out.println(pre + " : " + cur);
            System.out.println("**********************************");
        }

        System.out.println(pre + " : " + cur);


        return cur;
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach : Optimized method - Use 2 pointers: left & right (left<=right)
    // Use mid = left + (right - left) / 2 to avoid overflow
    // If mid*mid > x => right = mid-1
    // else mid*mid <= x => result = mid & left = mid+1
    // Runtime  : 1ms           -> + 100%
    // Memory   : 39.61 MB      -> + 77.56%
    public static int mySqrt3(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 0;
        int right = x;
        int result = 0;

        while (left <= right) {
            // instead of mid = (left + right)/2 to avoid overflow
            int mid = left + (right - left) / 2;

            System.out.println(left + " : " + mid + " : " + right);
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            System.out.print("After => ");
            System.out.println(left + " : " + mid + " : " + right);
            System.out.println("**********************************");

        }

        return result;
    }

    // ***************** End of 3rd Method ******************

    // ***************** 4th Method ******************
    // Approach : Similar to 3rd Method - just different condition
    // while(left < right) && return left
    // Runtime  : 1ms           -> + 100%
    // Memory   : 39.95 MB      -> + 40.16%
    public static int mySqrt4(int x) {
        int left = 0, right = x;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (mid <= x / mid) {
                // mid*mid <= x
                left = mid;
            } else {
                right = mid - 1;
            }

            System.out.println(left + " : " + mid + " : " + right);
            System.out.println("**********************************");
        }
        return left;
    }
    // ***************** End of 4th Method ******************

    static public void main(String[] args) {
        int x = 4; // 2
        int y = 8; // 2
    // 2147395599 -> 46339
//        System.out.println(mySqrt(x));
//        System.out.println(mySqrt(80));
//        System.out.println(mySqrt4(80));

       List<Integer> aa = new ArrayList<>();
       StringBuffer str = new StringBuffer();
       StringBuffer str2 = new StringBuffer();

    }
}
