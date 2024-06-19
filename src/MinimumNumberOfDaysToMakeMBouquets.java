public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;

        System.out.println(minDays(bloomDay,m,k));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use Binary search for the minimum days to make m bouquets
    // If (long) m * k > bloomDay.length, return -1
    // Binary search from 1 to 1000000000, find mid and check if canMakeBouquet
    // Within canMakeBouquet, count the number of bouquets made
    // If bouquet >= m, return true. Else, return false
    // If can make bouquet, right = mid. Else, left = mid + 1
    // Return left when out of loop
    // Runtime  : 16ms      -> + 95.31%
    // Memory   : 58.17MB   -> + 30.40%
    public static int minDays(int[] bloomDay, int m, int k) {
        if((long) m * k > bloomDay.length) return -1;

        int left = 1;
        int right = 1000000000;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(canMakeBouquet(bloomDay,m,k,mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canMakeBouquet(int[] bloomDay, int m, int k, int mid) {
        int count = 0;
        int bouquet = 0;
        for (int j : bloomDay) {
            if (j <= mid) {
                count++;
                if (count == k) {
                    bouquet++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return bouquet >= m;
    }
    //  ***************** End of 1st Method ******************
}
