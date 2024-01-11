import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
    }

    // ***************** 1st Method ******************
    // Approach 1: Use nested loop - outer => hour(0-11) & inner => minute(0,59)
    // Add time (h:m) to List of string if Integer.bitCount() of h + m = turnedOn
    // Runtime  : 5ms          -> + 84.46%
    // Memory   : 42.00MB      -> + 44.62%
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();

        for(int h=0; h<12; h++) {
            for(int m=0; m<=59; m++) {
                if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    if(m < 10) {
                        res.add(String.format("%d:0%d", h, m));
                    } else {
                        res.add(String.format("%d:%d", h, m));
                    }
                }
            }
        }
        return res;
    }
    //  ***************** End of 1st Method ******************
}
