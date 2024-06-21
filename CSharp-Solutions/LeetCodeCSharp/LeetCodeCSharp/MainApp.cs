namespace LeetCodeCSharp;

public class MainApp
{
    static void Main(string[] args)
    {
        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;

        GrumpyBookstoreOwner owner = new GrumpyBookstoreOwner();
        System.Console.WriteLine(owner.MaxSatisfied2(customers, grumpy, minutes));
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