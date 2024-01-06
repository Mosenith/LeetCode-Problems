public class FirstBadVersion {
    // No main() cos prob has to extends other class in real problem
    public boolean isBadVersion(int k) {
        if(k == 4) return false;

        return true;
    }

    // ***************** 1st Method ******************
    // Approach 1: Using Merge Sort approach to find bad value
    // Runtime  : 24ms         -> + 39.35%
    // Memory   : 40.69MB     -> + 39.35%
    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2; // Or mid = (left + right) >>> 1;

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
