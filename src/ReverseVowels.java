import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels2("Hello"));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use a set with all vowels & use 2 pointers for loop
    // Each iteration check if charI & charJ in set => swap vowels
    // If one contains another one not => increment/decrement the one that not
    // If both not contains => increment/decrement both
    // Runtime  : 6ms          -> + 37.40%
    // Memory   : 45.15MB      -> + 18.13%
    public static String reverseVowels(String s) {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        StringBuilder str = new StringBuilder(s);
        for(int i=0,j=s.length()-1; i<j;) {
            char curCharAtI = Character.toLowerCase(s.charAt(i));
            char curCharAtJ = Character.toLowerCase(s.charAt(j));
            if(vowel.contains(curCharAtI) && vowel.contains(curCharAtJ)) {
                // swap
                char tmp = s.charAt(i);
                str.setCharAt(i, s.charAt(j));
                str.setCharAt(j, tmp);
                i++; j--;
            } else if(!vowel.contains(curCharAtI) && vowel.contains(curCharAtJ)) {
                i++;
            } else if(vowel.contains(curCharAtI) && !vowel.contains(curCharAtJ)) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return str.toString();
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use boolean vowel[] array of 128 to store all ASCII characters
    // Set char c : "aeiouAEIOU".toCharArray() & check vowel[] to true at each char
    // Index i=0, j=len-1, Loop with i<j, 1st inner loop -> increment i till vowels[cs[i]] is vowel
    // 2nd inner loop -> decrement j till vowels[cs[j]] is vowel
    // Check if i<j => swap location in cs[] & i++, j--
    // Out of loop, return String.valueOf(cs)
    // Runtime  : 2ms          -> + 99.32%
    // Memory   : 45.21MB      -> + 15.38%
    public static String reverseVowels2(String s) {
        boolean[] vowels = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            // 'a' is 97, 'A' is 65
            vowels[c] = true;
        }

        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while(i < j) {
            // increment i till s.at(i) is vowel
            while(i<j && !vowels[cs[i]]) {
                ++i;
            }

            // decrement j till s.at(j) is vowel
            while(i<j && !vowels[cs[j]]) {
                --j;
            }

            // check & swap
            if(i < j) {
                char tmp = s.charAt(i);
                cs[i] = s.charAt(j);
                cs[j] = tmp;
                i++; j--;
            }
        }

        return String.valueOf(cs);
    }
    //  ***************** End of 2nd Method ******************

}
