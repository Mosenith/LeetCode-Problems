namespace LeetCodeCSharp
{
    public class MainApp
    {
        static void Main(string[] args)
        {
            SortTheJumbledNumbers jumbledNumbers = new SortTheJumbledNumbers();
            int[] mapping = {8,9,4,0,2,1,3,5,7,6};
            int[] nums = {991,338,38};

            int[] result = jumbledNumbers.SortJumbled(mapping, nums);
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

