import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    // ***************** 1st Method ******************
    // Approach : last digit of arr +1, if sum=10 then update remain
    // Runtime  : 0ms        -> + 100%
    // Memory   : 41.1MB      -> + 47.1%
    public static int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int remain = 0;
        for(int i=digits.length-1; i>=0; i--) {
            if(i==digits.length-1) {
                list.add((digits[i]+1)%10);
                remain = (digits[i]+1)/10;
            } else {
                if(remain != 0) {
                    list.add((digits[i] + remain) % 10);
                    remain = (digits[i] + remain) / 10;
                } else
                    list.add(digits[i]);
            }
        }
        if(remain != 0)
            list.add(remain);

        int[] ans = new int[list.size()];
        for(int i=0, j= list.size()-1; j>=0; i++, j--) {
            ans[i] = list.get(j);
        }

        return ans;
    }

    // ***************** 1st Method ******************
    // Approach : Start from i = digits.len-1 and add 1 to the then % 10.
    // If digits[i]!=0 => there's no remain to add to next index(i-1), so return digits
    // If digits[i]=0 => continue looping.
    // If it exits the loop => need extra space, with digits[0] = 1
    // Runtime  : 0ms        -> + 100%
    // Memory   : 41.2MB      -> + 46.33%
    public static int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            ++digits[i];
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // need extra space
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        // [1,2,4]
//        int[] digits = {1,2,3};

//        int[] digits = {9,9,9,9,9};

        // [4,3,2,2]
//        int[] digits = {4,3,2,1};

        // [1,0]
        int[] digits = {9};

//        System.out.println(Arrays.toString(plusOne(digits)));
        System.out.println(Arrays.toString(plusOne2(digits)));
    }
}
