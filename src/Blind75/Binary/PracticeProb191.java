package Blind75.Binary;

public class PracticeProb191 {
    public static void main(String[] args) {
        String  n = "11111111111111111111111111111101";
    }

    public static int hammingWeight(int n) {
        int count = 0;

        for(int i=0; i<32 && n!=0; i++) {
            if((n&10) == 1) {
                count++;
            }

            n >>>= 1;
        }

        return count;
    }
}
