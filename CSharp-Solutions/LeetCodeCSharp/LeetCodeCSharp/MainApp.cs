namespace LeetCodeCSharp
{
    public class MainApp
    {
        static void Main(string[] args)
        {
            FindCityWithSmallestNumberNeighborsAtThresholdDistance city = new FindCityWithSmallestNumberNeighborsAtThresholdDistance();
            int[][] edges = new int[][] { new int[] { 2, 3, 1 }, new int[] { 1, 2, 1 }, new int[] { 0, 1, 3 }, new int[] { 1, 3, 4 } };

            int result = city.FindTheCity(4, edges, 4);
            System.Console.WriteLine(string.Join(", ", result));
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

