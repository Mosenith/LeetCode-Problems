import java.util.Arrays;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue"; // blue is sky the

        System.out.println(reverseWords(s));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use s.trim().split("\\s+") to split space(s)
    // Append the split string[] from the tail
    // Runtime  : 7ms           -> + 68.12%
    // Memory   : 43.26MB       -> + 57.96%
    public static String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        String[] splitS = s.trim().split("\\s+");

        for(int i=splitS.length-1; i>=0; i--) {
            str.append(splitS[i] + " ");
        }

        return str.substring(0,str.length()-1);
    }
    //  ***************** End of 1st Method ******************
}
