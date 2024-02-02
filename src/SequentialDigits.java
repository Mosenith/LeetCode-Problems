import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        int low = 100, high = 300;
        System.out.println(sequentialDigits(100,300));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ls =  new ArrayList<>();
        int digit = 0, firstDigit = 0;
        int cp = low;

        while (cp > 0) {
            if(cp < 10) {
                firstDigit = cp;
            }
            digit++;
            cp /= 10;
        }
        System.out.println(digit + " => " + firstDigit);
        return ls;
    }
}
