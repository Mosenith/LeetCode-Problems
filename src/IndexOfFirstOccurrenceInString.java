public class IndexOfFirstOccurrenceInString {
    //    ***************** 1st Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 40.4MB      -> + 76.19%
    public static int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length() || !haystack.contains(needle)) return -1;

        int retIndex = -1;
        int len = needle.length();
        for(int i=0; i<=haystack.length()-len; i++) {
            if(haystack.substring(i,i+len).equals(needle)) {
                retIndex = i;
                break;
            }
        }
        return retIndex;
    }
    //  ***************** End of 1st Method ******************

    //    ***************** 2nd Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 40.6MB      -> + 57.50%
    public static int strStr2(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        int len1 = haystack.length();
        int len2 = needle.length();
        int p = 0;
        int q = 0;
        while (p < len1) {
            if (haystack.charAt(p) == needle.charAt(q)) {
                if (len2 == 1) {
                    return p;
                }
                ++p;
                ++q;
            } else {
                p -= q - 1;
                q = 0;
            }
//            System.out.println("p = " + p + ", q = " + q);
            if (q == len2) {
                return p - q;
            }
        }
        return -1;
    }
    //  ***************** End of 2nd Method ******************


    //    ***************** 3rd Method : Recursive ******************
    // Runtime  : 1ms        -> + 54.94%
    // Memory   : 40.1MB      -> + 85.77%
    public int strStr3(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
    //  ***************** End of 3rd Method ******************

    //    ***************** 4th Method : KMP ******************
    //    Complexity:
    //    Time: O(m+n), where m is needle.length, n is haystack.length
    //    Space: O(m)
    // Runtime  : 0ms        -> + 100%
    // Memory   : 39.7 MB      -> + 99.75%
    public int strStr4(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int[] lps = computeKMPTable(needle);
        int n = haystack.length(), m = needle.length();
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) j = lps[j - 1];
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (++j == m) return i - m + 1; // found solution
            }
        }
        return -1;
    }
    private int[] computeKMPTable(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = lps[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j)) lps[i] = ++j;
        }
        return lps;
    }
    //  ***************** End of 3rd Method ******************
    public static void main(String[] args) {
        String haystack1 = "sadbutsad", needle1 = "sit";    // index = 0
        String haystack2 = "leetcode", needle2 = "leeto";   // index = -1
        String haystack3 = "", needle3 = "but";

        System.out.println(strStr(haystack3, needle3));
    }
}
