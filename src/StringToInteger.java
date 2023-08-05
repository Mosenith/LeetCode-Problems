import java.util.ArrayList;
import java.util.stream.IntStream;

public class StringToInteger {

    public static int myAtoi(String s) {
        int atoi = 0;
        int sign = 1;

        for(int i=0; i<s.length(); i++){
            //System.out.println(s.charAt(i));
            String rn = String.valueOf(s.charAt(i));
            if(rn.compareTo("-") == 0){
                sign = -1;
                //System.out.println("Signal at " + i);
            }

            int check = -1;
            for(int j=0; j<=9; j++){
                //System.out.println(s.charAt(i) + ":" +
                String jString = String.valueOf(j);
                if(rn.equals(jString)) {
                    check = j;
                    //System.out.println(check + ", i: " + s.charAt(i) + ", j" + j);
                    break;
                }
            }

            if(check != -1) {
                //System.out.println(check + "; atoi= " + atoi);
                atoi = (atoi == 0) ? (check) : (atoi * 10 + check);
                //System.out.println(atoi);
            }
        }
        return (sign == 1) ? atoi : atoi * -1;
    }

    public  static int myAtoi2(String s) {
        int output = 0;
        int neg = 0;       // negative value
        int pos = 0;       // positive value
        int sign = 1;       // sign

        for(int i=0; i<s.length(); i++){
            boolean numeric = true;
            String rn = String.valueOf(s.charAt(i));

            if(rn.equals(" ")) {
                continue;
            } else if(rn.equals("+")){
                System.out.println("Plus");
                if(neg != 0)
                    return 0;
                pos = 1;
                sign = pos;
            } else if(rn.equals("-")){      // if 0 : true
                if(pos != 0)
                    return 0;
                neg = -1;
                sign = neg;
            } else if(rn.equals(".")) {
                return output;              // See Later!!!
            } else {
                try {
                    int num = Integer.parseInt(rn);
                } catch (NumberFormatException e) {
                    numeric = false;
                    if(output==0)
                        return 0;
                }
            }

            int check = -1;
            for(int j=0; j<=9; j++){
                //System.out.println(s.charAt(i) + ":" +
                String jString = String.valueOf(j);
                if(rn.equals(jString)) {
                    check = j;
                    //System.out.println(check + ", i: " + s.charAt(i) + ", j" + j);
                    break;
                }
            }

            if(check != -1) {
                if(output > Integer.MAX_VALUE/10) {
                    output = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    break;
                }
                output = (output == 0) ? (check) : (output * 10 + check);
            }
        }

        return (sign == 1) ? output : output * -1;
    }

    public  static int myAtoi3(String s) {
        int output = 0;     // final result
        int neg = 0;       // negative value
        int pos = 0;       // positive value
        int sign = 1;       // sign

        for(int i=0; i<s.length(); i++){
            boolean numeric = true;
            String rn = String.valueOf(s.charAt(i));

            if(rn.equals(" ")){
                System.out.println("Space");
                continue;
            } else if(rn.equals("+")){
                System.out.println("Plus");
                if(neg != 0)
                    return 0;
                pos = 1;
                sign = pos;
            } else if(rn.equals("-")){
                System.out.println("Minus");
                if(pos != 0)
                    return 0;
                neg = -1;
                sign = neg;
                //output = (output==0)
            } else if(rn.equals(".")){
                System.out.println("Period");
                break;
            } else {
                try {
                    int num = Integer.parseInt(rn);
                    //System.out.println(num);
                    //output = (sign!=-1) ? (output * 10 + num) : (sign * num);
                    if(output > Integer.MAX_VALUE/10 || output < Integer.MIN_VALUE/10) {
                        //output = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        return (sign > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }

                    output = (output * 10) + (sign * num);
                    System.out.println(sign * num);
                    System.out.println("Last Option: " + output);
                } catch (NumberFormatException e) {
                    numeric = false;
                    return 0;
                }
            }
        }

        //return (sign == 1) ? output : output * -1;
        return output;
    }

    public  static int myAtoi4(String s) {
        int output = 0;     // final result
        int neg = 0;       // negative value
        int pos = 0;       // positive value
        int sign = 1;       // sign


        return output;
    }


    private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    public static int myAtoiSample1(String s) {
        if (s == null) return 0;
        int n = s.length();
        if (n == 0) return 0;
        int i = 0;

        // skip all the ' ' (space) within the front of s
        // exit while loop with new i value
        while (s.charAt(i) == ' ') {
            // 仅包含空格
            if (++i == n) return 0;
            //System.out.println(i);
        }
        System.out.println("Right Now: " + s);

        int sign = 1;
        // 2 or more of '-' or '+' next to each : return 0;
        if (s.charAt(i) == '-') sign = -1;                      // if s is negative value
        if (s.charAt(i) == '-' || s.charAt(i) == '+') ++i;      // update i if there is '+' or '-'
        int res = 0, flag = Integer.MAX_VALUE / 10;

        for (; i < n; ++i) {
            // when detect non-numeric,, break
            if (s.charAt(i) < '0' || s.charAt(i) > '9') break;
            System.out.println(s.charAt(i));
            // check overflow
            if (res > flag || (res == flag && s.charAt(i) > '7'))
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s.charAt(i) - '0');

        }
        return sign * res;
    }

    // private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    public static int myAtoi5(String str) {
        int i = 0, n = str.length();
        while (i < n && Character.isWhitespace(str.charAt(i)))
            i++;

        int sign = 1;
        if (i < n && str.charAt(i) == '+')
            i++;
        else if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        int num = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            System.out.println(Character.getNumericValue(str.charAt(i)));
            int digit = Character.getNumericValue(str.charAt(i));
            if (num > maxDiv10 || num == maxDiv10 && digit >= 8)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }

    public static void main(String[] args){

        String s = "3.14159";           // 3
        String s2 = "-91283472332";     // overflow
        String s3 = "+-213";            // 0
        String s4 = "  -912834";           // -121
        String s5 = "4193 with 21 words";  // 4193
        String s6 = "with words 419";   // 0

        //System.out.println(myAtoi(s));
        //System.out.println(s.length());
        System.out.println("Answer: " + myAtoi5(s5));



        //System.out.println(Integer.parseInt("a"));

    }

}
