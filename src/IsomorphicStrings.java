import java.util.*;

public class IsomorphicStrings {
    public static void main(String[] args) {
//        String s = "bbbaaaba", t = "aaabbbba";
//        String s = "badc", t = "baba";
        String s = "papap", t = "titii";

        System.out.println(isIsomorphic(s,t));
        System.out.println(isIsomorphic4(s,t));
    }
    // ***************** 1st Method ******************
    // Approach 1: Use 2 maps to keep track char in s & t
    // If mapST.containsKey(curS) && mapST.get(curS) != curT => false
    // If mapTS.containsKey(curT) && mapTS.get(curT) != curS => false
    // Otherwise, put (curS, curT) to mapST & (curT, curS) to mapTS
    // Return true
    // Runtime  : 25ms        -> + 8.49%
    // Memory   : 42.68MB     -> + 11.88%
    public static boolean isIsomorphic(String s, String t) {
        // (k,v) -> (s,t)
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char curS = s.charAt(i);
            char curT = t.charAt(i);

            if (mapST.containsKey(curS) && mapST.get(curS) != curT) {
                return false;
            }

            if(mapTS.containsKey(curT) && mapTS.get(curT) != curS) {
                return false;
            }

            mapST.put(curS,curT);
            mapTS.put(curT,curS);
        }
        return true;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use one map
    // Runtime  : 74ms        -> + 5.10%
    // Memory   : 41.90MB     -> + 24.64%
    public static boolean isIsomorphic2(String s, String t) {
        // s - t
        Map<Character,Character> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char curS = s.charAt(i);
            char curT = t.charAt(i);

            if ((map.containsKey(curS) && map.get(curS) != curT)
                    || (map.containsValue(curT) && !map.containsKey(curS))) {
                return false;
            }

            map.put(curS,curT);
        }

        return true;
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach 3: Use one map & compare string in the end
    // Runtime  : 18ms        -> + 19.01%
    // Memory   : 44.35MB     -> + 5.55%
    public static boolean isIsomorphic3(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        StringBuilder str = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                str.append(map.get(s.charAt(i)));
            } else if(map.containsValue(t.charAt(i))) {
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
                str.append(map.get(s.charAt(i)));
            }
        }

        return t.equals(str.toString());
    }
    // ***************** End of 3rd Method ******************

    // ***************** 4th Method ******************
    // Approach 4: Use 2 arrays with len 256 to keep track of s & t
    // Since s & t consist of any valid ascii character => 256
    // Each iteration if d1[a] != d2[b] => false
    // Otherwise, update d1[a] & d2[b] = i+1 (not i cos i can be 0)
    // Runtime  : 5ms        -> + 96.98%
    // Memory   : 42.50MB    -> + 14.20%
    public static boolean isIsomorphic4(String s, String t) {
        // s & t => consist of any valid ascii character
        int[] d1 = new int[256];
        int[] d2 = new int[256];
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            char a = s.charAt(i), b = t.charAt(i);

            if (d1[a] != d2[b]) {
                return false;
            }
            d1[a] = i + 1; // +1 not to overlap with i=0
            d2[b] = i + 1;
        }
        return true;
    }
    // ***************** End of 4th Method ******************

}
