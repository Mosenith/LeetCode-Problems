package MostAsked100Q;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
//        String s = "applepenapple";
//        List<String> wordDict = Arrays.asList("apple","pen");

//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");

        String s = "aebbbbs";
        List<String> wordDict = Arrays.asList("a","aeb","ebbbb","s","eb");

        // 3,3,3,4,4
        // 4,3
        System.out.println(wordBreak2(s, wordDict));
    }

    // ***************** 1st Method ******************
    // Approach 1: Utilize a boolean dp[] to mark if a substring up to a certain index
    // can be segmented using words from the dictionary
    // Set dp[0] = true to indicate an empty string can be segmented
    // Iterate through the string and for each position,
    // check if any prefix can be segmented into words from the dictionary
    // iterate from 0 to i-1 and check
    // If the substring from j to i is a valid word in the dictionary.
    // Update dp[i] based on whether the substring up to index i can be segmented,
    // considering if previous substrings can be segmented.
    // Runtime  : 7ms           -> + 49.82%
    // Memory   : 43.79 MB        -> + 19.80%
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Dynamic Programming
    // Init => Boolean dp[s.len+1], with dp[0]=true
    // Find maxLen among Dict
    // Outer loop: i=1->s.len, inner loop: j=i-1->max(i-maxLen,0), j--
    // Within inner: check dp[j] && Dict.contain(subString(j,i)), if so set dp[i]=true & break;
    // Return dp[n]
    // Runtime  : 1ms            -> + 99.68%
    // Memory   : 40.71MB        -> + 89.16%
    public static boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int max_len = 0;

        for (String word : wordDict) {
            max_len = Math.max(max_len, word.length());
        }

        System.out.println("maxLen = " + max_len);

        for (int i = 1; i <= n; i++) {
            System.out.println("i = " + i);
            System.out.println("~~~");
            for (int j = i - 1; j >= Math.max(i - max_len - 1, 0); j--) {
                System.out.println("j = " + j + " => subStr = " + s.substring(j, i));
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    System.out.println("Set " + dp[i] + " => " + Arrays.toString(dp));
                    break;
                }
                System.out.println("******************");
            }
        }

        return dp[n];
    }
    // ***************** End of 2nd Method ******************

    // ***************** Brutal Force Method ******************
    // Approach : Work but Exceed Time Limit
    static Integer len;
    static boolean flag;
    public static boolean wordBreak3(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict) {
            set.add(str);
        }

        System.out.println(set);
        len = s.length();
        flag = false;
        helper(s,set);

        System.out.println("flag  => " + flag);
        return flag;
    }
    private static void helper(String s, HashSet<String> set) {
        if(s.length() == 0) {
            return;
        }

        for(int i=0; i<s.length(); i++) {
            String curSubStr = s.substring(0,i+1);
            String leftOver  = s.substring(i+1, s.length());

            System.out.println("curSubStr = " + curSubStr +
                    ", leftOver = " + leftOver);
            System.out.println("current Len = " + len);

            if(set.contains(curSubStr)) {
                System.out.println("Contain " + curSubStr +
                        " move to self call! -> i = " + i);
                len -= curSubStr.length();
                helper(leftOver, set);
                if(len == 0) {
                    flag = true;
                    return;
                }
                len += curSubStr.length();
            }
            System.out.println("=====");
        }
    }
    // ***************** End Brutal Force Method ******************

}
