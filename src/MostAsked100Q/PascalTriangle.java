package MostAsked100Q;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        int n = 5;

        System.out.println(generate4(n));
    }

    // ***************** 1st Method : HashMap ******************
    // Approach : loop from len=1 -> numsRows
    // After every loop add innerList to result(ListofList)
    // inner loop condition: len=1 -> inner.add(1), inner=2, add 1 more
    // else: use last element of result to calculate the middle elements of inner
    // Runtime  : 1ms           -> + 89.53%
    // Memory   : 40.77 MB      -> + 95.15%
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 1;

        while(count <= numRows) {
            List<Integer> inner = new ArrayList<>();

            if(count <= 2) {
                inner.add(1);
                if(count == 2)
                    inner.add(1);
            } else {
                List<Integer> preRow = res.get(res.size()-1);
                int curIndex = 0;
                inner.add(1);
                while(curIndex < count-2) {
                    int sum = preRow.get(curIndex) + preRow.get(curIndex+1);
                    inner.add(sum);
                    curIndex++;
                }
                inner.add(1);
            }

            res.add(inner);
            count++;
        }
        return res;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Same apprach as the 1st method, just less line
    // Runtime  : 1ms           -> + 89.53%
    // Memory   : 41.30 MB      -> + 40.83%
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> f = new ArrayList<>();
        f.add(List.of(1));
        for (int i = 0; i < numRows - 1; ++i) {
            List<Integer> g = new ArrayList<>();
            g.add(1);
            for (int j = 0; j < f.get(i).size() - 1; ++j) {
                g.add(f.get(i).get(j) + f.get(i).get(j + 1));
            }
            g.add(1);
            f.add(g);
        }
        return f;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Same approach, just populate the result with 1 first
    // Calculate each list of result with double loop: outer start from 2
    public static List<List<Integer>> generate3(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            Integer[] temp = new Integer[i + 1];
            Arrays.fill(temp, 1);
            ans.add(Arrays.asList(temp));
        }

        for (int i = 2; i < numRows; ++i) {
            for (int j = 1; j < ans.get(i).size() - 1; ++j)
                ans.get(i).set(j, ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
        }

        return ans;
    }
    // ***************** End of 3rd Method ******************

    // ***************** 4th Method ******************
    // Approach : Interesting ONE - DP
    // Runtime  : 1ms           -> + 89.53%
    // Memory   : 41.09 MB      -> + 71.09%
    public static List<List<Integer>> generate4(int numRows) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        if (numRows <= 0)  return output;

        ArrayList<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        output.add(prev);

        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);    //first
            for (int j = 0; j < prev.size() - 1; j++) {
                curr.add(prev.get(j) + prev.get(j + 1));    //middle
            }
            curr.add(1);    //last
            output.add(curr);
            prev = curr;

            System.out.println("Cur List -> " + curr);
            System.out.println("Output ->" + output);
            System.out.println("******************");
        }
        return output;
    }
    // ***************** End of 4th Method ******************
}
