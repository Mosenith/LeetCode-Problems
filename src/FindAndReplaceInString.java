import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {
    public static void main(String[] args) {
        String s = "eqfvuokjvnlkyrgdnzem"; // eeebffff
        int[] indices = {13,0,8,2,4,16};
        String[] sources = {"rgd","eq","vnlky","fv","uo","nze"};
        String[] targets = {"bmx","skn","ckcw","xso","c","sbmo"};

        System.out.println(findReplaceString(s,indices,sources,targets));
    }
    // ***************** 1st Method ******************
    // Approach 1: Use array d[] to store the location of indices where sources exist in s
    // So if d[i]>=0, we need to append target to ans
    // Otherwise, just add char in s to ans
    // Runtime  : 1ms           -> + 100.00%
    // Memory   : 42.26MB       -> + 71.83%
    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        var d = new int[n];
        Arrays.fill(d, -1);

        // compare source to s whether the start of char in source exist at i-th index or not
        // If so, set d[i] to curIndex within indices[]
        for (int k = 0; k < indices.length; ++k) {
            int i = indices[k];
            System.out.println(sources[k] + " ; " + i);
            if (s.startsWith(sources[k], i)) {
                System.out.println("Yes at i=" + i);
                d[i] = k;
            }
        }

        System.out.println(Arrays.toString(d));

        var ans = new StringBuilder();

        // loop from 0 to s.len
        // if d[i] >= 0, ans.append targets[d[i]], then i +=  sources[d[i]].length()
        // Otherwise, ans.append s.at(i++)
        for (int i = 0; i < n;) {
            if (d[i] >= 0) {
                ans.append(targets[d[i]]);
                i += sources[d[i]].length();
            } else {
                ans.append(s.charAt(i++));
            }
        }

        return ans.toString();
    }
    //  ***************** End of 1st Method ******************

}
