public class PalindromicSubstrings {
    public static void main(String[] args) {
        // 6 - "a", "a", "a", "aa", "aa", "aaa"
        String s = "aaa";
    }

    public int countSubstrings(String s) {
        int count = s.length();

        return count;
    }

    private boolean isPalindrome(String s) {
        for(int i=0,j=s.length()-1; i<j; i++, j--) {
            if(s.charAt(i) != s.charAt(j))
                return false;
        }

        return true;
    }
}
