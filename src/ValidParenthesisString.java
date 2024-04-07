import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";

        System.out.println(checkValidString("s"));
    }

    public static boolean checkValidString(String s) {
        Stack<Character> stkLeft = new Stack<>();
        Stack<Character> stkRight = new Stack<>();
        Stack<Character> stkStar = new Stack<>();
        char[] sChar = s.toCharArray();

        for(int i=0; i<sChar.length; i++) {
            char c = sChar[i];
            if(c == '(') {
                stkLeft.push(c);
            } else if(c == '*') {
                if(i<sChar.length-1 && sChar[i+1] == '(') {
                    stkStar.push(c);
                } else {
                    if(!stkLeft.isEmpty()) stkLeft.pop();
                    stkStar.push(c);

                    i++;
                }
            } else {
                // c = ')'
                stkRight.push(c);
            }
        }
        System.out.println(stkLeft.size());
        System.out.println(stkRight.size());
        System.out.println(stkStar.size());

        if(stkLeft.size()==stkRight.size()) {
            return true; }

        return Math.min(stkLeft.size(), stkRight.size()) + stkStar.size() ==
                Math.max(stkRight.size(), stkLeft.size());
    }
}


//        stkRight.size()+stkStar.size() == stkLeft.size() ||
//        stkLeft.size()+stkStar.size() == stkRight.size()

// 49