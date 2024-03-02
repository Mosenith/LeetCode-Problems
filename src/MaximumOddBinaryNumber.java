import java.util.Arrays;

public class MaximumOddBinaryNumber {
    public static void main(String[] args) {
        String s = "0101";

        System.out.println(maximumOddBinaryNumber(s));
    }

    // ***************** 1st Method ******************
    // Approach 1: Fill array c[] of s.len with 0, then count '1' in s
    // If #one=1, then c[s.len-1] = 1 and everything else is 0
    // Otherwise, c[s.len-1] = 1 and start setting 1 from the leftest index till #one=0
    // Runtime  : 1ms           -> + 100.00%
    // Memory   : 42.92MB        -> + 91.98%
    public static String maximumOddBinaryNumber(String s) {
        char[] c = new char[s.length()];
        Arrays.fill(c,'0');

        int one = 0;

        for(char t : s.toCharArray()) {
            if(t == '1') {
                one++;
            }
        }

        if(one == 1) {
            c[s.length()-1] = '1';
            return String.valueOf(c);
        } else {
            int index = 0;
            c[s.length()-1] = '1';
            one--;
            while(one > 0) {
                c[index++] = '1';
                one--;
            }
        }
        return String.valueOf(c);
    }
    //  ***************** End of 1st Method ******************

}
