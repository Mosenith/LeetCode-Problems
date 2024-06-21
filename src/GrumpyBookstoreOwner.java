public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;

        System.out.println(maxSatisfied(customers,grumpy,minutes));
    }

    // ***************** 1st Method ******************
    // Approach 1: Find the total satisfied customers
    // Iterate through the customers and grumpy array
    // If grumpy[i] == 0, add customers[i] to satisfied and set customers[i] to 0
    // Iterate through the customers array and find the maximum sum of customers in minutes
    // Return satisfied + max
    // Runtime  : 96ms      -> + 12.15%
    // Memory   : 45.82MB   -> + 93.92%
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        for(int i=0; i<customers.length; i++) {
            if(grumpy[i] == 0) {
                satisfied += customers[i];
                customers[i] = 0;
            }
        }

        int max = 0;
        for(int i=0; i+minutes<=customers.length; i++) {
            int tmpSum = calculateSum(customers,i,i+minutes);
            if(max < tmpSum) {
                max = tmpSum;
            }
        }
        return satisfied + max;
    }

    private static int calculateSum(int[] customers, int start, int end) {
        int sum = 0;
        for(int i=start; i<end; i++) {
            sum += customers[i];
        }
        return sum;
    }
    //  ***************** End of 1st Method ******************

}
