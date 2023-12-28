import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
//        String s = "bbbaaaba", t = "aaabbbba";
        String s = "badc", t = "baba";
//        String s = "papap", t = "titii";

        System.out.println(isIsomorphic(s,t));
        System.out.println(isIsomorphic3(s,t));
    }
    // ***************** 1st Method ******************
    // Approach 1:
    // Runtime  : 22ms        -> + 12.97%
    // Memory   : 42.47MB     -> + 13.59%
    public static boolean isIsomorphic(String s, String t) {
        // (k,v) -> (s,t)
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char curS = s.charAt(i);
            char curT = t.charAt(i);

            if (mapST.containsKey(curS) && !mapTS.containsKey(curT) ||
                    !mapST.containsKey(curS) && mapTS.containsKey(curT)) {
                return false;
            }

            if(mapST.containsKey(curS) && mapTS.containsKey(curT)) {
                if(mapST.get(curS) != curT || mapTS.get(curT) != curS) {
                    return false;
                }
            } else {
                mapST.put(curS,curT);
                mapTS.put(curT,curS);
            }
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

            if ((map.containsKey(curS) && map.get(curS) != curT) || (map.containsValue(curT) && !map.containsKey(curS))) {
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
}
