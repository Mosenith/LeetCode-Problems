import java.util.ArrayList;
import java.util.List;

public class CountAndSaySequence {
    //    ***************** 1st Method ******************
    // Runtime  : 3ms        -> + 75.64%
    // Memory   : 41.6MB      -> + 55.46%
    // Using iteration
    public static String countAndSay(int n) {
        // base case
        if(n == 1)
            return "1";

        List<String> storeStr = new ArrayList<>();
        storeStr.add("1");
        int count = 1;
        while(count < n) {
            int len = storeStr.size();
            storeStr.add(sayNumber(storeStr.get(len-1)));
            count++;
        }

        return storeStr.get(storeStr.size()-1);
    }

    private static String sayNumber(String strNum) {
        StringBuilder retString = new StringBuilder();
        for(int i=0; i<=strNum.length()-1;) {
            int c = 1;
            while(i<strNum.length()-1 && strNum.charAt(i) == strNum.charAt(i+1)) {
                i++;
                c++;
            }
            retString.append(String.valueOf(c)).append(strNum.charAt(i));
            i++;
        }

        return retString.toString();
    }
    //  ***************** End of 1st Method ******************

    //    ***************** 2nd Method ******************
    // Runtime  : 3ms        -> + 75.64%
    // Memory   : 41.7MB      -> + 53.67%
    // Using Recursive : still need to include sayNumber inside
    public static String countAndSay2(int n) {
        // base case
        if(n == 1)
            return "1";

        String s = countAndSay2(n-1);
        s = sayNumber(s);

        return s;
    }
    //  ***************** End of 2nd Method ******************

    //    ***************** 3rd Method ******************
    // Runtime  : 2ms        -> + 98.55%
    // Memory   : 39.9MB      -> + 84.94%
    // StraightForward Method
    public static String countAndSay3(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countIdx(s);
            System.out.print(s);
        }
        return s;
    }

    public static String countIdx(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        System.out.println(" - " + sb.toString());
        return sb.toString();
    }
    //  ***************** End of 3rd Method ******************

    //    ***************** 4th Method ******************
    // Runtime  : 2ms        -> + 98.55%
    // Memory   : 40MB      -> + 78.86%
    // Using Recursive : Best of all the Methods
    public static String countAndSay4(int n) {
        if(n == 1) return "1";
        String prev = countAndSay(n - 1);
        StringBuilder str = new StringBuilder();
        int i = 0;
        while(i < prev.length()) {
            char curr = prev.charAt(i);
            int j = 0;  // count num of occurrence
            while(i+j < prev.length() && prev.charAt(i+j) == curr)
                j++;
            str.append(j);
            str.append(curr);
            i += j;
        }
        return str.toString();
    }
    //  ***************** End of 4th Method ******************

    public static void main(String[] args) {
        int n = 4;  // out ; "1211"

        System.out.println(countAndSay3(4));
//
//        System.out.println(sayNumber("21"));
    }



}
