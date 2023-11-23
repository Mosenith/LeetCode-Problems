package Blind75.Binary;

public class PracticeProb371 {
    public static void main(String[] args) {
        System.out.println(getSum(20,30));
    }
    public static int getSum(int a, int b) {
        int tmp;

        while(b != 0) {
            tmp = a & b;
            a = a ^ b;
            b = (tmp) << 1;
        }

        return a;
    }
}