public class FractionAdditionAndSubtraction {
    public static void main(String[] args) {
        String expression = "-1/6+2/9+3/7-5/9+3/10";

        System.out.println(fractionAddition(expression));
    }

    // ***************** 1st Method ******************
    // Approach 1: Loop through each char in expression
    // init t = 0, b = 0, which are top and bottom of the fraction
    // Get top by loop until '/', Get bottom by loop until '-' or '+'
    // Check if t == 0 && b == 0, assign t = top, b = bottom
    // If not then check if b == bottom, add top to t, make irreducible fraction
    // Otherwise, add top*bottom to t, make irreducible fraction
    // Runtime  : 7ms        -> + 53.57%
    // Memory   : 41.86MB    -> + 59.82%
    public static String fractionAddition(String expression) {
        char[] c = expression.toCharArray();
        int len = c.length;
        int t = 0, b = 0;
        for(int i=0; i<len;) {
            // get top
            StringBuilder top = new StringBuilder();
            while(i<len && c[i] != '/') {
                top.append(c[i]);
                i++;
            }
            i++;
            // get bottom
            StringBuilder bot = new StringBuilder();
            while(i<len && (c[i] != '-' && c[i] != '+')) {
                bot.append(c[i]);
                i++;
            }

            int tmpTop = Integer.parseInt(String.valueOf(top));
            int tmpBot = Integer.parseInt(String.valueOf(bot));

            if(t == 0 && b == 0) {
                t = tmpTop;
                b = tmpBot;
            } else {
                if(b == tmpBot) {
                    t += tmpTop;
                    b = (t == 0) ? 1 : b;
                    int[] arr = makeIrreducibleFraction(t,b);
                    t = arr[0];
                    b = arr[1];
                } else {
                    int[] arr = makeIrreducibleFraction((t*tmpBot)+(tmpTop*b), b*tmpBot);
                    t = arr[0];
                    b = arr[1];
                }
            }
        }
        return String.format(t + "/" + b);
    }

    private static int[] makeIrreducibleFraction(int t, int b) {
        if(Math.abs(t) == 1 || Math.abs(b)  == 1) {
            return new int[]{t,b};
        }

        if(t % b == 0) return new int[]{t/b,1};
        if(b % t == 0) return new int[]{1,b/t};
        int min = Math.min(Math.abs(t), Math.abs(b));
        for(int i=2; i<=Math.sqrt(min); i++) {
            while(t % i == 0 && b % i == 0) {
                t /= i;
                b /= i;
            }
            if(t == 1 || b == 1) {
                break;
            }
        }

        if(b < 0) {
            b *= -1;
            t *= -1;
        }

        return new int[]{t,b};
    }
    // ***************** End of 1st Method ******************

}