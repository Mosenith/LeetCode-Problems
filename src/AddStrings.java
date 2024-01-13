import java.util.Arrays;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("237", "284"));
    }

    public static String addStrings(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        char[] res = new char[n1.length+n2.length];
        int index = res.length-1;
        int remain = 0;
        int i=n1.length-1, j=n2.length-1;
        for(; i>=0 && j>=0; i--, j--) {
            int cur = Character.getNumericValue(n1[i]) + Character.getNumericValue(n2[j]) + remain;
            if(cur < 10) {
                res[index--] = (char) (cur + '0');
                remain = 0;
            } else {
                res[index--] = (char) ((cur % 10) + '0');
                remain = 1;
            }
        }

        while(i >= 0 ) {
            int cur = Character.getNumericValue(n1[i--]) + remain;
            res[index--] = (char) ((cur % 10) + '0');
            remain = (cur / 10  == 1) ? 1 : 0;
        }

        while(j >= 0 ) {
            int cur = Character.getNumericValue(n2[j--]) + remain;
            res[index--] = (char) ((cur % 10) + '0');
            remain = (cur / 10  == 1) ? 1 : 0;
        }

        if(remain == 1) {
            res[index] = (char) (remain + '0');
        }
        return String.valueOf(res).replace("\0", "");
    }
}
