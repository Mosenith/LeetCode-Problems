package fppQuiz.CommonInterviewCode;

import java.util.ArrayList;
import java.util.List;

public class DivideCharAndNum {
    public static void main(String[] args) {
        String s = "js12 */[qi";

        List<Character> alphabeticChars = new ArrayList<>();
        List<Integer> numericChars = new ArrayList<>();
        List<Character> specialChars = new ArrayList<>();

        for(char c : s.toCharArray()) {
            if(c == ' ') continue;
            if(Character.isAlphabetic(c)) {
                alphabeticChars.add(c);
            } else if(Character.isDigit(c)) {
                numericChars.add(Integer.parseInt(String.valueOf(c)));
            } else {
                specialChars.add(c);
            }
        }


        System.out.println(alphabeticChars);
        System.out.println(numericChars);
        System.out.println(specialChars);
    }
}
