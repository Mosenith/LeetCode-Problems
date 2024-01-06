public class FirstBadVersion {
    public boolean isBadVersion(int k) {
        if(k == 4) return false;

        return true;
    }
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        int mid = (left+right)/2;

        while(left < right) {
            if(!isBadVersion(mid)) {
                left = mid+1;
                mid = (left+right)/2;
            } else {
                if(!isBadVersion(mid-1)) {
                    return mid;
                }
            }
        }

        return left;
    }
}
