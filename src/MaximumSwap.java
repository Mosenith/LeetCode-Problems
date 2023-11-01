import java.util.*;

public class MaximumSwap {
    public static void main(String[] args) {
        int num = 2736; // 7236
        int num2 = 9973; // 9973


        System.out.println(maximumSwap(num));
        System.out.println("****");
//        maximumSwap(num2);
    }

    // ***************** 1st Method ******************
    // Approach 1: Split num to char array
    // Use buckets to record the last position of digit 0 ~ 9 in this num
    // Loop through numArray(left to right) & bucket(right to d[i])
    // Check if the position of this larger digit is behind the current one
    // If so swap and return
    // Runtime  : 1ms            -> + 94.94%
    // Memory   : 40.74MB        -> + 59.52%
    public static int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            System.out.println("digits[i] - '0' = " + (digits[i]- '0'));
            buckets[digits[i] - '0'] = i;
            System.out.println(Arrays.toString(buckets));
            System.out.println("**************");
        }

        System.out.println("\n**************");
        System.out.println(Arrays.toString(digits));
        System.out.println(Arrays.toString(buckets));
        System.out.println("**************\n");


        for(int i=0; i<digits.length; i++) {
            for(int j=9; j>digits[i]-'0'; j--) {
                if(buckets[j] > i) {
                    // swap
                    char tmp = digits[i];
                    System.out.println("i=" + i + " => d[i]=" + tmp);
                    System.out.println("j=" + j + " => buckets[j]=" + buckets[j]);
                    digits[i] = digits[buckets[j]];
                    digits[buckets[j]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
                System.out.println("\n**************");
            }
            System.out.println("===============\n");

        }
        return num;
    }
    // ***************** End of 1st Method ******************

}
