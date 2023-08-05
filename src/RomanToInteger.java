import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int res = 0;
        int[] n = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] sym = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        // 1:I, 10:X, 100:C
        // i+1 or i+3
        for(int i=0; i<s.length(); i++) {
            String currentChar = Character.toString(s.charAt(i));
            for(int j=0; j<sym.length; j++) {
                if(i<s.length()-1 && currentChar.equals(sym[j])) {

                    if(currentChar.equals("I") || currentChar.equals("X") || currentChar.equals("C")) {
                        String nextChar = currentChar + Character.toString(s.charAt(i + 1));
                        if (nextChar.equals(sym[j + 1])){   // digit 4
                            res += n[j + 1];
                            i += 1;
                        } else if(nextChar.equals(sym[j+3])) {  // digit 9
                            res += n[j + 3];
                            i += 1;
                        } else {
                            res += n[j];
                        }
                    }  else {
                        res += n[j];    // others
                    }
                    break;
                }

                if(i==s.length()-1 && currentChar.equals(sym[j])) {
                    res += n[j];
                    break;
                }
            }
        }

        return res;
    }

    public static int romanToInt_Sample(String s) {
        Map<String, Integer> nums = new HashMap<>();
        nums.put("M", 1000);
        nums.put("CM", 900);
        nums.put("D", 500);
        nums.put("CD", 400);
        nums.put("C", 100);
        nums.put("XC", 90);
        nums.put("L", 50);
        nums.put("XL", 40);
        nums.put("X", 10);
        nums.put("IX", 9);
        nums.put("V", 5);
        nums.put("IV", 4);
        nums.put("I", 1);
        int res = 0;
        for (int i = 0; i < s.length();) {
            System.out.println(i + "-" + s.substring(i, i + 2));
            if (i + 1 < s.length() && nums.get(s.substring(i, i + 2)) != null) {
                res += nums.get(s.substring(i, i + 2));
                i += 2;
            } else {
                res += nums.get(s.substring(i, i + 1));
                i += 1;
            }
        }
        return res;
    }

    public static int romanToInt_Sample2(String s) {
        int[] arr = new int['A' + 26];
        arr['I'] = 1;
        arr['V'] = 5;
        arr['X'] = 10;
        arr['L'] = 50;
        arr['C'] = 100;
        arr['D'] = 500;
        arr['M'] = 1000;

        int result = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = arr[s.charAt(i)];
            result += prev > current ? -current : current;
            prev = current;
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "LVIII";
        String s2 = "MMCDXXV";  // 2425

        System.out.println(romanToInt(s2));
    }
}
