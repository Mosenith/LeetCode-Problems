import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
    public static void main(String[] args) {

    }

    // ***************** 1st Method ******************
    // Approach 1: Have an m=int[26] (store s in char)
    // Check each char in t with m, if not exists, return that char
    // Runtime  : 2ms          -> + 69.33%
    // Memory   : 41.32MB      -> + 45.56%
    public char findTheDifference(String s, String t) {
        int[] store = new int[26];

        for (char c : s.toCharArray()) {
            store[c - 'a'] += 1;
        }

        // char res = '\0';
        for (char c : t.toCharArray()) {
            if (store[c - 'a'] == 0) {
                return c;
            }
            store[c - 'a'] -= 1;
        }

        return '\0';
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use HashMap
    // Runtime  : 11ms       -> + 16.96%
    // Memory   : 41.72MB    -> + 24.41%
    public char findTheDifference2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.computeIfPresent(c, (k, v) -> v + 1);
            map.computeIfAbsent(c, v -> 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return c;
            }
            map.computeIfPresent(c, (k, v) -> v - 1);
        }
        return '\0';
    }
    //  ***************** End of 2nd Method ******************

}