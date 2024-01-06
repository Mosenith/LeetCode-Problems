public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
    public static boolean isBadVersion(int k) {
        if(k == 4) return false;

        return true;
    }

    // ***************** 1st Method ******************
    // Approach 1: Using Merge Sort approach to find bad value
    // Runtime  : 0ms         -> + 100.00%
    // Memory   : 40.46MB     -> + 24.53%
    public static int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    //  ***************** End of 1st Method ******************

}
