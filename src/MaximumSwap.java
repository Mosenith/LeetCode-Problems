import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumSwap {
    public static void main(String[] args) {
        int num = 2736; // 7236
        int num2 = 9973; // 9973

        maximumSwap(num);
        System.out.println("****");
        maximumSwap(num2);
    }

    public static int maximumSwap(int num) {
        List<Integer> listSort = new ArrayList<>();
        List<Integer> origin = new ArrayList<>();

        while (num > 0) {
            listSort.add(num%10);
            num /= 10;
        }

//        Collections.reverse(listSort);
        origin = listSort;
        System.out.println(origin);
        Collections.sort(listSort, Collections.reverseOrder());
        System.out.println(listSort);

        for(int i=0; i<origin.size(); i++) {

        }

        return -1;
    }
}
