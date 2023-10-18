package AlgorithmsCode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4,2,1,9,9};

//        Arrays.sort(arr);   //1,2,9,9,9
//
//        for(int i=arr.length-1; i>0; i--) {
//            if(arr[i-1] < arr[i]) {
//                System.out.println(arr[i-1]);
//                break;
//            }
//        }

        int max = (arr[0] < arr[1]) ? arr[1] : arr[0];
        int secMax = (arr[0] < arr[1]) ? arr[0] : arr[1];

        System.out.println(max + " : " + secMax);
        for(int i=2; i<arr.length; i++) {
            if(arr[i] > max) {
                secMax = max;
                max = arr[i];
            }
        }

        System.out.println(max);
        System.out.println(secMax);
    }
}
