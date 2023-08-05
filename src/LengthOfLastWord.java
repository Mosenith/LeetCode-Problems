public class LengthOfLastWord {
    // ***************** 1st Method ******************
    // Approach : Check From the Right -> Left
    // Runtime  : 0ms        -> + 100%
    // Memory   : 40.8MB      -> + 77.39%
    public static int lengthOfLastWord(String s) {
        int len = 0;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) != ' ') {
                len++;
            } else {
                if(len != 0)
                    break;
            }
        }
        return len;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Use Index to check
    // Runtime  : 0ms        -> + 100%
    // Memory   : 40.6MB      -> + 94.44%
    public static int lengthOfLastWord2(String s) {
        int i = s.length() - 1;

        // break when reach first letter from right
        while (i >= 0 && s.charAt(i) == ' ') {
            --i;
        }
        System.out.println("i = " + i);

        int j = i;
        // break when reach first blank space from previous i position
        while (j >= 0 && s.charAt(j) != ' ') {
            --j;
        }
        System.out.println("j = " + j);

        return i - j;
    }
    //  ***************** End of 2nd Method ******************

    public static void main(String[] args) {
        String s = "Hello World"; // 5
        String s2 = "   fly me   to   the moon  ";  // 4
        String s3 = "luffy is still joyboy";    // 6

        System.out.println(s3.length());
//        System.out.println(s.substring(s.length()-2));
        System.out.println(lengthOfLastWord2(s3));
    }
}
