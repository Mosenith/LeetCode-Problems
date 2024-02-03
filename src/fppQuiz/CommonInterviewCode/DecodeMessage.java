package fppQuiz.CommonInterviewCode;

public class DecodeMessage {
    public static void main(String[] args) {
        String msg = " olleH I   epoh uoy era";
//        StringBuilder sb = new StringBuilder();
//        sb.append("olleH");
//        System.out.println(sb);
//        System.out.println(sb.reverse());

        System.out.println(decode(msg));
    }

    public static String decode(String msg) {
        StringBuilder ans = new StringBuilder();
        char[] c = msg.toCharArray();

        for(int i=0; i<c.length;) {
            if(c[i] == ' ') {
                i++;
                continue;
            }
            int j = i;
            StringBuilder tmp = new StringBuilder();
            while(j<c.length && c[j] != ' ') {
                tmp.append(c[j]);
                j++;
            }

            ans.append(tmp.reverse() + " ");
            i = j;
        }

        return ans.subSequence(0,ans.length()-1).toString();
    }
}
