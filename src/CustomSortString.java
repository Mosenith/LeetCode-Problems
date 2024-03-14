import java.util.*;
import java.util.stream.Collectors;

public class CustomSortString {
    public static void main(String[] args) {
        // s = "abcabcd"
        String order = "cba", s = "abcd";

        System.out.println(customSortString2(order,s));
    }

    // ***************** 1st Method ******************
    // Approach 1: Read order to Set<Char> to use contains(obj) with s
    // Read chars in s to map with k-s.charAt(i), v-s.charAt(i) occurrence
    // while checking if it exists in orderSet. If not get it to another map
    // Loop through charArray of order, if existMap has order[i], append to ans till occurrence=0 then remove it
    // Add the leftover of nonExistMap to ans
    // Runtime  : 4ms          -> + 28.59%
    // Memory   : 41.34MB      -> + 65.54%
    public static String customSortString(String order, String s) {
        char[] orderArray = order.toCharArray();
        Set<Character> orderSet = new HashSet<>();

        for(char c : orderArray) {
            orderSet.add(c);
        }


        Map<Character,Integer> existMap = new HashMap<>();
        Map<Character,Integer> nonExistMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(orderSet.contains(c)) {
                existMap.put(c,existMap.getOrDefault(c,0)+1);
            } else {
                nonExistMap.put(c,nonExistMap.getOrDefault(c,0)+1);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i=0; i<orderArray.length && !existMap.isEmpty(); i++) {
            char cur = orderArray[i];
            if(existMap.containsKey(cur)) {
                while(existMap.get(cur) >= 1) {
                    ans.append(cur);
                    existMap.put(cur,existMap.getOrDefault(cur,0)-1);
                }
                existMap.remove(cur);
            }
        }

        for(Character c : nonExistMap.keySet()) {
            while(nonExistMap.get(c) >= 1) {
                ans.append(c);
                nonExistMap.put(c, nonExistMap.get(c)-1);
            }
        }

        return ans.toString();
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method : short but take time ******************
    // Approach 2: Map char in cs with lower frequency in d[] will appear first
    // The none exist in cs will appear last
    // Runtime  : 6ms           -> + 17.93%
    // Memory   : 41.90MB       -> + 24.07%
    public static String customSortString2(String order, String s) {
        int[] d = new int[26];
        for (int i=0; i<order.length(); ++i) {
            d[order.charAt(i) - 'a'] = i;
        }

        List<Character> cs = new ArrayList<>();
        for (int i=0; i<s.length(); ++i) {
            cs.add(s.charAt(i));
        }

        cs.sort(Comparator.comparingInt(a -> d[a - 'a']));
        return cs.stream().map(String::valueOf).collect(Collectors.joining());
    }
    //  ***************** End of 2nd Method ******************

}
