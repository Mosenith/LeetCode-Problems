import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,7,5}; // 2 => [1,3,5] & [1,3,5,2]
        int minK = 1, maxK = 3;

        System.out.println(countSubarrays(nums,minK,maxK));
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        Queue<Integer> quq = new ArrayDeque<>();



        return 0;
    }
}
