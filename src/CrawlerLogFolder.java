import java.util.Stack;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        String[] logs = {"d1/","d2/","../","d21/","./"};
    }

    // ***************** 1st Method ******************
    // Approach 1: Use stack to store the folder names
    // When encounter "../", pop from stack, when encounter "./", continue
    // Else, push the folder name to stack. Then return stack size
    // Runtime  : 1ms         -> + 99.42%
    // Memory   : 42.30MB     -> + 19.93%
    public int minOperations(String[] logs) {
        Stack<String> stk = new Stack<>();

        for(String s : logs) {
            if(s.equals("../")) {
                if(!stk.isEmpty()) {
                    stk.pop();
                }
            } else if(s.equals("./")) {
                continue;
            } else {
                stk.push(s);
            }
        }
        return stk.size();
    }
    // ***************** End of 1st Method ******************
}
