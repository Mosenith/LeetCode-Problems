package Blind75.Binary;

import java.math.BigInteger;

public class PracticeProb191 {
    public static int hammingWeight(int n) {
        int count = 0;

        for(int i=0; i<32 && n!=0; i++) {
            if((n&1) == 1) {
                count++;
            }

            n >>>= 1;
        }

        return count;
    }
}
