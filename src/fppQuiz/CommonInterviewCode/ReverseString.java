package fppQuiz.CommonInterviewCode;

public class ReverseString {
    public static void main(String[] args) {
        String s = "apple";

        System.out.println(reverse(s));
    }

    public static String reverse(String s) {
        StringBuffer stringBuffer = new StringBuffer();

        for(int i=s.length()-1; i>=0; i--) {
            stringBuffer.append(s.charAt(i));
        }

        return stringBuffer.toString();
    }
}
