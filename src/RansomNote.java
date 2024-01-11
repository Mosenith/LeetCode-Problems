import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "ab";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    // ***************** 1st Method ******************
    // Approach 1: Convert both strings to charArray & have an m=int[26] (store magazine)
    // Check each char in ransomNote with m
    // If m[c-97] <= 0 => false, otherwise true
    // Runtime  : 1ms          -> + 99.21%
    // Memory   : 40.80MB      -> + 23.64%
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] m = new int[26];
        char[] magazineChar = magazine.toCharArray();
        char[] ransomNoteChar = ransomNote.toCharArray();

        for(char c : magazineChar) {
            m[c-97] += 1;
        }

        // OR char c : ransomNote.toCharArray()
        for(char c : ransomNoteChar) {
            if(m[c-97] <= 0) {
                return false;
            }
            m[c-97] -= 1;
        }
        return true;
    }
    //  ***************** End of 1st Method ******************

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
