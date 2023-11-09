import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        // "dog cat cat dog"

        System.out.println(wordPattern(pattern,s));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> rMap = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();

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
}
