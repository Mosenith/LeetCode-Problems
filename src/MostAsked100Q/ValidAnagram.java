package MostAsked100Q;

import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        System.out.println(isAnagram2(s,t));
    }
    // ***************** 1st Method : HashMap ******************
    // Approach 1: Use Queue - Take too much time & space to use contains()
    // Runtime  : 3ms           -> + 99.83%
    // Memory   : 56.49 MB      -> + 77.75%
    // Time : O(n), Space: O(1), Each loop is O(n/2) ~= O(n)
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
    // Approach :
    // Runtime  : 0ms           -> + 100%
    // Memory   : 43.80 MB      -> + 35.32%
    // Time : O(n), Space: O(1)
    public static boolean isAnagram2(String s, String t) {
        HashMap<Integer, Character> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            map.put(i, s.charAt(i));
        }

//        Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) map.entrySet();


        for(int i=0; i<t.length(); i++) {
            char cur = t.charAt(i);
            if(!map.containsValue(cur))
                return false;

            map.values().remove(cur);
        }

        return map.isEmpty();
    }
}

