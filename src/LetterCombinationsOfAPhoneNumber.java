import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations1(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            System.out.println("x = " + x);
            System.out.println("***********");
            //System.out.println("Outside loop: " + ans.peek() + " - " + i);
            while(ans.peek().length()==i){
                System.out.print(ans.peek() + " : " + i);
                String t = ans.remove();
                System.out.println(", t = " + t);
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

    // quite similar to 1 but with only 2 loops
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length()!=digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove+c);
            }
        }
        return ans;
    }

    // best out of the 3
    public static List<String> letterCombinations3(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        System.out.println(digits.toCharArray());
        ans.add("");
        String[] d = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (char i : digits.toCharArray()) {
            String s = d[i - '2'];
            System.out.println("s = " + s);
                    List<String> t = new ArrayList<>();
            for (String a : ans) {
                System.out.println("a = " + a + ", ans = " + ans);
                for (String b : s.split("")) {
                    System.out.println(a + " : " + b);
                    t.add(a + b);
                }
            }
            ans = t;
        }

        System.out.println(ans.size());
        return ans;
    }

    public static void main(String[] args) {
        String digits = "239";   // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        String digits2 = "14203";    // ["a","b","c"]

        System.out.println(letterCombinations1(digits2));
        //System.out.println(letterCombinations3(digits));
    }
}

