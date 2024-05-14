public class PathWithMaximumGold {
    public static void main(String[] args) {
        int[][] grid = {
            {0,6,0},
            {5,8,7},
            {0,9,0}
        };

        System.out.println(getMaximumGold(grid));
    }

    public static int getMaximumGold(int[][] grid) {
        int maxGold = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        return maxGold;
    }

    private static int dfs(int[][] grid, int col, int row) {
        if(col >= grid.length || row >= grid[0].length || col < 0 || row < 0 || grid[col][row] == 0) {
            return 0;
        }

        int gold = grid[col][row];
        grid[col][row] = 0;
        int maxGold = 0;
        maxGold = Math.max(maxGold, dfs(grid, col+1, row));
        maxGold = Math.max(maxGold, dfs(grid, col-1, row));
        maxGold = Math.max(maxGold, dfs(grid, col, row+1));
        maxGold = Math.max(maxGold, dfs(grid, col, row-1));
        grid[col][row] = gold;
        return maxGold + gold;
    }
}
