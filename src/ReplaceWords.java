import java.util.*;

public class ReplaceWords {
    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";

        System.out.println(replaceWords(dictionary, sentence));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use map to store key-sentence[i], value-dictionary[i]
    // Split given sentence by " " and check with dict[i]
    // If sent[i] start with dict[i] AND map.isEmpty() or !map.containsKey(sent[i]) or
    // dict[i].len < (if existed key) previous value with same key (sent[i]), put in map
    // Go through split sent[i], if exist in map, get the value, otherwise append sent[i]
    // Runtime  : 30ms           -> + 51.59%
    // Memory   : 52.76MB        -> + 98.22%
    public static String replaceWords(List<String> dictionary, String sentence) {
        Map<String,String> map = new HashMap<>(); // key-sentence[i], value-dictionary[i]
        String[] splitSentence = sentence.split(" ");

        for(String dic : dictionary) {
            for(int i=0; i<splitSentence.length; i++) {
                if(splitSentence[i].startsWith(dic)) {
                    if(map.isEmpty() || !map.containsKey(splitSentence[i]) ||
                            (map.containsKey(splitSentence[i]) && map.get(splitSentence[i]).length() > dic.length())) {
                        map.put(splitSentence[i], dic);
                    }
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for(String s : splitSentence) {
            str.append(map.getOrDefault(s, s) + " ");
        }

        return str.substring(0, str.length()-1);
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Similar approach to the 1st method but more organized and short
    // Runtime  : 700ms          -> + 12.74%
    // Memory   : 54.86MB        -> + 93.12%
    public static String replaceWords2(List<String> dictionary, String sentence) {
        Set<String> s = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            for (int j = 1; j <= word.length(); ++j) {
                String t = word.substring(0, j);
                if (s.contains(t)) {
                    words[i] = t;
                    break;
                }
            }
        }

        return String.join(" ", words);
    }
    //  ***************** End of 2nd Method ******************

}
