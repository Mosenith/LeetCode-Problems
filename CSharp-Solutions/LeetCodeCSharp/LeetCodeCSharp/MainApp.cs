namespace LeetCodeCSharp
{
    public class MainApp
    {
        static void Main(string[] args)
        {
            AverageWaitingTime ans = new AverageWaitingTime();
            // int[][] intervals = new int[][] { new int[] { 5, 2 }, new int[] { 5, 4 }, new int[] { 10, 3 }, new int[] { 20, 1 } };
            int[][] intervals = new int[][] { new int[] { 1, 2 }, new int[] { 2, 5 }, new int[] { 4, 3 } };
            System.Console.WriteLine(ans.AverageWaitingTimeCal(intervals));
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

