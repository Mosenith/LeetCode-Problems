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

    // ***************** 2nd Method ******************
    // Approach 2: More organised and short version
    // Runtime  : 2ms           -> + 83.02%
    // Memory   : 43.04MB       -> + 85.29%
    public static String maximumOddBinaryNumber2(String s) {
        int oneCount = -1;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            oneCount += (s.charAt(i) == '1') ? 1 : 0;
        }
        for (int i = 0; i < s.length(); i++, oneCount--) {
            ans.append(oneCount > 0 ? '1' : '0');
        }

        // the rightest char must always be '1' to make ans odd
//        ans.deleteCharAt(ans.length() - 1);
        ans.replace(ans.length()-1,ans.length(), "1");
        return ans.toString();
    }
    //  ***************** End of 2nd Method ******************
}
