package AlgorithmsCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//       Find subarrays with given sum in an array.
//
//Input :
//Input-int[] arr = {2, 3, 6, 4, 9, 0, 11};
//int num = 9
//
//Output-
//starting index : 1, Ending index : 2
//starting index : 4, Ending index : 4
//starting index : 4, Ending index : 5

        int[] arr = {2, 3, 6, 4, 9, 0, 11};
        int sum = 9;

        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int curSum = calSum(arr, i, j);
                if(curSum == sum) {
                    System.out.println("starting index : " + i + ", Ending index : " + j);
                }
            }
        }


    }

    private static int calSum(int[] arr, int start, int end) {
        int s = 0;

        for(int i=start; i<=end; i++) {
            s += arr[i];
        }

        return s;
    }
}
