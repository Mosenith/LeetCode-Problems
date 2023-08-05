package Blind75;

import javax.management.StandardEmitterMBean;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    // ***************** 1st Method ******************
    // Runtime  : 13ms        -> + 24.82%
    // Memory   : 44.1MB      -> + 24.72%
    public static int lengthOfLongestSubstring(String s) {
        int out = 0;
        int count = 0;
        List<String> store = new ArrayList<String>();


        for(int i=0; i<s.length(); i++){
            String curr = String.valueOf(s.charAt(i));
            int curr_index = store.indexOf(curr);

            if(!store.contains(curr)){
                store.add(curr);
                count++;
            } else {

                int leftLength = s.length() - curr_index + 1;
                if(leftLength > count){
                    if(count > out){
                        out = count;
                    }

                    if(curr_index == store.size()-1){
                        // duplicated letter is the last one in the List
                        store = new ArrayList<>();
                        store.add(curr);
                        count = 1;
                    } else {
                        for(int j=curr_index; j>=0; j--){
                            store.remove(j);
                            count--;
                        }

                        store.add(curr);
                        count++;
                    }
                } else {
                    break;
                }

            }

        }
        return Math.max(out, count);
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Use Set to store each char of s & loop j=0 to s.len
    // if charAt(j) exist in set -> remove all dups & i++
    // add charAt(j) and maxLen = max(maxLen, j-i+1)
    // Runtime  : 7ms        -> + 73.25%
    // Memory   : 43.8MB      -> + 55.42%
    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> ss = new HashSet<>();
        int i = 0, ans = 0;
        for (int j = 0; j < s.length(); ++j) {
            char c = s.charAt(j);
            System.out.println("Cur Char -> " + c);
            while (ss.contains(c)) {
                ss.remove(s.charAt(i++));
                System.out.println("After remove -> " + ss);
            }
            ss.add(c);
            System.out.println(ans + " : " + (j - i + 1));
            ans = Math.max(ans, j - i + 1);

            System.out.println("ss -> " + ss);
            System.out.println("************************************");
        }
        return ans;
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach : Use HashMap map - Key -> Char, Value -> Position of Char
    // loop i=0 -> s.len, if map !containKey, put(char,pos)
    // if charAt(i) exist in map -> j=max(j,map.get(s.charAt(i))+1)
    // maxLen = max(maxLen, j-i+1)
    // Runtime  : 7ms        -> + 73.25%
    // Memory   : 43.8MB      -> + 55.42%
    public static int lengthOfLongestSubstring3(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                // j is updated, start from new j and continue till s.len
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
    // ***************** End of 3rd Method ******************

    public static void main(String[] args) {
        String wd = "jessica";
        // abcabcbb
        // abcdvdf
        // uqinntq
        // sjyzaeahyh
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3("uqinntq"));
    }
}


