namespace LeetCodeCSharp;
public class Subsets
{
    // ***************** 1st Method ******************
    // Approach : Using backtrack technique
    // Runtime  : 103ms       -> + 43.06%
    // Memory   : 45.78 MB    -> + 71.41%
    public IList<IList<int>> GetSubsets(int[] nums)
    {
        IList<IList<int>> ans = new List<IList<int>>();
        List<int> inner = new List<int>();

        Backtrack(nums, 0, ans, inner);
        return ans;
    }

    void Backtrack(int[] nums, int start, IList<IList<int>> ans, List<int> inner)
    {
        if (start == nums.Length)
        {
            ans.Add(new List<int>(inner));
            return;
        }

        Backtrack(nums, start + 1, ans, inner);
        inner.Add(nums[start]);
        Backtrack(nums, start + 1, ans, inner);
        inner.RemoveAt(inner.Count - 1);
    }
    // ***************** End of 1st Method ******************

}
