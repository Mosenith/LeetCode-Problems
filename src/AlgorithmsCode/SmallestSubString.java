package AlgorithmsCode;

import java.util.*;

public class SmallestSubString {
    public static void main(String[] args) {
        char[] arr = {'x', 'y', 'z'};
        String str = "xyyzyzyx";

//        System.out.println(str.length());
        System.out.println(getShortestSubstring2(arr, str));
    }

    public static String getShortestSubstring(char[] arr, String str) {
        Set<Character> set = new HashSet<>();
        int len = arr.length;

        for(char c : arr) {
            set.add(c);
        }

        System.out.println(set);

        StringBuilder curAns = new StringBuilder("");
        for(int i=0; i<str.length()-2; i++) {
            String curString = str.substring(i);
            System.out.println(str.substring(i) + " : " + str.substring(i).length());
            if(matchNumberCharacters(curString,new HashSet<>(set)) == 3) {
                System.out.println("matched!!");
                if(curAns.isEmpty() || curString.length() < curAns.length())  {
                    curAns = new StringBuilder(curString);
                }
            }
            System.out.println("CurAns = " + curAns + ", len = " + curAns.length());
            System.out.println("*******\n");
        }

        System.out.println("final = " + curAns);

        return curAns.toString();
    }

    private static int matchNumberCharacters(String curString, Set<Character> set) {
        int match = 0;

        for(Character c : curString.toCharArray()) {
            if(set.contains(c)) {
                match++;
                set.remove(c);
            }
            if(set.isEmpty())
                break;
        }

        return match;
    }
    // ***************** End of 1st Method ******************


    public static String getShortestSubstring2(char[] arr, String str) {
        int[] charCounts = new int[256];  // Assuming ASCII characters

//        System.out.println(Arrays.toString(charCounts));

        // Initialize character counts
        for (char c : arr) {
            charCounts[c]++;
        }

//        System.out.println(Arrays.toString(charCounts));

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < str.length()) {
            charCounts[str.charAt(right)]--;

            System.out.println(Arrays.toString(charCounts));
            // Move the left pointer to minimize the substring length
            while (allZeros(charCounts)) {
                System.out.println("All Zero True!");
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                charCounts[str.charAt(left)]++;
                left++;
            }

            right++;
            System.out.println(Arrays.toString(charCounts));
            System.out.println(left + " : " + right);
            System.out.println(minLeft + " - " + minLeft);
            System.out.println("******************");
        }

        return (minLen == Integer.MAX_VALUE) ? "" : str.substring(minLeft, minLeft + minLen);
    }

    private static boolean allZeros(int[] charCounts) {
        for (int count : charCounts) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }

}
