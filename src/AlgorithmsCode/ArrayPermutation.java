package AlgorithmsCode;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {
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


    public static void main(String[] args) {
//        String[] words = {"bar","foo","the"};
        String[] words = {"foo","bar"};
        int len = words.length;

        List<String> mixWords = permute(words);
        System.out.println(mixWords);

        List<String> finalAns = new ArrayList<>();
        for(int i=0; i<mixWords.size();) {
            int count = 0;
            String str = "";
            while(count < len && i < mixWords.size()) {
                str += mixWords.get(i++);
                count++;
            }
            finalAns.add(str);
        }

        System.out.println(finalAns);
    }
}
