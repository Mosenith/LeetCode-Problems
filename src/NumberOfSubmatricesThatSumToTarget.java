import java.util.*;

public class NumberOfSubmatricesThatSumToTarget {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,0},{1,1,1},{0,1,0}};

        int a[][] = { { 2, 3, 5, 7 }, { 5, 8, 3, 5 }, { 7, 6, 9, 2 }};
        int row = a.length, col = a[0].length;

//        System.out.println(row + " : " + col);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(numSubmatrixSumTarget(matrix, 0));
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int ans = 0;
        for(int i=0; i<row; i++) {
            int[] column = new int[col];
            for(int j=i; j<row; j++) {
                for(int k=0; k<col; k++) {
                    column[k] += matrix[j][k];
                }
                ans += matchTarget(column,target);

            }
            System.out.println(Arrays.toString(column));
            System.out.println("*************\n");
        }
        return ans;
    }

    private static int matchTarget(int[] nums, int target) {
        System.out.println("2nd Method ---- ");
        System.out.println("nums => " + Arrays.toString(nums));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int s = 0, cnt = 0;
        for (int x : nums) {
            s += x;
            cnt += map.getOrDefault(s - target, 0);
            map.merge(s, 1, Integer::sum);
        }
        System.out.println("map => " + map);
        System.out.println("cur cnt = " + cnt + "\n");
        return cnt;
    }
}
