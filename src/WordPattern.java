import java.util.*;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        // "dog cat cat dog"

        System.out.println(wordPattern(pattern,s));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use 2 Maps to store char => String && String => char
    // Use Queue to store all words in s split by space
    // If map not contain pattern.at(i) = c -> check if rMap.contain(str) && rMap(str) != c, return false
    // If map not contain pattern.at(i) = c -> !map.get(c).equals(queue.peek()) => return false
    // Otherwise pop queue and move on
    // Queue.size == map.size, if not return false
    // Runtime  : 1ms            -> + 83.64%
    // Memory   : 40.25MB        -> + 65.17%
    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> rMap = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();

        // Could use this ==> String[] words = s.split(" ") && add to queue
        // But take more space
        for(int i=0; i<s.length(); ) {
            int count = i;
            while(count < s.length() && s.charAt(count) != ' ') {
                count++;
            }

            queue.add(s.substring(i,count));
            i = count + 1;
        }

        if(queue.size() != pattern.length()) return false;

        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(map.isEmpty() || !map.containsKey(c)) {
                String tmp = queue.poll();
                if(rMap.containsKey(tmp) && rMap.get(tmp) != c) {
                    return false;
                }

                map.put(c,tmp);
                rMap.put(tmp,c);
            } else {
                if(!map.get(c).equals(queue.peek())) {
                    return false;
                }
                queue.poll();
            }
        }

        return true;
    }
    // ***************** End of 1st Method ******************


    // ***************** 2nd Method ******************
    // Approach 2: Short version of the 1st Approach
    // Runtime  : 1ms            -> + 83.64%
    // Memory   : 40.51MB        -> + 25.29%
    public static boolean wordPattern2(String pattern, String s) {
        String[] sarr = s.split(" ");
        int len = pattern.length();
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        if(len != sarr.length) return false;

        for(int i=0; i<len; i++){
            char c = pattern.charAt(i);
            String word = sarr[i];
            if(!map.containsKey(c)){
                if(set.contains(word)) return false;
                map.put(c, word);
                set.add(word);
            }else{
                if(!map.get(c).equals(word)){
                    return false;
                }
            }
        }

        return true;
    }
    // ***************** End of 2nd Method ******************

}
