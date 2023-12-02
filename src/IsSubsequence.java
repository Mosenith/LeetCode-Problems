public class IsSubsequence {
    public static void main(String[] args) {
//        String  s = "aaaaaa", t = "bbaaaa";
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence2(s,t));
    }

    // ***************** 1st Method ******************
    // Approach : Init index of s & t to 0
    // Start working from left to right by securing the curInd of t whenever it matches curInd of s
    // if curInd of t (prev), matched with s.at(i) at j(prev->t.len) => set prev=j+1 & break;
    // If j == t.len-1 within the 2nd loop return false => curChar doesn't exist in the t
    // Within 1st loop, prev == t.length() && i != s.length()-1 => it's reached the end of t
    // while there are/is character(s) in s to be examined
    // If t.length() < s.length() => false immediately
    // Runtime  : 1ms           -> + 91.88%
    // Memory   : 40.30 MB      -> + 74.11%
    public static boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()) return false; // might consume more memory

        int i=0;
        int prev = 0;

        for (;i<s.length(); i++) {
            char cur = s.charAt(i);
            for(int j=prev; j<t.length(); j++) {
                if(t.charAt(j) == cur) {
                    prev = j+1;
                    break;
                }
                if(j == t.length()-1) {
                    return false;
                }
            }
            if(prev == t.length() && i != s.length()-1) {
                return false;
            }
        }

        return i == s.length();
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Using Recursion - start from both 0
    // If sI matched tI, increment both indices. If sI = s.len-1 => true
    // Otherwise, increment tI
    // Base case, check sI >= s.len || tI >= t.len => false
    // Runtime  : 1ms           -> + 91.88%
    // Memory   : 42.33 MB      -> + 5.21%

    public static boolean isSubsequence2(String s, String t) {
        if(s.isEmpty()) return true;

        return helper(s,t,0,0);
    }

    private static boolean helper(String s, String t, int sIndex, int tIndex) {
        if(sIndex >= s.length() || tIndex >= t.length())
            return  false;

        if(s.charAt(sIndex) == t.charAt(tIndex)) {
            if(sIndex == s.length()-1) {
                return true;
            }
            sIndex++;
        }

        return helper(s,t,sIndex,tIndex+1);
    }
    // ***************** End of 2nd Method ******************

}
