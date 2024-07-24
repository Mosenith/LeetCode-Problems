using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LeetCodeCSharp
{
    public class SortArrayByIncreasingFrequency
    {
        // ***************** 1st Method ******************
        // Approach 1: Using Dictionary and Sort
        // Create a dictionary to store the frequency of each number
        // Sort the dictionary by frequency in descending order and then by number in ascending order
        // Create a new array to store the sorted numbers
        // Reverse the sorted array to get the result
        // Runtime  : 106ms     -> + 79.01%
        // Memory   : 47.94MB   -> + 54.32%
        public int[] FrequencySort(int[] nums)
        {
            Dictionary<int, int> dict = new Dictionary<int, int>();

            for (int i = 0; i < nums.Length; i++)
            {
                int tmp = nums[i];
                if (dict.ContainsKey(tmp))
                {
                    int cur = dict[tmp] + 1;
                    dict.Remove(tmp);
                    dict.Add(tmp, cur);
                }
                else
                {
                    dict.Add(tmp, 1);
                }
            }

            var sortedDictionary = dict.OrderByDescending(x => x.Value)
                                     .ThenBy(x => x.Key);
            int[] ans = new int[nums.Length];
            int j = 0;
            foreach (var kvp in sortedDictionary)
            {
                int k = kvp.Key;
                int v = kvp.Value;
                while (v > 0)
                {
                    ans[j++] = k;
                    v--;
                }
            }
            Array.Reverse(ans);
            return ans;
        }
        // ***************** End of 1st Method ******************
    }
}