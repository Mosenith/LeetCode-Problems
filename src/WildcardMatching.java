import java.util.Arrays;

public class WildcardMatching {
    // p can contain :
    // '?' Matches any single character.
    // '*' Matches any sequence of characters (including the empty sequence).
    // ***************** 1st Method ******************
    // Runtime  : 2ms        -> + 100%
    // Memory   : 42.4MB      -> + 92.37%
    public static boolean isMatch(String s, String p) {
       int i=0, j=0;
        while (i<s.length() && j<p.length()) {
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                i++;
                j++;
            } else if(p.charAt(j) == '*') {
                if(i == 0)
                    i++;
                else if(s.charAt(i) == s.charAt(i-1)) {
                    i++;
                } else {
                    j++;
                }
            } else
                return false;
        }

        System.out.println(i);
        return i == s.length();
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 31ms        -> + 59.41%
    // Memory   : 43.1MB      -> + 48.58%
    // Using DP : Bottom up approach
    public static boolean isMatch2(String s, String p) {
        // corner case
        if (s == null || p == null)
            return false;

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // 1. dp[0][0] = true, since empty string matches empty pattern
        dp[0][0] = true;

        // 2. dp[0][i] = false
        // since empty pattern cannot match non-empty string

        // 3. dp[j][0]
        // for any continuative '*' will match empty string
        // e.g s='aasffdasda' p='*'/'**'/'***'....
        System.out.println("Before loop : " + Arrays.deepToString(dp));
        for (int j = 1; j < n + 1; j++) {
//            System.out.println(p.charAt(j - 1));
            if (p.charAt(j - 1) == '*') {
                dp[j][0] = dp[j - 1][0];
            }
//            System.out.println(Arrays.deepToString(dp));
        }

        // 1. if p.charAt(j) == s.charAt(i), match single character
        // =>>> dp[i][j] = dp[i - 1][j - 1]

        // 2. if p.charAt(j) == '?', '?' match single character
        // =>>> dp[i][j] = dp[i - 1][j - 1]

        // 3. if p.charAt(j) == '*', dp[i][j]=dp[i-1][j]||dp[i][j-1]
        // =>>> a. '*' match empty: dp[i][j]=dp[i-1][j]
        // =>>> b. '*' match multiple characters: dp[i][j]=dp[i][j-1]

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char charS = s.charAt(i - 1);
                char charP = p.charAt(j - 1);
                if (charS == charP || charP == '?')
                    dp[j][i] = dp[j - 1][i - 1];
                else if (charP == '*')
                    dp[j][i] = dp[j - 1][i] || dp[j][i - 1];
            }
        }
        return dp[n][m];
    }

    // ***************** 3rd Method ******************
    // Runtime  : 35ms        -> + 53.12%
    // Memory   : 447.MB      -> + 24.38%
    // DP : Memoize
    static Boolean dp[][];
    public static boolean isMatch3(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return wm (s , p , 0 , 0);
    }
    private static boolean wm(String s , String p , int i , int j){
        // if we reach end of both string simultaneously return true
        if(s.length()==i && p.length() == j) return true;


        //if string s has ended we need to check that remaining characters in p are all asteriks.
        if(i == s.length()){
            for(int index = j;index<p.length();index++){
                if(p.charAt(index)!='*'){
                    return false;
                }
            }
            return true;
        }

        //if string p has ended and s still remains , there is no way to match, think think!
        if(j == p.length() && i!=s.length())return false;

        //if sub problem already solved return it
        if(dp[i][j]!=null)return dp[i][j];

        boolean ans = false;

        if(p.charAt(j)=='?'){
            //using ? as a single character(go ahead in both s and p )
            if(wm(s,p,i+1,j+1)){
                ans = true;
            }

        }
        else if(p.charAt(j)=='*'){
            //using * as empty string (go ahead in just p)
            if(wm(s,p,i,j+1)){
                ans = true;
            }
            //using * as multiple characters(go ahead in s but not p)
            if(wm(s,p,i+1,j)){
                ans = true;
            }
            // using * as single character(go ahead in both s and p)
            if(wm(s,p,i+1,j+1)){
                ans   = true;
            }

        }
        //if both i and j have characters then if they match go ahead in both else ans is false by default
        else if(p.charAt(j)==s.charAt(i) && wm(s,p,i+1,j+1)){
            ans= true;
        }
        dp[i][j] = ans;
        return ans;
    }
    //  ***************** End of 3rd Method ******************

    public static void main(String[] args) {
//        String s = "aa", p = "a";   // false
//        String s = "aa", p = "*";   // true
//        String s = "aa", p = "?a";  // false
//        String s = "adceb", p = "*a*b";    // true
        String s = "abed", p = "?b*d**";

        System.out.println(isMatch3(s,p));

    }
}
