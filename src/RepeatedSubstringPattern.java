public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "babbabbabbabbab";

        System.out.println(s.length());
        System.out.println(repeatedSubstringPattern(s));
    }

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
}
