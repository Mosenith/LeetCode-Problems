import java.util.*;

public class BestTeamWithNoConflicts {
    public static void main(String[] args) {
//        int[] scores = {1,2,3,5};
//        int[] ages = {8,9,10,1};

//        int[] scores = {4,5,6,5};
//        int[] ages = {2,1,2,1};

        // out 29
        int[] scores = {1,3,7,3,2,4,10,7,5};
        int[] ages = {4,5,2,1,1,2,4,1,4};


        System.out.println(bestTeamScore(scores, ages));
    }

    // ***************** 1st Method ******************
    // Approach : Optimized - Sort Array first
    // Runtime  : 32ms        -> + 81.90%
    // Memory   : 43.58MB      -> + 90.73%
    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] arr = new int[n][2];

        // create pairs of score and age
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {scores[i], ages[i]};
        }

        System.out.println(Arrays.deepToString(arr));

        // sort the array by scores, breaking ties by ages
        // Using Lambda
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // Using comparator
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                System.out.println("a[0] = " + a[0] + ", b[0] = " + b[0]);
//                System.out.println("****");
//                if (a[0] == b[0]) {
//                    return a[1] - b[1];
//                } else {
//                    return a[0] - b[0];
//                }
//            }
//        });


        System.out.println(Arrays.deepToString(arr));


        int[] f = new int[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[i][1] >= arr[j][1]) {
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            f[i] += arr[i][0];
            ans = Math.max(ans, f[i]);
        }

        System.out.println(Arrays.toString(f));
        return ans;
    }
    // ***************** End of 1st Method ******************
}

// scores = [1,3,5,10,15] => 1+3+5+10+15 = 34
// ages = [1,2,3,4,5]

// scores = [4,5,6,5] => 5+6+5 = 16
// ages = [2,1,2,1]

// scores = [1,2,3,5] => 1+2+3 = 6
// ages = [8,9,10,1]
