import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s1 = "3[a2[c]]";  // "accaccacc"
        String s2 = "2[abc]3[cd]ef";    // "abcabccdcdcdef"
        String s3 = "3[a]2[bc]";    // "aaabcbc"

        System.out.println(decodeString(s1));
    }
    // num,[,char,] -> 4*n-1
    // 8-1=7
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        System.out.println("===== Start Func =====");
        for(int i=0; i<s.length(); i++){
            int num = Character.getNumericValue(s.charAt(i));

        }

        return sb.toString();
    }
}
