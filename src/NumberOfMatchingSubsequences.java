import java.util.*;

public class NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};

        System.out.println(numMatchingSubseq(s,words));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Array of Deque<String> & initially assign to empty []
    // In charArray of s, get var tmp = deques[c-'a']
    // Then loop till k=tmp.size < 0, Poll one by one from tmp (String t = tmp.pollFirst())
    // If t.len = 1, increment the count, otherwise, remove the 0th index & add t.subString(1) to deque
    // Runtime  : 54ms        -> + 76.32%
    // Memory   : 47.15MB     -> + 41.23%
    public static int numMatchingSubseq(String s, String[] words) {
        Deque<String>[] deques = new Deque[26];
        Arrays.setAll(deques, k -> new ArrayDeque<>()); // instead of null, set it to ArrayDeque() instance

        for (String w : words) {
            // map first char into Deque
            deques[w.charAt(0) - 'a'].add(w);
        }

        int ans = 0;
        for (char c : s.toCharArray()) {
            var tmp = deques[c - 'a'];
            for (int k = tmp.size(); k > 0; --k) {
                String t = tmp.pollFirst(); // poll one by one from deque
                if (t.length() == 1) {
                    // only 1 char => is sub seq
                    ++ans;
                } else {
                    // add the leftover substring from index 1
                    deques[t.charAt(1) - 'a'].offer(t.substring(1));
                }
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************

}
