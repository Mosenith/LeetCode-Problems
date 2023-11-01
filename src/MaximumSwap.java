import java.util.*;

public class MaximumSwap {
    public static void main(String[] args) {
        int num = 2736; // 7236
        int num2 = 9973; // 9973


        System.out.println(maximumSwap(num));
        System.out.println("****");
//        maximumSwap(num2);
    }

    // ***************** 1st Method ******************
    // Approach 1: Split num to char array
    // Use buckets to record the last position of digit 0 ~ 9 in this num
    // Loop through numArray(left to right) & bucket(right to d[i])
    // Check if the position of this larger digit is behind the current one
    // If so swap and return
    // Runtime  : 0ms            -> + 100%
    // Memory   : 38.83MB        -> + 89.08%
    public static int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;   // arr[i] - '0' converts char to num
        }

        for(int i=0; i<digits.length; i++) {
            for(int j=9; j>digits[i]-'0'; j--) {
                if(buckets[j] > i) {    // if j exists in digit, buckets[j] > i
                    // swap & return
                    char tmp = digits[i];
                    digits[i] = digits[buckets[j]];
                    digits[buckets[j]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Convert num to String and use Map - key = numDigit, val = digitIndex
    // Outer Loop - i=0 to numStr.len, Inner Loop - j=9 to numStr[i]
    // If map containsKey(j) && i<map.get(j) => bigger digit on the right of ith index
    // Swap by converting num to charArray. Then, convert charArray to String
    // Finally return Integer of String
    // Otherwise, return num => no bigger digits on the right
    // Runtime  : 1ms            -> + 39.27%
    // Memory   : 39.00MB        -> + 79.19%
    public static int maximumSwap2(int num) {
        String numStr = String.valueOf(num);
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<numStr.length(); i++) {
            map.put(Integer.valueOf(numStr.charAt(i)-'0'), i);
        }

        for(int i=0; i<numStr.length(); i++) {
            // check from 9 to numStr[i], if there's num bigger than numStr[i]
            // if so swap
            for(int j=9; j>numStr.charAt(i)-'0'; j--) {
                if(map.containsKey(j) && i < map.get(j)) {
                    char[] numArray = Integer.toString(num).toCharArray();

                    // swap j to numStr[i] & numStr[i] to j
                    char tmp = numArray[i];
                    numArray[i] = (char) (j + '0');
                    numArray[map.get(j)] = tmp;

                    String ans = String.copyValueOf(numArray);
                    return Integer.valueOf(ans);
                    // Or return Integer.valueOf(new String(numArray));
                }
            }
        }
        return num;
    }
    // ***************** End of 2nd Method ******************

}
