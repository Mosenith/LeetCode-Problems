import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        // out : [[1,6],[8,10],[15,18]]
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{1,4},{4,5}};
//        int[][] intervals = {{1,7},{0,5}};
//        int[][] intervals = {{1,4},{5,6}};
//        int[][] intervals = {{1,4},{0,0}};
//        int[][] intervals = {{1,4},{0,1}};
//        int[][] intervals = {{1,9},{2,4},{10,12}};
//        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};

//        System.out.println(intervals[1][1]);
//        System.out.println(Arrays.toString(intervals[2]));

        System.out.println(Arrays.deepToString(merge2(intervals)));
    }
    // ***************** 1st Method ******************
    // Runtime  : 12ms        -> + 18.49%
    // Memory   : 45.2MB      -> + 96.69%
    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<intervals.length; i++) {
            int len = myList.size();
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(myList.isEmpty()) {
                myList.add(start);
                myList.add(end);
            } else {
                if(start <= myList.get(len-1) && end > myList.get(len-1)) {
                    myList.set(len-1, end);
                } else if(start > myList.get(len-2) && end > myList.get(len-1) ||
                        start < myList.get(len-2) && end < myList.get(len-1)) {
                    myList.add(start);
                    myList.add(end);
                }
            }
        }

        int len = myList.size()/2;
        int index = 0;
        int[][] result = new int[len][2];
        for(int i=0; i<len && index<myList.size(); i++) {
            for(int j=0; j<2; j++) {
                result[i][j] = myList.get(index++);
            }
        }

        return result;
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 11ms        -> + 27.10%
    // Memory   : 45.7MB      -> + 71.80%
    public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int st = intervals[0][0], ed = intervals[0][1];
        List<int[]> ans = new ArrayList<>();
        System.out.println("Sorted Array -> " + Arrays.deepToString(intervals));

        for (int i = 1; i < intervals.length; ++i) {
            System.out.println(st + " : " + ed);
            int s = intervals[i][0], e = intervals[i][1];
            if (ed < s) {
                ans.add(new int[] {st, ed});
                st = s;
                ed = e;
            } else {
                ed = Math.max(ed, e);
            }
            print(ans);
            System.out.println("\nNew Start & End -> " + st + " : " + ed);
            System.out.println("************************************");
        }
        ans.add(new int[] {st, ed});
        return ans.toArray(new int[ans.size()][]);
    }

    public static void print(List<int[]> ans) {
        for (int[] arr : ans) {
            System.out.print(Arrays.toString(arr) + " ");
        }
    }
}
