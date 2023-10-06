package MostAsked100Q;

import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args) {
        // out: [["a","a","b"],["aa","b"]]
        String s = "aab";
        // civic, radar, level, rotor, kayak, madam
//        PalindromePartitioning pp = new PalindromePartitioning();
//        System.out.println(pp.partition("abbab"));

        System.out.println(partition2(s));
    }


    private int n;
    private String s;
    private boolean[][] f;
    private List<String> t = new ArrayList<>();
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }

        System.out.println(Arrays.deepToString(f));
        this.s = s;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                t.add(s.substring(i, j + 1));
                dfs(j + 1);
                t.remove(t.size() - 1);
            }
        }
    }

    static List<List<String>> a = new ArrayList<>();
    static List<String> subList = new ArrayList<>();
    public static List<List<String>> partition2(String s) {
        helper(0,s);

        return a;
    }

    private static void helper(int start, String s) {
        if(start == s.length()) {
            System.out.println("Cur SubList = " + subList);
            a.add(new ArrayList<>(subList));
            return;
        }

        for(int i=start; i<s.length(); i++) {
            String cur = s.substring(start, i + 1);
            System.out.println("Cur = " + cur);
            if (isPalindrome(cur)) {
                subList.add(cur);
                helper(i + 1, s);
                subList.remove(subList.size() - 1);
            }
            System.out.println("***************");
        }
    }

    private static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
