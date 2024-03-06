public class UniqueSubstringsInWraparoundString {
    public static void main(String[] args) {
        String s = "zab";

        System.out.println(findSubstringInWraproundString(s));
    }

    // diff should always be 1 or 'z' follows by 'a'
    // If all char diff btw each other is 1 or 'za' => signma from 0 to n = n*(n+1)/2
    // If not => add # chars
    public static int findSubstringInWraproundString(String s) {

        for(char c : s.toCharArray()) {
            System.out.println(c + " => " + Character.getNumericValue(c));
        }
        return 0;
    }
}
