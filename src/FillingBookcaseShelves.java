public class FillingBookcaseShelves {
    public static void main(String[] args) {
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelfWidth = 4;

        System.out.println(minHeightShelves(books, shelfWidth));
    }

    // ***************** 1st Method ******************
    // Approach 1:
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

}
