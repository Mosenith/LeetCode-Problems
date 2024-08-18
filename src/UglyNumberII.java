import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(nthUglyNumber(n));
    }

    // ***************** 1st Method ******************
    // Approach 1: Works but exceed time limit
    public static int nthUglyNumber(int n) {
        if(n == 1) return 1;

        List<Integer> ls = new ArrayList<>();
        int cnt = 1;
        int uglyNum = 1;
        while(cnt != n) {
            uglyNum++;
            int curNum = uglyNum;
            System.out.println("currentNum -> " + curNum);
            while(curNum > 1) {
                if(curNum % 2 == 0) {
                    curNum /= 2;
                } else if(curNum % 3 == 0) {
                    curNum /= 3;
                } else if(curNum % 5 == 0) {
                    curNum /= 5;
                } else {
                    break;
                }
            }

            if(curNum == 1) {
                cnt++;
                ls.add(uglyNum);
            }
            System.out.println("ls => " + ls);
            System.out.println("****\n");
        }
        return uglyNum;
    }
    //  ***************** End of 1st Method ******************

}

// 12,14
