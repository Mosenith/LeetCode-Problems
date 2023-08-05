package MostAsked100Q;

import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
//        String s = "rat", t = "car";

        System.out.println(isAnagram3(s,t));
    }
    // ***************** 1st Method : HashMap ******************
    // Approach 1: Use Queue - Take too much time & space to use contains()
    // Runtime  & Memory: Too slow & large
    public boolean isAnagram(String s, String t) {
        Queue<Character> queue = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++) {
            queue.add(s.charAt(i));
        }

        for(int i=0; i<t.length(); i++) {
            if(!queue.contains(t.charAt(i)))
                return false;
            queue.remove(t.charAt(i));
        }

        return queue.isEmpty();
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method : HashMap ******************
    // Approach : Use HashMap - containKey take less time than hashSet
    // Runtime  : 21ms           -> + 17.16%
    // Memory   : 43.70 MB      -> + 38.75%
    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            map.computeIfPresent(s.charAt(i), (key,val) -> val+1);
            map.computeIfAbsent(s.charAt(i), val -> 1);
        }

        for(int i=0; i<t.length(); i++) {
            char cur = t.charAt(i);
            if(!map.containsKey(cur) || map.containsKey(cur) && map.get(cur) < 1)
                return false;

            if(map.get(cur) == 1) {
                map.remove(cur);
            } else {
                map.computeIfPresent(cur, (key,val) -> val-1);
            }
        }

        return true;
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach : Use Array[26] - Loop each pos of s & t the same time
    // At i, Increment => ++arr[s(i) - 'a'], then decrement => --arr[t(i) - 'a']
    // Check arr if all pos = 0, if not return false
    // Runtime  : 21ms           -> + 17.16%
    // Memory   : 43.70 MB      -> + 38.75%
    // Time : O(n), Space: O(1)
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
            --cnt[t.charAt(i) - 'a'];
        }

        for (int i = 0; i < 26; ++i) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
    // ***************** End of 3rd Method ******************

    // ***************** 4th Method ******************
    // Approach : Sort String - Convert s & t to charArray
    // Sort both arrays and convert to String. Then, return compare equals()
    // Runtime  : 21ms           -> + 17.16%
    // Memory   : 43.70 MB      -> + 38.75%
    // Time : O(n), Space: O(1)
    public static boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        String sortedS = new String(sChars);
        String sortedT = new String(tChars);

        return sortedS.equals(sortedT);
    }
}

