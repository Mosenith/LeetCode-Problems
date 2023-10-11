package MostAsked100Q;

import java.util.Arrays;

public class GasStation {
    public static void main(String[] args) {
        // out: 3
//        int[] gas = {1,2,3,4,5}; // 15
//        int[] cost = {3,4,5,1,2}; // 15

        // find the sum of gas & cost from start till start

        // out: -1
//        int[] gas = {2,3,4};
//        int[] cost = {3,4,3};

        // out: 4
//        int[] gas = {5,1,2,3,4};
//        int[] cost = {4,4,1,5,1};

        int[] gas = {3,1,1};
        int[] cost = {1,2,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    // ***************** 1st Method ******************
    // Approach 1: Brutal Force - Worked
    // Time Limit Exceeded
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // find start index -> gas[i] > cost[i]
        for(int i=0; i<gas.length; i++) {
            if(gas[i] >= cost[i]) {
                int totalGas = sum(i, gas, cost);

                if(totalGas != -1) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static int sum(int start, int[] gas, int[] cost) {
        int curTank = gas[start];
        int index = (start + 1 == gas.length) ? 0 : start + 1;

        while(index != start) {
            if((index == 0 && curTank < cost[cost.length-1]) ||
                    index > 0 && curTank < cost[index-1]) {
                return -1;
            }
            if(index == 0) {
                curTank += (gas[index] - cost[cost.length-1]);
            } else {
                curTank += (gas[index] - cost[index-1]);
            }

            index++;
            if(index == gas.length) {
                index = 0;
            }
        }

        if(index == 0) {
            return (curTank < cost[cost.length-1]) ? -1 : 1;
        }
        return (curTank < cost[index-1] ? -1 : 1);
    }
    // ***************** End of 1st Method ******************
}
