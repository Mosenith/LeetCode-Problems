namespace LeetCodeCSharp;

public class MainApp {
    static void Main(string[] args) {
        int[] deck = { -9,-43,24,-23,-16,-30,-38,-30 };
        
        Console.WriteLine(LargestPositiveIntegerThatExistsWithItsNegative.findMaxK(deck));
    }
}