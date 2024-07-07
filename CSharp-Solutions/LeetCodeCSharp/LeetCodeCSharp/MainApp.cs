namespace LeetCodeCSharp;

public class MainApp
{
    static void Main(string[] args)
    {
        
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