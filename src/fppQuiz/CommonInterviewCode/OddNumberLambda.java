package fppQuiz.CommonInterviewCode;

import java.util.Arrays;
import java.util.Scanner;

// Read a list and print odd numbers using lambda.
public class OddNumberLambda {
    public static void main(String[] args) {
        int[] arr = {3,4,9,13,2,0};

        Arrays.stream(arr).forEach(
                (n) -> {
                    if(n%2 == 1)
                        System.out.println(n);
                }
        );

    }
}
