import javax.swing.*;
import java.util.Arrays;

public class MultiplyStrings {
    // ***************** 1st Method ******************
    // Runtime  : 2ms        -> + 99.49%
    // Memory   : 42.4MB      -> + 52.55%
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] arr = new int[m + n];

        for (int i = m - 1; i >= 0; --i) {
            int a = num1.charAt(i) - '0';
//            System.out.println(num1.charAt(i) + " : " + a);
            for (int j = n - 1; j >= 0; --j) {
                int b = num2.charAt(j) - '0';
//                System.out.println("a = " + a + ", b = " + b);
                arr[i + j + 1] += a * b;
//                System.out.println(Arrays.toString(arr));
//                System.out.println("************************************");
            }
        }

        // element >= 10 will be divided to single digit
        // carry-on n will be added to the next element
        for (int i = arr.length - 1; i > 0; --i) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
            System.out.println(Arrays.toString(arr));
        }

        // append all element in arr[] to String
        // if arr[0]=0, skip 0th index cos 0 is not necessary at the very front
        int i = arr[0] == 0 ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        for (; i < arr.length; ++i) {
            ans.append(arr[i]);
        }

        return ans.toString();
    }


    public static void main(String[] args) {
//        String num1 = "999", num2 = "999";
//        String num1 = "123", num2 = "456";    // "56088"
        String num1 = "9", num2 = "9";
//        String num1 = "1234567", num2 = "21";  // "121932631112635269"

        System.out.println(multiply(num1,num2));

    }
}
