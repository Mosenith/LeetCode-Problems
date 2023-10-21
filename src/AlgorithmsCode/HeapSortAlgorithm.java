package AlgorithmsCode;

import java.util.Arrays;

public class HeapSortAlgorithm {
    public static void main(String[] args) {
        // [-2,1,2,4,8]
        int[] arr = {12, 11, 31, 3, 5, 7, 9};

        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 0 -> 1,2
    // 1 -> 3,4
    // 2 -> 5,6
    // 2n+1 && 2n+2
    public static void sortArray(int[] arr) {
        int len = arr.length;

        // Build max heap
        // first index of a non-leaf node => len/2 - 1
        for(int i = len/2 - 1; i>=0; i--) {
            heapify(arr, len, i);
        }

        System.out.println(Arrays.toString(arr));

        // Heap sort
        for(int i=len-1; i>=0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int len, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if(left < len && arr[largest] < arr[left]) {
            largest = left;
        }

        if(right < len && arr[largest] < arr[right]) {
            largest = right;
        }

        // Swap and continue heapifying if root is not largest
        if(largest != i) {
            swap(arr, i, largest);
            heapify(arr, len, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
