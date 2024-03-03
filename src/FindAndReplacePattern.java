import java.util.*;

public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";

        System.out.println(findAndReplacePattern(words,pattern));
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

}
