package Blind75;

import java.util.Arrays;

public class NumberOfIslands_DFS {
    // ***************** 1st Method ******************
    // Approach : DFS Approach
    // Runtime  : 3ms           -> + 97.34%
    // Memory   : 47.80 MB      -> + 48.03%
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length < 1) return 0;

        int num = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                // only perfrom DFS when grid[i][j] =  '1'
                if(grid[i][j] == '1') {
                    num += dfs(grid, i, j);
                }
            }
        }

        return num;
    }

    private int dfs(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0')
            return 0;

        // set grid[i][j] to '0' so that we don't have to check it again
        grid[i][j] = '0';

        // check vertically => up & down => i+1 & i-1
        dfs(grid, i+1, j);
        dfs(grid, i-1,j);

        // check horizontally => left & right => j+1 && j-1
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

        return 1;
    }

    // System.out.println("**********************************");
    public static void main(String[] args) {
        char[][] gird = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

//        char[][] gird = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        };

        NumberOfIslands_DFS res = new NumberOfIslands_DFS();

        System.out.println(res.numIslands(gird));
    }
}
