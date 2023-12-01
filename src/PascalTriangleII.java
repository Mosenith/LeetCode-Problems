import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        // 1, 11, 121, 1331, 14641
        // 11 - i=1 - 0,1,2
        // 121 - i=2 -
        for(int i=0; i<=rowIndex; i++) {
            List<Integer> inner = new ArrayList<>();

            for(int j=0; j<i+1; j++) {
                if(j == 0 || j == i) {
                    // 1st & last element => 1
                    inner.add(1);
                } else {

                }
            }
        }

        return res.get(res.size()-1);
    }
}
