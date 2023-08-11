package MostAsked100Q;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums2 = {4,9,5},
                nums1 = {9,4,9,8,4};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    // nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    // ***************** 1st Method ******************
    // Approach :
    // Runtime  : 1ms        -> + 88.55%
    // Memory   : 40.1 MB      -> + 26.30%
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums1) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        System.out.println(counter);

        List<Integer> t = new ArrayList<>();
        for (int num : nums2) {
            if (counter.getOrDefault(num, 0) > 0) {
                t.add(num);
                counter.put(num, counter.get(num) - 1);
            }
        }
        int[] res = new int[t.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = t.get(i);
        }
        return res;
    }
    // ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Using 2 pointers on sorted arrays
    // Since ans order is not important, sort both array and find common elements
    // Runtime  : 1ms        -> + 88.55%
    // Memory   : 40.1 MB      -> + 26.30%
    public static int[] intersect2(int[] nums1, int[] nums2) {
        // Sort both the arrays first...
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

        // Create an array list...
        ArrayList<Integer> arr = new ArrayList<Integer>();

        // Use two pointers i and j for the two arrays and initialize both with zero.
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            // If nums1[i] is less than nums2[j]...
            // Leave the smaller element and go to next(greater) element in nums1...
            if(nums1[i] < nums2[j]) {
                i++;
            }
            // If nums1[i] is greater than nums2[j]...
            // Go to next(greater) element in nums2 array...
            else if(nums1[i] > nums2[j]){
                j++;
            }
            // If both the elements intersected...
            // Add this element to arr & increment both i and j.
            else{
                arr.add(nums1[i]);
                i++;
                j++;
            }
        }

        System.out.println("intersect element: " + arr);
        // Create an output list to store the output...
        int[] output = new int[arr.size()];
        int k = 0;
        while(k < arr.size()){
            output[k] = arr.get(k);
            k++;
        }
        return output;
    }
    // ***************** End of 2nd Method ******************
}
