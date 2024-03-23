import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        String s1 = "3[a2[c]]";  // "accaccacc"
        String s2 = "2[abc]3[cd]ef";    // "abcabccdcdcdef"
        String s3 = "3[a]2[bc]";    // "aaabcbc"

        System.out.println(decodeString(s3));
    }
    // num,[,char,] -> 4*n-1
    // 8-1=7
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> ls = new ArrayList<>();

        System.out.println("===== Start Func =====");
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ']') continue;
            if(Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
                continue;
            }
            int num = Character.getNumericValue(s.charAt(i));
            int next = i+2;

            while(s.charAt(next) != ']') {
                next++;
                if(Character.isDigit(s.charAt(next))) {
                    // recursion
                    System.out.println(next + " recursion => s = " + s.substring(next));
                    ls.add(decodeString(s.substring(next)));
                }
            }

            if(ls.isEmpty()) {
                StringBuilder tmp = new StringBuilder(s.substring(i+2,next));
                sb.append(String.valueOf(tmp).repeat(Math.max(0, num)));
            } else {

            }
            i = next;
            System.out.println("cur => " + sb);
            System.out.println("****************\n");
        }

        return sb.toString();
    }
}
