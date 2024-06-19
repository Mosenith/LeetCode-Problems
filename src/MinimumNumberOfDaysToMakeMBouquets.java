import java.util.*;

public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;

        System.out.println(minDays(bloomDay,m,k));
    }

//    public static int minDays(int[] bloomDay, int m, int k) {
//        if(m * k > bloomDay.length) return -1;
//
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for(int i=0; i<bloomDay.length; i++) {
//            map.put(bloomDay[i], map.getOrDefault(bloomDay[i], new ArrayList<>()));
//            map.get(bloomDay[i]).add(i);
//        }
//        System.out.println(map);
//
//        String[] dayList = new String[bloomDay.length];
//        Arrays.sort(bloomDay);
//        for(int n : bloomDay) {
//            List<Integer> c = map.getOrDefault(n, new ArrayList<>());
//            System.out.println(c);
//            for (Integer integer : c) {
//                dayList[integer] = "x";
//            }
//
//            if(checkFormBouquet(dayList,m,k)) {
//                return n;
//            }
//            map.remove(n);
//            System.out.println("****\n");
//        }
//
//        return -1;
//    }
//
//    private static boolean checkFormBouquet(String[] dayList, int m, int k) {
//        int count = 0;
//        for(int i=0; i<dayList.length && m>0;) {
//            if(dayList[i] == null) {
//                i++;
//                continue;
//            }
//            while(i<dayList.length && dayList[i] != null && dayList[i].equals("x")) {
//                count++;
//                i++;
//            }
//            if(count == k) {
//                m--;
//            }
//        }
//
//        return m==0;
//    }


    public static int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length) return -1;

        int left = 1;
        int right = 1000000000;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(canMakeBouquet(bloomDay,m,k,mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canMakeBouquet(int[] bloomDay, int m, int k, int mid) {
        int count = 0;
        int bouquet = 0;
        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= mid) {
                count++;
                if(count == k) {
                    bouquet++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return bouquet >= m;
    }
}
