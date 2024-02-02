import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        int low = 100, high = 300;
        System.out.println(sequentialDigits(1000,13000));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use nest loop with outer form 1-8 cos 9 has no next sequence
    // Save i->x, get inner loop from i+1-9, update x by x*10+j
    // Check if x is between low & high, add to list, sort list & return list
    // Runtime  : 0ms        -> + 100.00%
    // Memory   : 40.48MB    -> + 79.58%
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ls =  new ArrayList<>();

        for(int i=1; i<9; i++) {
            int x = i;  // 1-8 cos 9 has no next sequential num
            for(int j=i+1; j<=9; j++) {
                x = x * 10 + j; // increment 1 digit each iteration + next sequential num
                if(x >= low && x <= high) {
                    ls.add(x);
                }
            }
        }
        Collections.sort(ls);
        return ls;
    }
    //  ***************** End of 1st Method ******************
}
