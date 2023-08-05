package BacktrackingAlgorithm.DivideAndConquer;

// Java code to demonstrate Divide and
// Conquer Algorithm
public class FindMinAndMax {
    // Driver Code
    public static void main(String[] args)
    {
        // Defining the variables
        int min, max;

        // Initializing the array
        int a[] = { 70, 250, 50, 80, 140, 12, 14 };

        // Recursion - DAC_Max function called
        max = DAC_Max(a, 0, 7);

        // Recursion - DAC_Max function called
        min = DAC_Min(a, 0, 7);

        System.out.printf("The minimum number in " +
                "a given array is : %d\n", min);
        System.out.printf("The maximum number in " +
                "a given array is : %d", max);
    }

    private static int DAC_Min(int[] a, int index, int len) {
        int min;

        if(len == 1) {
            return a[index];
        }
        if(index >= len - 2) {
            if(a[index] < a[index+1])
                return a[index];
            else
                return a[index+1];
        }

        min = DAC_Min(a, index+1, len);

        if(a[index] < min)
            return a[index];
        else
            return min;
    }

    // Function to find the maximum num in a given array.
    private static int DAC_Max(int[] a, int index, int len) {
        int max;
        // base case
        if(len == 1) {
            return a[index];
        }
        if (index >= len - 2)
        {
            if (a[index] > a[index + 1])
                return a[index];
            else
                return a[index + 1];
        }

        max = DAC_Max(a, index + 1, len);

        if (a[index] > max)
            return a[index];
        else
            return max;
    }
}
