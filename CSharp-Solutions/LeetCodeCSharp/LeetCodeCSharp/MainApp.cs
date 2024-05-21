namespace LeetCodeCSharp;

public class MainApp
{
    static void Main(string[] args)
    {
        int[] nums = { 1, 2, 3 };

        Subsets s = new Subsets();
        IList<IList<int>> ans = s.GetSubsets(nums);

        foreach (IList<int> inner in ans)
        {
            Console.Write("[");
            foreach (int num in inner)
            {
                Console.Write(num + " ");
            }
            Console.WriteLine("]");
        }
    }
}