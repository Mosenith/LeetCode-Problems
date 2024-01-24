import java.util.Arrays;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "bcabc"; // abc

        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        boolean[] alpha = new boolean[26];

        for(char c : s.toCharArray()) {
            if(!alpha[c - 97]) {
                alpha[c-97] = true;
            }
        }

        StringBuilder strb = new StringBuilder();
        for(int i=0; i<alpha.length; i++) {
            if(alpha[i]) {
                strb.append((char) ('a' + i));
            }
        }

        System.out.println(Arrays.toString(alpha));
        return strb.toString();
    }
}
