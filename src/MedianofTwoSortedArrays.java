import java.util.Arrays;

public class MedianofTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m+n];

        for(int i=0, j=0, k=0; i<merged.length;){
            while(j<m){
                merged[i] = nums1[j];
                i++;
                j++;
            }

            while(k<n){
                merged[i] = nums2[k];
                i++;
                k++;
            }
        }

        Arrays.sort(merged);
        System.out.println(Arrays.toString(merged));
        //System.out.println("Size: " + merged.length);

        double median = merged[merged.length/2];

        //System.out.println(merged[merged.length/2 - 1]);
        //System.out.println((m+n)/2);
        if((m+n)%2 == 0){
            // Even case
            median = (median + merged[merged.length/2 - 1]) / 2;
        }

        return median;
    }


    public static void main(String[] args){
        int[] nums1 = {9,1,8}, nums2 = {3,4,5};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
