import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "ab";

        System.out.println(canConstruct2(ransomNote, magazine));
    }

    // ***************** 2nd Method ******************
    // Approach 2: Use HashMap to store char in magazine
    // Check map with each char in ransomNote
    // If char not exist or =0 in map => false, otherwise true
    // Runtime  : 22ms       -> + 10.77%
    // Memory   : 45.06MB    -> + 17.02%
    public static boolean canConstruct2(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) return false;

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<magazine.length(); i++) {
            map.computeIfPresent(magazine.charAt(i), (k,v) -> v+1);
            map.computeIfAbsent(magazine.charAt(i), v -> 1);
        }

        for(int i=0; i<ransomNote.length(); i++) {
            if(!map.containsKey(ransomNote.charAt(i)) || map.get(ransomNote.charAt(i)) == 0) {
                return false;
            }

            map.computeIfPresent(ransomNote.charAt(i), (k,v) -> v-1);
        }
        return true;
    }
    //  ***************** End of 2nd Method ******************

}
