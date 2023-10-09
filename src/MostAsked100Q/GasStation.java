package MostAsked100Q;

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
        int[] gas = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};

        System.out.println(canCompleteCircuit(gas,cost));
    }

    // ***************** 1st Method ******************
    // Approach 1: Brutal Force - Worked
    // Time Limit Exceeded
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // find start index -> gas[i] > cost[i]
        for(int i=0; i<gas.length; i++) {
            System.out.println("check i = " + i);
            if(gas[i] >= cost[i]) {
                int tmp = helper(i, gas, cost);
                if(tmp != -1)
                    return tmp;
            }
            System.out.println("*******");
        }

        return -1;
    }

    private static int helper(int start, int[] gas, int[] cost) {
        System.out.println("**** start = " + start + " ****");

        int index = start + 1;
        int tank = gas[start];
        int costToTravel = cost[start];
        while(index != start) {
            if(index == gas.length) {
                index = 0;
            }

            if(tank < costToTravel) {
                System.out.println("Tank less than Cost to Travel!");
                return -1;
            }

            tank += (gas[index] - costToTravel);
            costToTravel = cost[index];

            System.out.println("i = " + index + " : "
                    + gas[index] + " vs " + cost[index]);
            if(index == start) break;
            index++;
        }

        return (tank >= costToTravel) ? start : -1;
    }
}
