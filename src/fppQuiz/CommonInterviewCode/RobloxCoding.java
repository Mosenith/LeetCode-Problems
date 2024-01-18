package fppQuiz.CommonInterviewCode;

public class RobloxCoding {
    public static void main(String[] args) {
        int finish = 23;
        int[] scooters = {7,4,14};

        // 17, 14,24
        // 7 -> 14 -> 9 = 16
    }

    public int maxDistanceTravel(int finish, int[] scooters) {
        int maxDis = 0;

        util(finish,scooters,maxDis,0);

        return maxDis;
    }

    private void util(int finish, int[] scooters, int maxDis, int start) {
        if(start > scooters.length) return;

        for(int i=start; i<scooters.length; i++) {
            int cur = 0;
            int next = i+1;
//            while(scooters[] < finish && )
        }
    }
}
