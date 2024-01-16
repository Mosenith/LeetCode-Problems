public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "babbabbabbabbab";

        System.out.println(s.length());
        System.out.println(repeatedSubstringPattern2(s));
    }

    // ***************** 1st Method ******************
    // Approach 1: At max len of repeated pattern in s is mid = s.len/2
    // Start from cur=s.subString(0,mid) & check from mid-mid+cur.len till s.len
    // If at some points, s.substring(mid,mid+cur.len) != cur => break
    // But if it equals cur till mid+cur.len == s.len => true
    // After inner loop, mid--. Out of loop => false
    // Runtime  : 104ms         -> + 18.95%
    // Memory   : 45.40MB       -> + 14.29%
    public static boolean repeatedSubstringPattern(String s) {
        int mid = s.length()/2;
        while (mid > 1) {
            String curSub = s.substring(0,mid);
            int len = curSub.length();
            int preMid = mid;
            while(preMid + len <= s.length()) {
                if(!curSub.equals(s.substring(preMid,preMid+len))) {
                    break;
                }

                if(preMid + len == s.length()) {
                    return true;
                }
                preMid += len;
            }
            mid--;
        }

        return false;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Create a new str = s+s
    // If s has repeatedSubstringPattern, str.sub(1,str.len-1) will contain s
    // Runtime  : 78ms        -> + 25.44%
    // Memory   : 44.95MB     -> + 38.57%
    public static boolean repeatedSubstringPattern2(String s) {
        String str = s + s;
        System.out.println(str);
        System.out.println(str.substring(1, str.length() - 1));
        return str.substring(1, str.length() - 1).contains(s);
    }
    //  ***************** End of 2nd Method ******************
}
