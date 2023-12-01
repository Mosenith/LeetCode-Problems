import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    // ***************** 1st Method ******************
    // Approach : Use double List and calculate inner based on the prev List
    // Runtime  : 1ms           -> + 67.19%
    // Memory   : 40.45 MB      -> + 15.28%
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        // 1, 11, 121, 1331, 14641
        // 11 - i=1 - 0,1,2
        // 121 - i=2 -
        res.add(List.of(1));

        for(int i=1; i<=rowIndex; i++) {
            List<Integer> inner = new ArrayList<>();
            List<Integer> prev = res.get(i-1);
            inner.add(1);
            for(int j=0; j<prev.size()-1; j++) {
                inner.add(prev.get(j) + prev.get(j+1));
            }
            inner.add(1);
            res.add(inner);
        }
        return res.get(rowIndex);
    }
    // ***************** End of 1st Method ******************

}
