import java.util.Arrays;

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if(s.length() > p.length()) return false;
        int i=0;        // index

        for(; i<s.length(); i++) {
            String sCurrent = String.valueOf(s.charAt(i));
            String pCurrent = String.valueOf(p.charAt(i));
            if(!sCurrent.equals(pCurrent) && pCurrent.equals(".") && pCurrent.equals("*")) {
                return false;
            }
        }

        if(i <= p.length()) {
            while (i < p.length()) {
                System.out.println(i);
                if(!String.valueOf(p.charAt(i)).equals(".") && !String.valueOf(p.charAt(i)).equals("*")) {
                    return false;
                }
                i++;
            }

        }
        return true;
    }

    public static boolean isMatch2(String s, String p) {
        //if(s.length() > p.length()) return false;

        int i=0;        // String s : index
        int j=0;        // String p : index

       while (j < p.length() && i < s.length()) {
           String sCurrent = String.valueOf(s.charAt(i));
           String pCurrent = String.valueOf(p.charAt(j));

           System.out.println("Start -> i: " + i + ", j: " + j);
           // * case
           if(String.valueOf(p.charAt(j)).equals("*")) {
               // System.out.println("Alpha before " + p.charAt(j-1));
               if(!sCurrent.equals(String.valueOf(p.charAt(j-1))) && !sCurrent.equals(".")){
                   if(j == p.length() - 1) return false;
                   // p(j) not match s(i) and not '.' and end of p
               } else {
                   // p(j)= *; p(j-1) match s(i) -> move to next index
                   System.out.println("* case match");
                   i++;
               }
               j++;     // p(j) not match s(i), check the next index
               continue;
           }

           // same alphabet
           if(sCurrent.equals(pCurrent)){
               System.out.println("same alphabet");
               i++;
           }
           j++;
           //System.out.println("END i: " + i + ", j: " + j);

           if(i < s.length() && j == p.length()) {
               System.out.println("Here");
               return false;
           }
           continue;
       }


       return true;
    }

    public static void main(String[] args) {
        String s1 = "aa", p1 = "a";         // false
        String s2 = "aa", p2 = "a*";        // true
        String s3 = "ab", p3 = ".*";        // true
        String s4 = "aab", p4 = "c*a*b";    // true
        String s5 = "ab", p5 = ".*c";       // false

        //System.out.println(isMatch(s1,p1));
        System.out.println(isMatch2(s3,p3));
    }
}

