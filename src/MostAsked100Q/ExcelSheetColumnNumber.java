package MostAsked100Q;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        // 701
        String columnTitle = "ZY";

        // AB = 28

        System.out.println(titleToNumber2("AAA"));

//        char a = 'A'; // 65
//        char z = 'Z'; // 90
//        System.out.println(Integer.valueOf(z));
//        System.out.println(Integer.valueOf(a));
    }

    // ***************** 1st Method : HashMap ******************
    // Approach 1: Not the best - Using HashMap
    // Store key,val: A => Z
    // Runtime  : 19ms           -> + 13.12%
    // Memory   : 46.5 MB        -> + 94.77%
    public static int titleToNumber(String columnTitle) {
        HashMap<String, Integer> map = new HashMap<>();
        char alph = 'A';
        for(int i=1; i<=26; i++) {
            map.put(String.valueOf(alph++), i);
        }

        int len = columnTitle.length()-1;
        int res = 0, i = 0;
        while(i < columnTitle.length()) {
            int curAlph = map.get(String.valueOf(columnTitle.charAt(i++)));
            res += Math.pow(26,len--) * curAlph;
        }
        return res;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Integer.valueOf('A') = 65
    // curCharVal = Integer.valueOf(columnTitle.charAt(i++)) - 64;
    // At every digit of s: res += pow(26,len-1) * curCharVal
    // Loop till i == len || len < 0
    // Runtime  : 1ms           -> + 99.97%
    // Memory   : 41.16 MB      -> + 79.75%
    public static int titleToNumber2(String columnTitle) {
        int len = columnTitle.length()-1;
        int res = 0, i = 0;
        while(i < columnTitle.length()) {
            int curAlph = Integer.valueOf(columnTitle.charAt(i++)) - 64;
            res += Math.pow(26,len--) * curAlph;
        }
        return res;
    }
}
