import java.util.*;

public class MaximumSwap {
    public static void main(String[] args) {
        int num = 2736; // 7236
        int num2 = 9973; // 9973


        System.out.println(maximumSwap(num2));
        System.out.println("****");
//        maximumSwap(num2);
    }

    public static int maximumSwap(int num) {
        if(num <= 10) return num;

        Stack<Integer> stk = new Stack<>();
        int max = 0;

        while(num > 0) {
            max = Math.max(max, num % 10);
            stk.add(num % 10);
            num /= 10;
        }

        System.out.println(stk);
        System.out.println(max);

        int ans = 0;
        int tmp = 0;
        if(stk.peek() != max) {
            tmp = stk.pop();
            ans *= max;
        }

        System.out.println("cur ans = " + ans + ", tmp = " + tmp);
        System.out.println("stack => " + stk + "\n");

//        if(ans == 1 && tmp == 0) return
        while(!stk.isEmpty()) {
            int cur = stk.pop();
            System.out.println("cur element = " + cur);
            if(cur == max) {
                ans = (ans * 10) + tmp;
            } else {
                ans = (ans * 10) + cur;
            }
            System.out.println(ans);
            System.out.println("***\n");
        }
        System.out.println(ans);

        return -1;
    }
}
