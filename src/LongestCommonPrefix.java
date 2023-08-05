import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {
    // only compare from left to right
    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 1; j < n; ++j) {
                //System.out.println(strs[j].length() + "-" + i);
                System.out.println(strs[j].charAt(i) + "-" + strs[0].charAt(i) + "-" + j);
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};    // fl
        String[] str2 = {"dog", "racecar", "car"};
        String[] str3 = {"cir","car"};

        System.out.println(longestCommonPrefix(str2));
        //System.out.println(str[0].charAt(1));
    }
}