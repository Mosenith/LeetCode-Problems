import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";

        System.out.println(frequencySort(s));
    }
    public static String frequencySort(String s) {
        int[] alpha = new int[126];
        Map<Integer,List<Character>> map = new HashMap<>();
        List<Integer> countList = new ArrayList<>();

        for(char c : s.toCharArray()) {
            System.out.println(c);
            ++alpha[c - 'A'];
        }

//        System.out.println(map);
        System.out.println(Arrays.toString(alpha));

        return "";
    }
}
