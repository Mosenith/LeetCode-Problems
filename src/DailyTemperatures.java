import java.util.Arrays;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {30,60,90};

        DailyTemperatures dt = new DailyTemperatures();
        System.out.println(Arrays.toString(dt.dailyTemperatures3(temperatures)));
    }

    // brute force : work but over time limit
    public int[] dailyTemperatures3(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];

        for(int i=0; i<len-1; i++) {
            int j = i+1;
            while(j<len && temperatures[i] >= temperatures[j]) {
                j++;
            }

            if(j >= len || temperatures[i] > temperatures[j]) {
                ans[i] = 0;
            } else {
                ans[i] = (j-i);
            }
        }

        return ans;
    }
}
