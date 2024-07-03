import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static void main(String[] args) {
        int[] nums = {6,6,0,1,1,4,6};

        System.out.println(minDifference(nums));
    }

    public static int minDifference(int[] nums) {
        if(nums.length <= 4) return 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int min = nums[0];
        int len = nums.length;

        for(int i=nums.length-1; i>=len-3; i--) {
            nums[i] = min;
            System.out.println("******\n");
        }

        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);

        return nums[len-1]-nums[0];
    }
}
