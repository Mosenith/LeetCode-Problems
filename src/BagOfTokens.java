import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {
        int[] token = {71,55,82};
        int power = 54;

        System.out.println(bagOfTokensScore(token,power));
    }

    // ***************** 1st Method ******************
    // Approach 1: Sort array & use 2 pointers, set ans=0,
    // t=0 to keep track of #face-up we took and loop till i>j
    // If we can take face-up, t++, power-=token[i], then have ans = max(t,ans);
    // Else if t>0, take face-down & power+=token[j], t--.
    // Other than these cases, break;
    // Runtime  : 3ms           -> + 37.26%
    // Memory   : 42.63MB       -> + 57.01%
    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        int ans = 0, t = 0;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i++];
                ++t;
                ans = Math.max(ans, t);
            } else if (t > 0) {
                power += tokens[j--];
                --t;
            } else {
                break;
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************
}
