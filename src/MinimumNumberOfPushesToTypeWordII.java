import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWordII {
    public static void main(String[] args) {
        String word = "abcdfghijk";

        System.out.println(minimumPushes(word));
    }

    // ***************** 1st Method ******************
    // Approach 1: Count the frequency of each character in the word
    // Sort the frequency in ascending order
    // Loop through the frequency from 0, calculate the minimum pushes
    // Using formula i/8 + 1 to calculate the number of pushes
    // Then multiply with alpha[26-i-1] the number of pushes with the frequency of the character
    // Runtime  : 8ms      -> + 91.94%
    // Memory   : 45.54MB  -> + 64.49%
    public static int minimumPushes(String word) {
        int[] alpha = new int[26];
        char[] c = word.toCharArray();

        for (char value : c) {
            ++alpha[value - 'a'];
        }

        Arrays.sort(alpha);
        int ans = 0;
        for(int i=0; i<26; i++) {
            ans += (i/8 + 1) * alpha[26-i-1];
        }

        return ans;
    }
    //  ***************** End of 1st Method ******************
}
