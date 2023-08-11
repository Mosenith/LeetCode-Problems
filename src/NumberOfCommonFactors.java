public class NumberOfCommonFactors {
    public static void main(String[] args) {
        int a = 12, b = 6; // out 4 <= 1,2,3,6

//        int a = 25, b = 30; // out 2 <= 1,5

        System.out.println(commonFactors(a,b));
    }

    // ***************** 1st Method : InOrder Traversal ******************
    // Approach : Get the smallest between a&b
    // loop and find common divisor from 1 to min(a,b)
    // Runtime  : 0ms           -> + 100%
    // Memory   : 39.15 MB      -> + 76.00%%
    public static int commonFactors(int a, int b) {
        int comm = 0;
        int divisor = (a < b) ? a : b;
        for(int i=1; i<=divisor; i++) {
            if(a % i == 0 && b % i == 0) {
                comm++;
            }
        }
        return comm;
    }
    //  ***************** End of 1st Method ******************
}
