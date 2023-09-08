import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "2206";

//        System.out.println(s.substring(0,2));
//        System.out.println(s.substring(1));
        System.out.println(numDecodings(s));
    }

    // ***************** 1st Method ******************
    // Approach : Num of ways depends on #digits - build from 1st digit -> s.len
    // at 2nd digit -> if 1d concat with 2d <= 26, then #ways = #prev_way + 1
    // Otherwise, #ways = #prev_way
    // Basically, at i check #ways at i-1 of ways[] (ways store #ways from i to len+1)
    // Then, check at i-1 != '0' before have ways[i] = ways[i-1]
    // Whether to increase #way[i] or not => check i-2 != '0' && subString(i-2,i) <= 26
    // Either have ways[i] += ways[i-2] or not
    // Runtime  : 1ms        -> + 89.44%
    // Memory   : 40.78 MB    -> + 58.78%
    public static int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && Integer.valueOf(s.substring(i - 2, i)) <= 26) {
                f[i] += f[i - 2];
            }
        }

        return f[n];
    }
    // ***************** End of 1st Method ******************
}