import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c","ad#c"));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Stack to store chars of s & t
    // Pop when encounter # & then compare both stacks by popping char one by one
    // Runtime  : 1ms         -> + 80.63%%
    // Memory   : 41.33MB     -> + 54.71%
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        util(sChar, stk1);
        util(tChar, stk2);

        if(stk1.size() != stk2.size()) return false;

        while(!stk1.isEmpty()) {
            if(stk1.pop() != stk2.pop()) {
                return false;
            }
        }

        return true;
    }

    private static void util(char[] chars, Stack<Character> stk) {
        for(char c : chars) {
            if(c == '#') {
                if(!stk.isEmpty()) {
                    stk.pop();
                }
            } else {
                stk.add(c);
            }
        }
    }
    //  ***************** End of 1st Method ******************
}
