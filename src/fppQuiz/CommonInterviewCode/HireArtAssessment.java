package fppQuiz.CommonInterviewCode;

import java.util.Arrays;

public class HireArtAssessment {

    public static void main(String[] args) {
        // rotateArray
        int[] arr = {8,9,10};
        int n = 3, k = 1;

        System.out.println(Arrays.toString(rotateArray(arr,n,k)));
    }

    // 2,3,4,5,1
    //
    public static int[] rotateArray(int[] arr, int n, int k) {
        int[] ans = new int[n];
        int index = 0;

        for(int i=k+1; i<n; i++) {
            ans[index++] = arr[i];
        }

        for(int i=0; i<=k; i++) {
            ans[index++] = arr[i];
        }

        return ans;
    }

}
