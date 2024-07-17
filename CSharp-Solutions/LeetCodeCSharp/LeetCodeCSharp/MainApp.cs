namespace LeetCodeCSharp
{
    public class MainApp
    {
        static void Main(string[] args)
        {
            DeleteNodesAndReturnForest forest = new DeleteNodesAndReturnForest();
            int[] nums = {3,5};

            var result = forest.DelNodes(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))), nums);
            System.Console.WriteLine(result.ToString());
        }

        private static IEnumerable<object> GetEvenNumbers(int v)
        {
            for (int i = 0; i <= v; i++)
            {
                if (i % 2 == 0)
                {
                    yield return i;
                }
            }
        }
    }
}

