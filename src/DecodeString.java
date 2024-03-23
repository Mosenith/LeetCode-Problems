import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        String s1 = "3[a2[c]]";  // "accaccacc"
        String s2 = "2[abc]3[cd]ef";    // "abcabccdcdcdef"
        String s3 = "3[a]2[bc]";    // "aaabcbc"
        String s4 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";

        System.out.println(decodeString(s4));
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
            int prev = i;
            // get numeric
            while(Character.isDigit(s.charAt(i)) && s.charAt(i+1) != '[') {
                i++;
            }
            System.out.println("numeric -> " + s.substring(prev,i+1));
            int num = Integer.parseInt(s.substring(prev,i+1));
            int next = i+2;

            while(s.charAt(next) != ']') {
                next++;
                if(Character.isDigit(s.charAt(next))) {
                    // recursion
                    System.out.println(next + " recursion => s = " + s.substring(next));
                    ls.add(decodeString(s.substring(next)));
                    break;
                }
            }
            StringBuilder tmp = new StringBuilder();
            if(ls.isEmpty()) {
                tmp.append(s, i+2, next);
                i = next;
            } else {
                System.out.println(ls + " & " + s.substring(i+2,next));
                tmp.append(s.substring(i+2,next) + ls.get(0));
                i = next + ls.get(0).length();
            }
            sb.append(String.valueOf(tmp).repeat(Math.max(0, num)));

            System.out.println("cur => " + sb);
            System.out.println("****************\n");
        }

        return sb.toString();
    }
}
