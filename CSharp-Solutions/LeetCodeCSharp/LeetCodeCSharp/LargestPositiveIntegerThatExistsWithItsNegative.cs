namespace LeetCodeCSharp;

public class LargestPositiveIntegerThatExistsWithItsNegative {
   public static int findMaxK(int[] nums) {
      int ans = -1;
      Dictionary<int, int> map = new Dictionary<int, int>();

      foreach (int n in nums) {
         int cur = n;
         if (cur > 0 && map.ContainsKey(-cur) || cur < 0 && map.ContainsKey(-cur)) {
            ans = Math.Max(ans, Math.Abs(n));
         } else if(!map.ContainsKey(n)){
            map.Add(n,0);
         }
      }

      return ans;
   }
}