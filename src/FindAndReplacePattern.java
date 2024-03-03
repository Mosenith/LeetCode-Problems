import java.util.*;

public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";

        System.out.println(findAndReplacePattern2(words,pattern));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use hashmap to store pattern char and list of each char location
    // Loop through each word in words and compare word tmpMap with pattern map
    // Runtime  : 5ms           -> + 9.03%
    // Memory   : 43.64MB       -> + 5.84%
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            map.put(c, map.getOrDefault(c,new ArrayList<>()));
            map.get(c).add(i);
        }

        for(String w : words) {
            Map<Character, List<Integer>> tmp = new HashMap<>();
            char[] c = w.toCharArray();
            for(int i=0; i<c.length; i++) {
                tmp.put(c[i], tmp.getOrDefault(c[i], new ArrayList<>()));
                tmp.get(c[i]).add(i);
            }
            if(tmp.size() == map.size() && isMatch(map,tmp)) {
                // check list in map whether same size & element
                ans.add(w);
            }
        }
        return ans;
    }

    private static boolean isMatch(Map<Character, List<Integer>> map, Map<Character, List<Integer>> tmp) {
        if (map.size() != tmp.size()) { // Check for size mismatch
            return false;
        }

        Set<List<Integer>> mapValues = new HashSet<>(map.values()); // Ignore key order
        Set<List<Integer>> tmpValues = new HashSet<>(tmp.values());

        return mapValues.equals(tmpValues); // Compare List<Integer> contents regardless of key order
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Check every word with pattern by comparing 2 arrays of size 128 to store each char i+1 pos
    // if m1[w] != m2[p], return false. Otherwise, update both m1[w] & m2[p] to i+1
    // Runtime  : 1ms        -> + 74.34%
    // Memory   : 42.79MB    -> + 17.34%
    public static List<String> findAndReplacePattern2(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (checkPattern(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private static boolean checkPattern(String word, String pattern) {
        int[] m1 = new int[128]; // store #char of word
        int[] m2 = new int[128]; // store #char of pattern

        for(int i=0; i<pattern.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            // 'a' = 97th index, ...
            if(m1[w] != m2[p]) {
                return false;
            }
            m1[w] = i+1;
            m2[p] = i+1;
        }
        return true;
    }
    //  ***************** End of 2nd Method ******************
}
