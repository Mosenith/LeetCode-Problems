public class AverageWaitingTime {
    // ***************** 1st Method ******************
    // Approach 1: Loop through customers, if customer[i][0] > time, time = customer[i][0]
    // Add customer[i][1] to time and add time - customer[i][0] to waitTime
    // Return waitTime / n
    // Runtime  : 3ms         -> + 88.64%
    // Memory   : 72.78MB     -> + 55.05%
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        int time = 0;
        double waitTime = 0;
        for(int i=0; i<n; i++) {
            if(customers[i][0] > time) {
                time = customers[i][0];
            }
            time += customers[i][1];
            waitTime += time - customers[i][0];
        }
        return waitTime / n;
    }
    // ***************** End of 1st Method ******************
}
