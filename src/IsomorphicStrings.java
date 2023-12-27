import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
//        String s = "bbbaaaba", t = "aaabbbba";
        String s = "badc", t = "baba";

        System.out.println(isIsomorphic(s,t));
    }
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

        System.out.println(mapST);
        System.out.println(mapTS);

        return true;
    }
}
