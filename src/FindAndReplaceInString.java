public class FindAndReplaceInString {
    public static void main(String[] args) {
        String s = "abcd"; // eeebffff
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder str = new StringBuilder();
        int index = 0, i = 0;

        while(index < s.length()) {
            // add remaining char in s to str
            while(indices[i] != index) {
               str.append(s.charAt(index++));
            }
            int end = sources[i].length();
            if(s.substring(index,end).equ)
            System.out.println();

            index += end;
        }

        return str.toString();
    }
}
