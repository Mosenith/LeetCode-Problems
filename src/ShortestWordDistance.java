import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistance {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        System.out.println(shortestDistance(words, "makes", "coding"));
    }

    // ***************** 1st Method : Locked Prob ******************
    // Approach 1: Using 2 index to keep track of word1 & word2 location
    // By letting w1 = -1, w2 = -1 and within iteration if both change,
    // Calculate minDis = Math.min(minDis, Math.abs(w1-w2))
    // Initial minDis = MAX_VALUE
    public static int shortestDistance(String[] words, String word1, String word2) {
        int minDis = Integer.MAX_VALUE;
        int w1 = -1, w2 = -1;

        for(int i=0; i<words.length; i++) {
            if(word1.equals(words[i])) {
                w1 = i;
            }

            if(word2.equals(words[i])) {
                w2 = i;
            }

            if(w1 != -1 && w2 != -1) {
                minDis = Math.min(minDis, Math.abs(w1-w2));
            }
        }

        return minDis;
    }
    // ***************** End of 1st Method ******************
}
