public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        int[] arr = {2,6,4,1};

        System.out.println(threeConsecutiveOdds(arr));
    }

    // ***************** 1st Method ******************
    // Approach 1: Iterate through arr but check condition for i+3<=arr.length
    // If arr[i] is even, continue. Otherwise, check if arr[i+1] and arr[i+2] are odd
    // If true, return true. Out of loop, return false.
    // Runtime  : 0ms      -> + 100.00%
    // Memory   : 42.22MB   -> + 27.82%
    public static boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0; i+3<=arr.length; i++) {
            if(arr[i] % 2 == 0) continue;
            if(arr[i+1] % 2 != 0 && arr[i+2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }
    //  ***************** End of 1st Method ******************
}
