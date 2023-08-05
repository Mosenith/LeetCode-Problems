import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{6,9}};
//        int[] newInterval = {2,5};

//        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] newInterval = {4,8};

        int[][] intervals = {};
        int[] newInterval = {5,7};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    // ***************** 1st Method ******************
    // Runtime  : 1ms        -> + 98.59%
    // Memory   : 44MB      -> + 73.14%
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int st = newInterval[0], ed = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        int i=0;
        for(; i<intervals.length; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            System.out.println("st = " + st + ", ed = " + ed);
            System.out.println("s = " + s + ", e = " + e);
            if(st <= e && ed >= s) {
                st = Math.min(st,s);
                ed = Math.max(ed, e);
            } else if(ed < s) {
                break;
            } else {
                // st > e
                ans.add(new int[] {s,e});
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("st = " + st + ", ed = " + ed);
            System.out.println("st = " + s + ", e = " + e);
            System.out.println("************************************");
        }

        System.out.println("Current i = " + i);
        ans.add(new int[] {st, ed});
        while(i<=intervals.length-1) {
            ans.add(new int[] {intervals[i][0],intervals[i][1]});
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void print(List<int[]> ans) {
        for (int[] arr : ans) {
            System.out.print(Arrays.toString(arr) + " ");
        }
        System.out.println("\n");
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Runtime  : 1ms        -> + 98.59%
    // Memory   : 44MB      -> + 73.14%
    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int st = newInterval[0], ed = newInterval[1];
        boolean insert = false;
        for (int[] interval : intervals) {
            int s = interval[0], e = interval[1];
            if (ed < s) {
                if (!insert) {
                    ans.add(new int[] {st, ed});
                    insert = true;
                }
                ans.add(interval);
            } else if (e < st) {
                ans.add(interval);
            } else {
                st = Math.min(st, s);
                ed = Math.max(ed, e);
            }
        }
        if (!insert) {
            ans.add(new int[] {st, ed});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
