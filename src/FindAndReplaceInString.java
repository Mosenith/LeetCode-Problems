import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {
    public static void main(String[] args) {
        // abcde
        String s = "abcde"; // eeebffff
        int[] indices = {2,2};
        String[] sources = {"cde","cdef"};
        String[] targets = {"fe","f"};

        System.out.println(findReplaceString(s,indices,sources,targets));
    }
    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder str = new StringBuilder();
        // index for moving along s to str, i for other arrays
        int index = 0, i = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int j=0; j<indices.length; j++) {
            map.put(indices[j], j);
        }
        Arrays.sort(indices);

        while(index < s.length() & i <indices.length) {
            // i uses with indices, others uses prePos
            int prePos = map.get(indices[i]);

            // add remaining char in s to str
            while(index < s.length() && indices[i] != index) {
                str.append(s.charAt(index++));
            }

            int end = index + sources[prePos].length();
            if(end > s.length()) {
                break;
            }

            // if not a substring of s, add org to str and continue
            if(!s.substring(index,end).equals(sources[prePos])) {
                str.append(s.substring(index,end));
                index = end;
                i++;
                continue;
            }

            // if is a substring of s, add the targets to str
            str.append(targets[prePos]);
            i++;
            index = end;
        }

        while(index < s.length()) {
            str.append(s.charAt(index++));
        }

        return str.toString();
    }
}
