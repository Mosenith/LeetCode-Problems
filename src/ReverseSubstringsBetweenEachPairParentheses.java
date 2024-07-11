import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairParentheses {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";

        System.out.println(reverseParentheses("sxmdll(q)eki(x)"));
    }

    public static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Queue<String> leftQueue = new ArrayDeque<>();
        Stack<String> rightStack = new Stack<>();
        int changes = 0;

        for(int i=0,j=s.length()-1; i<=j; i++,j--) {
            StringBuilder leftTmp = new StringBuilder();
            StringBuilder rightTmp = new StringBuilder();

            if(s.charAt(i) == '(') {
                i++;
                while(i<j && s.charAt(i) != '(' && s.charAt(i) != ')') {
                    leftTmp.append(s.charAt(i++));
                }

                if(s.charAt(i) != ')') {
                    while(s.charAt(j) != ')') {
                        rightStack.add(String.valueOf(s.charAt(j--)));
                    }
                }
            } else {
                while(s.charAt(i) != '(') {
                    sb.append(s.charAt(i));
                }
            }

            // changes is even reverse, otherwise no reverse
            if(changes % 2 == 0) {
                if(!rightTmp.isEmpty()) {
                    sb.append(rightTmp);
                }
                if(!leftTmp.isEmpty()) {
                    rightStack.add(leftTmp.reverse().toString());
                }
            } else {
                if(!leftTmp.isEmpty())
                    sb.append(leftTmp);
                if(!rightTmp.isEmpty())
                    rightStack.add(rightTmp.reverse().toString());
            }
            changes++;
        }

        while(!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        return sb.toString();
    }
}
