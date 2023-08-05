import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    //    ***************** 1st Method ******************
    // Exceed Memory Limit
    // Not a bad learning though!
    public static List<Integer> findSubstring(String s, String[] words) {
        List<String> allConcatInWords = cocatWordList(permute(words), words.length);
        System.out.println(allConcatInWords);
        List<Integer> out = new ArrayList<>();
        int substringLen = words.length * words[0].length();

        for(int i=0; i<s.length() && i+substringLen<=s.length();) {
//            List<String> wordsList = Arrays.asList(words);
            String currentSub = s.substring(i,i+substringLen);
            System.out.println(currentSub.length());
            System.out.println("currentSub = " + currentSub);

            if(allConcatInWords.contains(currentSub)) {
                out.add(i);
            }

            i += (words[0].length()-1);
        }

//        lingmindraboofooowing
//        dingbarrwingmonkeypoundcake

        return out;
    }

    public static List<String> permute (String[] words) {
        List<String> ans = new ArrayList<>();
        recurPermute(0,words,ans);
        return ans;
    }
    public static void recurPermute(int index, String[] current, List<String> answer) {
        //base case
        if(index == current.length) {
            for(int i=0; i<current.length; i++) {
                answer.add(current[i]);
            }
            return;
        }

        for (int i = index; i < current.length; i++) {
            swap(i, index, current);
            recurPermute(index + 1, current, answer);
            swap(i, index, current);
        }
    }

    private static void swap(int i, int j, String[] words) {
        String t = words[i];
        words[i] = words[j];
        words[j] = t;
    }

    private static List<String> cocatWordList (List<String> list, int len) {
        List<String> finalAns = new ArrayList<>();
        for(int i=0; i<list.size();) {
            int count = 0;
            String str = "";
            while(count < len && i < list.size()) {
                str += list.get(i++);
                count++;
            }
            finalAns.add(str);
        }

        return finalAns;
    }
    //  ***************** End of 1st Method ******************

    //    ***************** 2nd Method ******************
    // Runtime  : 9ms        -> + 97.38%
    // Memory   : 43.3MB      -> + 48.90%
    public static List<Integer> findSubstring2(String s, String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String w : words) {
            cnt.put(w, cnt.getOrDefault(w, 0) + 1);
        }
        System.out.println(cnt.toString());
        System.out.println(s);
        int subLen = words[0].length();
        int n = s.length(), m = words.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < subLen; ++i) {
            Map<String, Integer> cnt1 = new HashMap<>();
            int l = i, r = i;
            int t = 0;
            while (r + subLen <= n) {
                String w = s.substring(r, r + subLen);
                System.out.println(w);
                r += subLen;
                if (!cnt.containsKey(w)) {
                    l = r;
                    cnt1.clear();
                    t = 0;
                    continue;
                }
                cnt1.put(w, cnt1.getOrDefault(w, 0) + 1);
                ++t;
                while (cnt1.get(w) > cnt.get(w)) {
                    String remove = s.substring(l, l + subLen);
                    l += subLen;
                    cnt1.put(remove, cnt1.get(remove) - 1);
                    --t;
                }
                if (m == t) {
                    ans.add(l);
                }
            }
        }
        return ans;
    }
    //  ***************** End of 2nd Method ******************
    public static void main(String[] args) {
        // output [0,9] or [9,0]
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};

        // output [6, 9, 12]
//        String s = "barfoofoobarthefoobarman";
//        String[] words = {"bar","foo","the"};

        // output []
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word","good","best","word"};
//
//        System.out.println(findSubstring(s,words));

        // output [13]
//        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
//        String[] words = {"fooo","barr","wing","ding","wing"};

        System.out.println(findSubstring2(s,words));
//        System.out.println(s.substring(13,33));
    }
}

// fooowingdingbarrwing
// fooowingdingbarrwing