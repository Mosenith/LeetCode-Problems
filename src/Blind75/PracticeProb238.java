package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeProb238 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {-1,1,0,-3,3};

        System.out.println(Arrays.toString(productExceptSelf(nums1)));
    }

    public static int[] productExceptSelf(int[] nums) {
        List<Integer> zeroIndex = new ArrayList<>();
        int totalProduct = 1;
        int[] answer = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                zeroIndex.add(i);
            } else {
                totalProduct *= nums[i];
            }
        }

        if(zeroIndex.size() >= 2) {
            Arrays.fill(answer,0);
        } else if(zeroIndex.size() == 1) {
            // all zero except ZeroIndex
            Arrays.fill(answer,0);
            answer[zeroIndex.get(0)] = totalProduct;
        } else {
            for(int i=0; i<answer.length; i++) {
                answer[i] = totalProduct / nums[i];
            }
        }

        return answer;
    }
}
