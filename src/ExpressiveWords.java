import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExpressiveWords {
    public static void main(String[] args) {
//        String s = "zzzzzyyyyy";
//        String[] words = {"zzyy","zy","zyy"};

        String s = "heeellooo"; // s > words
        String[] words = {"hello", "hi", "helo"};

        System.out.println(expressiveWords(s,words));
    }

    // try 2 pointers -> i for s, j for words[i]
    // when s[i] != w[j], move j++. Otherwise, move i++;
    // keep track of dup cos if i moves & j moves but dup < 3 => no count
    public static int expressiveWords(String s, String[] words) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> stretchy = new HashMap<>();


        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            map.computeIfPresent(c, (k,v) -> v+1);
            map.computeIfAbsent(c, v -> 1);

            if(map.get(c) >= 3) {
                stretchy.put(c, map.get(c));
            }
        }

        System.out.println("Overall map = " + map);
        System.out.println("stretchy = " + stretchy);

        for(String str : words) {
            Map<Character, Integer> wMap = new HashMap<>();
            Set<Character> store = new HashSet<>();
            char[] wordArray = str.toCharArray();
            boolean flag = false;

            System.out.println("word = " + str);
            for(char c : wordArray) {
                System.out.println("char = " + c);
//                wMap.computeIfPresent(c, (k,v) -> v+1);
//                wMap.computeIfAbsent(c, v -> 1);

                if(!stretchy.containsKey(c)) {
                    wMap.computeIfPresent(c, (k,v) -> v+1);
                    wMap.computeIfAbsent(c, v -> 1);
                    store.add(c);
                }

//                if(!map.containsKey(c) || wMap.get(c) > map.get(c)) {
//                    System.out.println("Set flag ===> true");
//                    System.out.println(map.containsKey(c));
//                    System.out.println(wMap.get(c) + " vs " + map.get(c));
//                    flag = true;
//                    System.out.println("++++++\n");
//                }
            }

            System.out.println(str + " => " + wMap);


            if(wMap.size() <= map.size() && !flag)
                count++;
            System.out.println("***********");
        }

        return count;
    }
}
