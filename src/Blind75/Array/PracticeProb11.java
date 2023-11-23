package Blind75.Array;

public class PracticeProb11 {
    public static void main(String[] args) {
        int[] height = {1,1};

        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int max = 0;

        for(int i=0, j=height.length-1; i < j ;) {
            int h = Math.min(height[i], height[j]);
            int d = j - i;

            max = Math.max(max, h*d);
            if(height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }
}
