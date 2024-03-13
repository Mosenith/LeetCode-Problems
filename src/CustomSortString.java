import java.util.*;

public class CustomSortString {
    public static void main(String[] args) {
        String order = "cba", s = "abcd";

        System.out.println(customSortString(order,s));
    }

    // s = "abcabcd"
    public static String customSortString(String order, String s) {
        Set<Character> orderSet = new HashSet<>();

        for(char c : order.toCharArray()) {
            orderSet.add(c);
        }
        System.out.println(orderSet);
        // read everything in s to map with k-s.charAt(i), v-s.charAt(i) occurrence while checking if it exist in orderSet
        // If not get it to another list or sth

        Map<Character,Integer> existChar = new HashMap<>();
        Map<Character,Integer> nonExistChar = new HashMap<>();

        for(char c : s.toCharArray()) {
            if(orderSet.contains(c)) {
                existChar.put(c,existChar.getOrDefault(c,0)+1);
            } else {
                nonExistChar.put(c,nonExistChar.getOrDefault(c,0)+1);
            }
        }

        System.out.println(existChar);
        System.out.println(nonExistChar);

        // Loop in orderArray, if charA in map set it to ans, then reduce it occurrence(>1) or remove it(==1)
        // Out of loop check map, if not empty, get all those keys to ans, doesn't matter about the order
        return "";
    }
}
