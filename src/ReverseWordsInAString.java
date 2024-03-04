import java.util.Arrays;
import java.util.Stack;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue"; // blue is sky the

        System.out.println(reverseWords2(s));
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

    // ***************** 2nd Method ******************
    // Approach 2: Use stack to store all split string
    // Then pop each on string in stack and append to ans
    // Runtime  : 6ms           -> + 83.86%
    // Memory   : 42.94MB       -> + 73.30%
    public static String reverseWords2(String s) {
        Stack<String> stk = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            int j = i;
            while(j<s.length() && s.charAt(j) != ' ') {
                j++;
            }
            if(i != j) {
                stk.push(s.substring(i,j));
                i = (j-1);
            }
        }

        StringBuilder str = new StringBuilder();
        while(!stk.isEmpty()) {
            str.append(stk.pop() + " ");
        }

        return str.substring(0,str.length()-1);
    }
    //  ***************** End of 2nd Method ******************
}
