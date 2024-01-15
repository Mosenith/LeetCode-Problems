public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }

    // ***************** 1st Method ******************
    // Approach 1: Start from 0 and loop while step < n
    // Decrement n by ++step & return step after loop
    // Runtime  : 5ms         -> + 49.71%
    // Memory   : 41.07MB     -> + 19.19%
    public static int arrangeCoins(int n) {
        int step = 0;
        while(step < n) {
            n -= ++step;
        }
        return step;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach 2: Use 2 pointers - left & right (long) to find mid
    // Calculate sum if sum == n => return mid
    // If sum < n -> left = mid+1, sum > n -> right = mid-1
    // Out of loop => return left-1
    // Runtime  : 0ms       -> + 99.99%
    // Memory   : 40.84MB   -> + 32.02%
    public static int arrangeCoins2(int n) {
        long left = 0;
        long right = n;
        while(left <= right) {
            long middle = left +(right-left)/2;
            long sum = middle *(middle+1)/2;
            if(n == sum) {
                return (int) middle;
            }
            else if (n < sum) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return (int) left-1;
    }
    //  ***************** End of 2nd Method ******************
}
