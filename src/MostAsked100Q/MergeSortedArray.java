package MostAsked100Q;

import java.util.*;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        int m = 3, n = 3;

//        int[] num1 = {4,5,6,0,0,0};
//        int[] num2 = {1,2,3};
//        int m = 3, n = 3;

//        int[] num1 = {1};
//        int[] num2 = {};
//        int m = 1, n = 0;

        merge3(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }

    // ***************** 1st Method ******************
    // Approach : Use List - add element of num1 & num2 while comparing
    // If num1 reach 0 (m=0), Out 1st loop, add the rest of num2
    // If num2 add all (n=0), Out 1st loop, add the rest of num1
    // Runtime  : 1ms        -> + 34.91%
    // Memory   : 41.7MB      -> + 33.57%
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0; // i < m
        int j = 0; // j < n
        List<Integer> store = new ArrayList<>();

        while(store.size() < nums1.length) {
            if(m == 0 || n == 0) {
                System.out.println("Less than m/n");
                break;
            }

            if(nums1[i] <= nums2[j]) {
                store.add(nums1[i++]);
                m--;
            } else {
                store.add(nums2[j++]);
                n--;
            }
        }

        System.out.println("store -> " + store);
        System.out.println(m + " : i = " + i);
        System.out.println(n + " : j = " + j);

        while(m != 0 && n == 0) {
            store.add(nums1[i++]);
            m--;
        }

        while (m == 0 && n != 0) {
            store.add(nums2[j++]);
            n--;
        }

        System.out.println("final store -> " + store);

        for(int k=0; k<store.size(); k++) {
            nums1[k] = store.get(k);
        }
    }
    //  ***************** End of 1st Method ******************

    // ***************** 2nd Method ******************
    // Approach : Similar to 1st Method
    // Check every within one loop & Copy Queue to num1 later
    // Runtime  : 1ms        -> + 34.91%
    // Memory   : 41.3MB      -> + 84.69%
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0; // i < m
        int j = 0; // j < n
        Queue<Integer> store = new ArrayDeque<>();

        while(store.size() < nums1.length) {
            if(m != 0 && n != 0) {
                if(nums1[i] <= nums2[j]) {
                    store.add(nums1[i++]);
                    m--;
                } else {
                    store.add(nums2[j++]);
                    n--;
                }
            } else if(m == 0 && n != 0) {
                store.add(nums2[j++]);
                n--;
            } else {
                store.add(nums1[i++]);
                m--;
            }
            System.out.println(store);
            System.out.println("************************************");
        }

        if (store.isEmpty()) return;

        for(int k=0; k<nums1.length; k++) {
            if(nums1[k] != store.peek()) {
                nums1[k] = store.peek();
            }
            store.remove();
        }
    }
    //  ***************** End of 2nd Method ******************

    // ***************** 3rd Method ******************
    // Approach : Optimized & Better sol - Add bigger elements first, k=n1.len-1 & k-- every loop
    // If last index of n1[i] > n2[j] & i>=0 : n1[k] = n1[i--]
    // Otherwise : n1[k] = n2[j--]
    // Reduce index of chosen element & for condition is j(n2)>=0
    // Runtime  : 0ms        -> + 100%
    // Memory   : 41.4MB      -> + 73.56%
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, k = m + n - 1; j >= 0; --k) {
            System.out.println("i=" + i + ", j=" + j + ", k=" + k);
            nums1[k] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
            System.out.println(Arrays.toString(nums1));
            System.out.println("************************************");
        }
    }
}
