import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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
        Stack<String> stk = new Stack<>();

        System.out.println("===== Start Func =====");
        for(int i=0; i<s.length(); i++) {
            int prev = i;
            while(prev<s.length() && !Character.isAlphabetic(s.charAt(prev))){
                prev++;
            }

            System.out.println("mid prev = " + prev);
            StringBuilder tmp = new StringBuilder();
            while(prev<s.length() && Character.isAlphabetic(s.charAt(prev))){
                tmp.append(s.charAt(prev++));
            }

            if(!tmp.isEmpty()) {
                stk.add(tmp.toString());
            }
            i = prev;
            System.out.println("cur i=" + i);
            System.out.println("********\n");
        }
        System.out.println(stk);


        // start from right till meet numeric
        for(int i=s.length()-1; i>=0; i--) {
            System.out.println(i + " -> " + s.charAt(i));
            if(s.charAt(i) == '[') {
                int next = i;
                while(s.charAt(next) != ']') {
                    next++;
                }
                String cur = s.substring(i, next);
                if(stk.peek() != cur) {
                    sb.append(stk.pop());
                } else {
                    String loopChar = stk.pop();
                    int time = Character.getNumericValue(s.charAt(i-1));
                    // i-1 is numeric, so loop i-1 times
                    for(int j=0; j<time; j++) {
                        sb.insert(0,loopChar);
                    }
                }
            }
            System.out.println("************\n");
        }


        return sb.toString();
    }
}
