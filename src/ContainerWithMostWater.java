import java.util.Arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        // 2 <= n <= 105
        if(height.length < 2 || height.length > Math.pow(10,5)) return 0;
        int sum = 0;

        for(int head = 0; head<height.length/2; head++) {
            for(int tail=0; tail<height.length/2; tail++) {
                int width = height.length - head - tail - 1;
                if(width <= 0) break;
                int h = (height[tail] < height[height.length - head - 1]) ? height[tail] : height[height.length - head - 1];

                sum = (sum > width*h) ? sum : width*h;
                System.out.print("width= " + width);
                System.out.println("; min(" + height[tail] + "," + height[height.length - head - 1] + ") = " + h + "; width*h = " + width*h);
                //System.out.println("sum = " + sum + "; width*h = " + width*h);
            }

            System.out.println("*******SUM=" + sum + "*******");
        }

        return sum;
    }

    public static int maxArea2(int[] height) {
        // max1 > max2
        int max1 = (height[0] > height[1]) ? height[0] : height[1];
        int max2 = (height[0] < height[1]) ? height[0] : height[1];

        for(int i=2; i<height.length; i++) {
            max1 = (max1 > height[i]) ? max1 : height[i];
            max2 = (max2 > height[i]) ? max2 : height[i];
        }

        System.out.println("max1= " + max1 + "; max2= " + max2);
        return max1;
    }

    public static int maxArea3(int[] height) {
        int mid = height.length/2;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        int index_left = 0;
        int index_right = 0;

        // left max of minimum
        for(int i=0; i<mid; i++) {
            int min = (height[i] < height[mid]) ? height[i] : height[mid];
            int dis = mid - i;
            index_left = (left < min*dis) ? i : index_left;
            left = (left < min*dis) ? min*dis : left;
        }

        // right max of minimum
        for(int j=mid+1; j<height.length; j++) {
            int min = (height[mid] > height[j]) ? height[j] : height[mid];
            int dis = j - mid;
            index_right = (right < min*dis) ? j : index_right;
            right = (right < min*dis) ?  min*dis : right;
        }

        int max = (right > left) ? right : left;
        int min = (height[index_left] > height[index_right]) ? height[index_right] : height[index_left];
        int dis = index_right - index_left;

        return (max > min*dis) ? max : min*dis;
    }


    public static int maxAreaSample1(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            System.out.print("i: " + i + "; j: " + j);
            int t = (j - i) * Math.min(height[i], height[j]);
            System.out.println("; t: " + t + "; res: " + res);
            res = Math.max(res, t);

            System.out.println("****** " + res + " ******");
            if (height[i] < height[j])
                ++i;
            else
                --j;
        }
        return res;

    }

    public static void main(String[] args) {
        int height1[] = {1,8,6,2,5,4,8,3,7};
        int height2[] = {1,1};
        int height3[] = {1,8,100,2,100,4,8,3,7};
        int height4[] = {3846,7214,9316,9869,2423,4235,4921,5878,9832,5302,4298,4312,8571,531,3206,7504,8321,9385,657,3095,1486,8099,1635,2735,1160,228,3388,1557,};
        int height5[] = {1,8,7,6,5,4,3,2,3};
        //System.out.println(maxArea(height3));
        //System.out.println(maxArea(height4));
        System.out.println(maxAreaSample1(height5));
    }
}

