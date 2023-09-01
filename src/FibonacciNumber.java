import java.util.ArrayList;
import java.util.List;

public class FibonacciNumber {
    public static void main(String[] args) {

        System.out.println(fib2(0));
        System.out.println(fib3(0));
    }

    // ***************** 1st Method ******************
    // Approach : Using Recursive
    // Runtime  : 8ms        -> + 31.49%
    // Memory   : 39.28 MB    -> + 46.58%
    // Time Complexity: O(nlogn), worst-case=O(n^2), Space Complexity: O(n)
    public static int fib(int n) {
        if(n==1)
            return 1;
        else if(n==0)
            return 0;

        return fib(n-1) + fib(n-2);
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method - Using DP ******************
    // Approach : Optimized runtime & space, Lots of code
    // Runtime  : 0ms         -> + 100%
    // Memory   : 38.95 MB    -> + 81.30%%
    static List<Integer> store = new ArrayList<>();
    public static int fib2(int n) {
        if(n<=0) return 0;
        if(n==1) return 1;

        store.add(0);
        store.add(1);

        helper(n-2);
        helper(n-1);

        return store.get(n-1) + store.get(n-2);
    }
    private static void helper(int n) {
        if(n<=1) {
            return;
        }

        if(store.size() < n) {
            helper(n-2);
            helper(n-1);
        }

        store.add(n, store.get(n-1) + store.get(n-2));
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach : Using Loop
    // Runtime  : 0ms         -> + 100%
    // Memory   : 39.13 MB    -> + 58.04%
    public static int fib3(int n) {
        if(n<=0) return 0;

        int x = 0, y = 1;
        int count = 1;

        while(count < n) {
            int tmp = y;
            y += x;
            x = tmp;
            count++;
        }

        return y;
    }
    // ***************** End of 3rd Method ******************
}
