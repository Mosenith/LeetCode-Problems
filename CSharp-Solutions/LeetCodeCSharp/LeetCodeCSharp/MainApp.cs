namespace LeetCodeCSharp
{
    public class MainApp
    {
        static void Main(string[] args)
        {
            FindWinnerOfTheCircularGame ans = new FindWinnerOfTheCircularGame();
            System.Console.WriteLine(ans.FindTheWinner(6,5));
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

