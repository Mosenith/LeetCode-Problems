namespace LeetCodeCSharp
{
    public class SortTheJumbledNumbers
    {
        // ***************** 1st Method ******************
        // Approach 1: Define a delegate function to convert the number
        // It takes input int and output int. This funct will convert each digit of input
        // And use mapping to output the number
        // Init a list<int,int> arr that takes 0th index from the result of funct
        // 1st index from the i-th index of nums. Then sort the list.
        // Iterate from 0 to arr.Length, will access from smallest to largest
        // Use 1st index of arr to access the original number in nums and store in ans[]
        // Runtime  : 347ms     -> + 100.00%
        // Memory   : 74.62MB   -> + 100.00%
        public int[] SortJumbled(int[] mapping, int[] nums)
        {
            Func<int, int> f = (int x) =>
            {
                if (x == 0)
                {
                    return mapping[0];
                }
                int y = 0;
                int k = 1;
                int num = x;
                while (num != 0)
                {
                    int v = mapping[num % 10];
                    y = k * v + y;
                    k *= 10;
                    num /= 10;
                }
                return y;
            };

            int n = nums.Length;
            List<(int, int)> arr = new List<(int, int)>();
            for (int i = 0; i < n; ++i)
            {
                arr.Add((f(nums[i]), i));
            }
            arr.Sort();

            int[] ans = new int[n];
            for (int i = 0; i < n; ++i)
            {
                ans[i] = nums[arr[i].Item2];
            }
            return ans;
        }
        // ***************** End of 1st Method ******************
    }
}