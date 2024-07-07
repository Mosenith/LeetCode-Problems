public class WaterBottles {
    public static void main(String[] args) {
        int numBottles = 9, numExchange = 3;

        System.out.println(numWaterBottles(numBottles, numExchange));
    }

    // ***************** 1st Method ******************
    // Approach 1: First set totalWaterBottles to numBottles, and add numBottles/numExchange to totalWaterBottles
    // Update numBottles to numBottles/numExchange + numBottles%numExchange
    // Runtime  : 0ms       -> + 100.00%
    // Memory   : 39.90MB   -> + 91.54%
    public static int numWaterBottles(int numBottles, int numExchange) {
        int totalWaterBottles = numBottles;

        while(numBottles >= numExchange) {
            totalWaterBottles += (numBottles/numExchange);
            numBottles = (numBottles/numExchange) + (numBottles%numExchange);
        }
        return totalWaterBottles;
    }
    // ***************** End of 1st Method ******************
}
