import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        System.out.println(shortestDistance(words, "makes", "coding"));
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();


        for(int i=0; i<words.length; i++) {
            if(word1.equals(words[i])) {
                l1.add(i);
            }

            if(word2.equals(words[i])) {
                l2.add(i);
            }
        }

        System.out.println(l1);
        System.out.println(l2);

        return 0;
    }
}
