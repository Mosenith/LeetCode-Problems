import java.util.HashMap;
import java.util.Map;

public class FillingBookcaseShelves {
    public static void main(String[] args) {
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelfWidth = 4;

        System.out.println(minHeightShelves(books, shelfWidth));
        System.out.println(minHeightShelves2(books, shelfWidth));
    }

    // ***************** 1st Method ******************
    // Approach 1: Init dp[] to store the minimum height of the shelf
    // Loop through each book, update the dp[] with the minimum height
    // dp[i] = min(dp[i], dp[j] + height) where j is the previous book
    // If the width of the books is greater than the shelfWidth, break
    // Return dp[n]
    // Runtime  : 0ms       -> + 100.00%
    // Memory   : 41.04MB  -> + 100.00%
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int width = books[i][0];
            int height = books[i][1];
            dp[i + 1] = dp[i] + height;

            for (int j = i - 1; j >= 0 && width + books[j][0] <= shelfWidth; j--) {
                width += books[j][0];
                height = Math.max(height, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + height);
            }
        }

        return dp[n];
    }
    //  ***************** End of 1st Method ******************


    // ***************** 2nd Method ******************
    // Approach 2: Using Recursion with Memoization
    // Create a cache to store the minimum height of the shelf
    // Loop through each book, update the cache with the minimum height
    // If the width of the books is greater than the shelfWidth, break
    // Return the minimum height
    // Runtime  : 19ms     -> + 92.48%
    // Memory   : 45.24MB  -> + 77.16%
    static Map<Integer,Integer> cache;
    public static int minHeightShelves2(int[][] books, int shelfWidth) {
        cache = new HashMap<>();
        return helper(books,shelfWidth,0);
    }

    private static int helper(int[][] books, int shelfWidth, int i) {
        if (i == books.length) return 0;
        if (cache.containsKey(i)) return cache.get(i);

        int curWidth = 0;
        int maxHeight = 0;
        int minHeight = Integer.MAX_VALUE;

        for (int j = i; j < books.length; j++) {
            int width = books[j][0]; // corrected here
            int height = books[j][1]; // corrected here

            if (curWidth + width > shelfWidth) break;

            curWidth += width;
            maxHeight = Math.max(maxHeight, height);

            int totalHeight = helper(books, shelfWidth, j + 1) + maxHeight;
            minHeight = Math.min(minHeight, totalHeight);
        }

        cache.put(i, minHeight);
        return minHeight;
    }
    //  ***************** End of 2nd Method ******************
}
