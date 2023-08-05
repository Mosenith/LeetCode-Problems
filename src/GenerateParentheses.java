import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return res;
    }

    public void recurse(List<String> res, int left, int right, String s, int n) {
        // n*2 is maximum length of the String answer
        // when reach maximum length, s is added to "List<String> res"
        // List<String> res: is the return answer
        if (s.length() == n * 2) {
            System.out.println("Added String : " + s);
            System.out.println("************************\n");
            res.add(s);
            return;
        }

        System.out.println("Left");
        if (left < n) {
            System.out.println(s);
            recurse(res, left + 1, right, s + "(", n);
        }

        System.out.println("Right");
        if (right < left) {
            System.out.println(s);
            recurse(res, left, right + 1, s + ")", n);
        }
    }

    public static void main(String[] args) {
        // ["((()))","(()())","(())()","()(())","()()()"]
        int num = 3;

        GenerateParentheses parentheses = new GenerateParentheses();
        List<String> result = parentheses.generateParenthesis(3);

        System.out.println(result.toString());
    }

}
