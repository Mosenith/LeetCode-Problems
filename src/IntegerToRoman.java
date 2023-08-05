import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        int[] n = {1, 5, 10, 50, 100, 500, 1000};
        String[] sym = {"I", "V", "X", "L", "C", "D", "M"};
        String res = "";

        while (num > 0) {
            int digit = countDigit(num);    // count digit of num
            int divideResult = (int) (num / Math.pow(10, digit));   // first single digit (from left) to consider

            if(divideResult == 4 && digit < 3) {
                // Digit from the leftest is 4
                num -= (4 * Math.pow(10,countDigit(num))) ;
                switch (digit) {
                    case 0:
                        res += "IV";
                        break;
                    case 1:
                        res += "XL";
                        break;
                    case 2:
                        res += "CD";
                        break;
                }

            } else if(divideResult == 9 && digit < 3) {
                // Digit from the leftest is 9
                // If digit > 3, use 1000('M') case
                num -= (9 * Math.pow(10,countDigit(num)));
                switch (digit) {
                    case 0:
                        res += "IX";
                        break;
                    case 1:
                        res += "XC";
                        break;
                    case 2:
                        res += "CM";
                        break;
                }
            } else {
                // Others than 4 & 9 digit and 1000+ number
                int realNumber = (int) (divideResult *  Math.pow(10, digit));   // get the real number
                num -= realNumber;  // subtract the original one. When num=0, program ends
                System.out.println("**" + realNumber);

                for(int i=0; i<n.length && realNumber!=0; i++) {
                    if(realNumber == n[i]) {
                        res += sym[i];
                        break;
                    }

                    if(i != n.length-1 && realNumber > n[i] && realNumber < n[i+1]) {
                        while(realNumber > 0) {
                            res += sym[i];
                            realNumber -= n[i];
                            if(realNumber < n[i])
                                i--;
                        }
                    }

                    if(i == n.length-1 && digit >= 3) {
                        realNumber -= (n[i] * divideResult);
                        while(divideResult != 0) {
                            res += sym[i];
                            divideResult--;
                        }
                        i++;
                    }
                }
            }
        }
        return res;
    }
    static public int countDigit(int num) {
        int digit = 0;
        while(num>0) {
            digit++;
            num /= 10;
        }

        return digit-1;
    }

    // ***** Sample *****

    public static String intToRoman_Sample1(int num) {
        Map<Integer, String> map = new HashMap();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        int[] sequence = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i<sequence.length; i++) {
            int base = sequence[i];

            while (num >= base) {
                sb.append(map.get(base));
                num -= base;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int num1 = 3;       // "III"
        int num2 = 58;      // "LVIII"
        int num3 = 1994;    // "MCMXCIV"
        int num4 = 4000;    // "MMMM"

        System.out.println("Final: " + intToRoman_Sample1(58));

    }
}


