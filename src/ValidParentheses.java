import java.util.*;

public class ValidParentheses {
    // Runtime  : 2ms        -> + 84.74%
    // Memory   : 40.7MB      -> + 73.87%
    public static boolean isValid(String s) {
        List<String> store = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            String curr = Character.toString(s.charAt(i));
            if(curr.equals("(") || curr.equals("[") || curr.equals("{"))
                store.add(curr);
            else {
                int lastIndex = store.size()-1;
                if(lastIndex < 0) return false;
                if(curr.equals(")") && store.get(lastIndex).equals("(") ||
                        curr.equals("]") && store.get(lastIndex).equals("[") ||
                        curr.equals("}") && store.get(lastIndex).equals("{"))
                    store.remove(lastIndex);
                else
                    return false;
            }
        }

        return store.isEmpty();
    }

    /* Solution using Deque
    * Save Runtime
    */
    public boolean isValid2(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else if (stk.isEmpty() || !match(stk.pop(), c)) {
                return false;
            }
        }
        return stk.isEmpty();
    }

    private boolean match(char l, char r) {
        return (l == '(' && r == ')') || (l == '{' && r == '}') || (l == '[' && r == ']');
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        String s2 = "[({})]";   // true
        String s3 = "[(]]";
        String s4 = "]";
        Set<Integer> set = new HashSet<>();


        String cur = String.valueOf(231);
        System.out.println(cur);
//        System.out.println(isValid(s4));
    }
}
