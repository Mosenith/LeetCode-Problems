import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExpressiveWords {
    public static void main(String[] args) {
//        String s = "zzzzzyyyyy";
//        String[] words = {"zzyy","zy","zyy"};

//        String s = "heeellooo"; // s > words
//        String[] words = {"hello", "hi", "helo"};

        String s = "heeelllooo";  // <= i
        String[] words = {"hellllo"};

        System.out.println(expressiveWords(s,words));
    }

    // try 2 pointers -> i for s, j for words[i]
    // when s[i] != w[j], move j++. Otherwise, move i++;
    // keep track of dup cos if i moves & j moves but dup < 3 => no count
    public static int expressiveWords(String s, String[] words) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int dup = 0;

        for(int i=0; i<s.length()-1; i++) {
            while (i < s.length() -1 && s.charAt(i) == s.charAt(i+1)) {
                dup++;
                i++;
            }

            if(dup <= 1) {
                set.add(s.charAt(i));
            } else {
                map.put(s.charAt(i), dup+1);
            }

            dup = 0;
        }

        // s = heeelllooo
        System.out.println(set);
        System.out.println(map);

        for(String str : words) {
            if(str.length() > s.length()) continue;
            int i = 0; // s
            int j = 0; // str
            System.out.println(str + " vs " + s);
            for(; j<str.length(); j++) {
                System.out.println("---" + str.charAt(j) + "---");
                System.out.println("Start j = " + j + " and i = " + i);
                if(set.contains(str.charAt(j))) {
                    if(str.charAt(j) != s.charAt(i)) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    int prev = i;
                    while(i < s.length() && str.charAt(j) == s.charAt(i)) {
                        i++;
                    }
                    System.out.println("j=" + j + " && prev=" + prev);
                    System.out.println(i-prev + " vs " + map.get(s.charAt(prev)));

                    int tmp = j;
                    while(j< str.length() && str.charAt(j) == s.charAt(prev)) {
                        j++;
                    }

                    System.out.println("\n===== tmp = " + tmp + ", j = " + j);
                    System.out.println("===== j - tmp = " + (j-tmp));
                    if((j-prev) > map.get(s.charAt(prev))) {
                        break;
                    }
                    i++;
                    System.out.println(i + " : " + j);
                    System.out.println("#ocurrance of " + str.charAt(j) + " = " + (i-prev));
                }
                System.out.println("End j = " + j);
                System.out.println("~~~~~~~\n");
            }

            if(j >= str.length() && i >= s.length()) {
                count++;
            }
            System.out.println("======\n");
        }

        return count;
    }
}
