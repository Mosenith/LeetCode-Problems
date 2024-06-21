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

    // ***************** 2nd Method ******************
    // Approach 2: Optimized the 1st method by using 2 pointers for 2 loops
    // Find the total satisfied customers and unsatisfied customers in the first minutes
    // Then, in the second loop, find the maximum unsatisfied customers in minutes
    // Return satisfied + max
    // Runtime  : 4ms      -> + 48.61%
    // Memory   : 47.74MB  -> + 12.15%
    public static int maxSatisfied2(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        int unsatisfied = 0;
        for(int i=0; i<minutes && i<customers.length; i++) {
            if(grumpy[i] == 0) satisfied += customers[i];
            if(grumpy[i] == 1) unsatisfied += customers[i];
        }

        int max = unsatisfied;
        for(int i=minutes; i<customers.length; i++) {
            if(grumpy[i] == 0) satisfied += customers[i];
            if(grumpy[i] == 1) unsatisfied += customers[i];
            if(grumpy[i-minutes] == 1) unsatisfied -= customers[i-minutes];
            max = Math.max(max,unsatisfied);
        }
        return satisfied + max;
    }
    //  ***************** End of 2nd Method ******************
}
