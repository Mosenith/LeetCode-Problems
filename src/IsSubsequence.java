public class IsSubsequence {
    public static void main(String[] args) {
//        String  s = "aaaaaa", t = "bbaaaa";
        String s = "axc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
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
}
