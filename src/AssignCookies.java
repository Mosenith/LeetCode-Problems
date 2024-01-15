import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};

        System.out.println(findContentChildren(g,s));
    }

    // ***************** 1st Method ******************
    // Approach 1: Sort both arrays and loop through i-g, j-s
    // Increment contentChild only when g[i] <= s[j] & then i++
    // At each iteration, j++ and out of loop return contentChild
    // Runtime  : 9ms         -> + 81.08%
    // Memory   : 45.03MB     -> + 64.86%
    public static int findContentChildren(int[] g, int[] s) {
        // i-g, j-s
        int contentChild = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        for(int i=0, j=0; i<g.length && j<s.length;) {
            if(g[i] <= s[j]) {
                contentChild++;
                i++;
            }

            j++;
        }

        return contentChild;
    }
    //  ***************** End of 1st Method ******************

}
