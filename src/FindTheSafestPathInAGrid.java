import java.util.*;

public class FindTheSafestPathInAGrid {
    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(
            List.of(0,0,0,1),
            List.of(0,0,0,0),
            List.of(0,0,0,0),
            List.of(1,0,0,0)
        );

        System.out.println(maximumSafenessFactor(grid));
    }

    static int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] gridArr = new int[n][n];
        int[][] safety = new int[n][n]; //closest distance to thief
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){
                    gridArr[i][j] = 1;
                    safety[i][j] = 0;
                    queue.add(new int[]{i, j, 0});
                }else{
                    safety[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        if(gridArr[0][0] == 1 || gridArr[n - 1][n - 1] == 1) return 0;
        //bfs from each thief, update the smallest safety for all cells
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currSafety = curr[2];
            for(int[] dir: directions){
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if(isValid(nextX, nextY, n) && safety[nextX][nextY] > currSafety + 1){
                    queue.add(new int[]{nextX, nextY, currSafety + 1});
                    safety[nextX][nextY] = currSafety + 1;
                }
            }
        }
        //bfs from start
        Queue<int[]> path = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        path.add(new int[]{0,0,safety[0][0]});
        gridArr[0][0] = 2;
        while(!path.isEmpty()){
            int[] curr = path.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currSafety = curr[2];
            if(currX == n - 1 && currY == n - 1) return currSafety;
            for(int[] dir: directions){
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if(isValid(nextX, nextY, n) && gridArr[nextX][nextY] != 2){
                    path.add(new int[]{nextX, nextY, Math.min(currSafety, safety[nextX][nextY])});
                    gridArr[nextX][nextY] = 2;
                }
            }
        }return 0;
    }
    public static boolean isValid(int i, int j, int n){
        if(i < 0|| i >= n || j<0 || j>=n ) return false;
        return true;
    }
}
