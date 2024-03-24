import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        String s1 = "3[a2[c]]";  // "accaccacc"
        String s2 = "2[abc]3[cd]ef";    // "abcabccdcdcdef"
        String s3 = "3[a]2[bc]";    // "aaabcbc"
        String s4 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";

        System.out.println(decodeString(s2));
    }
    // 3[z]- 2[ 2[y]-pq- 4[2[jk]e1[f]]]ef
    // yypq -
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int count = 0;
        StringBuilder currentString = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
            System.out.println("*****************\n");
        }
        return currentString.toString();
    }


}
