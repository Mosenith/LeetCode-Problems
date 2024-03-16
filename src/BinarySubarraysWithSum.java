public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 0;

        System.out.println(numSubarraysWithSum2(nums,2));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int[] cnt = new int[nums.length + 1];
        cnt[0] = 1;
        int ans = 0, s = 0;
        for (int v : nums) {
            s += v;
            if (s - goal >= 0) {
                ans += cnt[s - goal];
            }
            ++cnt[s];
        }
        return ans;
    }

    public static int numSubarraysWithSum2(int[] nums, int goal) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += countSubarrays(nums, goal, i);
        }
        return ans;
    }

    private static int countSubarrays(int[] nums, int goal, int start) {
        int count = 0;
        int curSum = 0;
        for (int i = start; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum == goal) {
                count++;
            } else if (curSum > goal) {
                break; // No need to continue as sum can't be achieved further
            }
        }
        return count;
    }
}
