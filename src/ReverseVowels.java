import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("Hello"));
    }

    public static String reverseVowels(String s) {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        StringBuilder str = new StringBuilder(s);
        for(int i=0,j=s.length()-1; i<j;) {
            char curCharAtI = s.charAt(i);
            char curCharAtJ = s.charAt(j);
            if(vowel.contains() && vowel.contains()) {
                // swap
                char tmp = s.charAt(i);
                str.setCharAt(i, s.charAt(j));
                str.setCharAt(j, tmp);
                i++; j--;
            } else if(!vowel.contains(s.charAt(i)) && vowel.contains(s.charAt(j))) {
                i++;
            } else if(vowel.contains(s.charAt(i)) && !vowel.contains(s.charAt(j))) {
                j--;
            } else {
                i++;
                j--;
            }
        }

        return str.toString();
    }
}
