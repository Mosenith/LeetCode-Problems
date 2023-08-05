package MostAsked100Q;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(fizzBuzz(15));
    }

    // ***************** 1st Method ******************
    // Approach : from i=1 to n
    // if i % 3 == 0 && i % 5 == 0 => add "FizzBuzz" to ans
    // if i % 3 == 0 => add "Fizz" to ans
    // if i % 5 == 0 => add "Buzz" to ans
    // otherwise add Integer.toString(i) to ans
    // Runtime  : 1ms        -> + 99.44%
    // Memory   : 45MB      -> + 35.56%
    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if(i % 3 == 0) {
                ans.add("Fizz");
            } else if(i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }
    //  ***************** End of 1st Method ******************
}
