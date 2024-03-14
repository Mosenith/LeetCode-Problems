import java.util.*;
import java.util.stream.Collectors;

public class CustomSortString {
    public static void main(String[] args) {
        // s = "abcabcd"
        String order = "cba", s = "abcd";

        System.out.println(customSortString3(order,s));
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

    // ***************** 3rd Method ******************
    // Approach 3: Count each char in both order & s => store its frequency in ss[] & orders[]
    // Chars of s -> orderss[], Char of order -> ss[]
    // Loop through each char of order while check if orderss[a-'a']>=1, append char to ans
    // Loop through each char of s while check if wordss[a-'a']=0, append char to ans
    // Runtime  : 0ms          -> + 100.00%
    // Memory   : 41.95MB      -> + 20.51%
    public static String customSortString3(String order, String s) {
        int [] orderss = new int[26];
        int [] wordss = new int[26];
        char [] ss = s.toCharArray();
        char [] orders = order.toCharArray();

        for(char i:ss) {
            orderss[i-'a']++;
        }
        for(char i:orders) {
            wordss[i-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(char a:orders) {
            for(int j=1;j<=orderss[a-'a'];j++) {
                sb.append(a);
            }
        }

        for(char a:ss) {
            if(wordss[a-'a']==0) {
                sb.append(a);
            }
        }
        return sb.toString();
    }
    //  ***************** End of 3rd Method ******************
}
