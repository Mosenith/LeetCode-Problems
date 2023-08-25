package MostAsked100Q;

import java.util.*;

public class SortColors {
    public static void main(String[] args) {
        // out: [0,0,1,1,2,2]
//        int[] nums = {2,0,2,1,1,0};

        int[] nums = {1,12,9,5,6,10};

//        int[] nums = {1,0};

        sortColors4(nums);
        System.out.println(Arrays.toString(nums));
    }

    // could try using HeapSort or MergeSort
    // ***************** 1st Method ******************
    // Approach : Using QuickSort - Fast
    // Runtime  : 0ms        -> + 100.00%
    // Memory   : 41.12 MB    -> + 29.20%
    // Time Complexity: O(nlogn), worst-case=O(n^2), Space Complexity: O(n)
    public static void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if(low > high)
            return;

        int pivot = partition(nums, low, high);
        
        quickSort(nums, low, pivot-1);
        quickSort(nums, pivot+1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int pointer = high;
        int secPointer = low-1;

        for(int i=low; i<nums.length; i++) {
            if(nums[i] < nums[pointer]) {
                secPointer++;
                swap(nums, i, secPointer);
            }
        }
        swap(nums, pointer, secPointer+1);
        return secPointer+1;
    }
    private static void swap(int[] nums, int cur, int next) {
        int temp = nums[cur];
        nums[cur] = nums[next];
        nums[next] = temp;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Slow but take less space
    // Runtime  : 1ms         -> + 22.55%
    // Memory   : 40.58 MB    -> + 97.43%
    // Time Complexity: O(n), Space Complexity: O(1)
    public static void sortColors2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            map.computeIfPresent(n, (key,val) -> val+1);
            map.computeIfAbsent(n, val -> 1);
        }

        int index = 0;
        for(int i=0; i<3; i++) {
            if(!map.containsKey(i)) continue;
            int curVal = map.get(i);
            while(curVal > 0) {
                nums[index++] = i;
                curVal--;
            }
        }
    }
    // ***************** End of 2nd Method ******************

    // ***************** 3rd Method : Best Method-Merge Sort ******************
    // Approach : Merge Sort => Overall good + use System.arraycopy()
    // Runtime  : 0ms         -> + 22.55%
    // Memory   : 40.70 MB    -> + 85.78%
    // Time Complexity: all cases O(nlogn), Space Complexity: O(n)
    public static void sortColors3(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = (start + end)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);

        // merge all
        merge(nums, start, mid, end);


    }
    private static void merge(int[] nums, int start, int mid, int end) {
        // Create a temporary array to store merged values
        int[] temp = new int[end - start + 1];

        int leftIndex = start;
        int rightIndex = mid + 1;
        int tempIndex = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                temp[tempIndex++] = nums[leftIndex++];
            } else {
                temp[tempIndex++] = nums[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            temp[tempIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= end) {
            temp[tempIndex++] = nums[rightIndex++];
        }

        // Copy the merged values back to the original array
        // System.arraycopy(srcArray, srcPos, destArray, destPos, length);
        System.arraycopy(temp, 0, nums, start, temp.length);
    }
    // ***************** End of 3rd Method ******************

    // ***************** 4th Method : Heap Sort ******************
    // Approach : Best at both side but is too complicated to implement
    // Runtime  : 0ms         -> + 100%
    // Memory   : 40.65 MB    -> + 93.22%
    // Time Complexity: all cases O(nlogn), Space Complexity: O(1)
    public static void sortColors4(int[] nums) {
        for(int i=nums.length/2 -1; i>=0; i--) {
            heapify(nums, i, nums.length);
        }


        for(int i=0; i<nums.length; i++) {
            swapHeapSort(nums, 0, nums.length - 1 - i);
            heapify(nums, 0, nums.length - 1 - i);
        }
    }

    private static void heapify(int[] nums, int i, int length) {
        int max = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < length && nums[left] > nums[max]) {
            max = left;
        }

        if(right < length && nums[right] > nums[max]) {
            max = right;
        }

        if(max != i) {
            swapHeapSort(nums, i, max);
            heapify(nums, max, length);
        }
    }

    private static void swapHeapSort(int[] nums, int curVal, int changeVal) {
        int tmp = nums[curVal];
        nums[curVal] = nums[changeVal];
        nums[changeVal] = tmp;
    }
    // ***************** End of 4th Method ******************

}
