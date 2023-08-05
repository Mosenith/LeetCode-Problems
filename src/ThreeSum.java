import java.awt.*;
import java.util.*;
import java.util.List;

public class ThreeSum {
    /*
    // Need to revise
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplet = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(nums[i]);
                    innerList.add(nums[j]);
                    innerList.add(nums[k]);
                    if(nums[i] + nums[j] + nums[k] == 0 && checkElement(triplet,innerList) != 0) {
                        triplet.add(innerList);
                    }
                }
            }
        }

        System.out.println(triplet);

        return triplet;
    }
    public static void checkzero (List<Integer> innerList) {
        int countZero = Collections.frequency(innerList, 0);

        if(countZero < innerList.size()) {
            innerList.remove("0");
            System.out.println("After" + innerList);
        }
    }
    public static int checkElement (List<List<Integer>> triplet, List<Integer> innerList) {
        for(int i=0; i<triplet.size(); i++) {
            for (int j = 0; j < 3; j++) {
                if (triplet.get(i).containsAll(innerList)) {
                    return 0;
                }
            }
        }

        return 1;
    }
    */
    // final

    // ***************** 1st Method ******************
    // Approach : Optimized - Sort Array first
    // Runtime  : 33ms        -> + 97.93%
    // Memory   : 50.54MB      -> + 82.06%
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> triplet = new ArrayList<>();

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        for(int i=0; i<nums.length-2 && nums[i] <= 0; i++) {
            if(i>0 && nums[i] == nums[i-1])
                continue;

            int j=i+1;
            int k=nums.length-1;
            while(k > j) {
                int current = nums[i] + nums[j] + nums [k];
                if(current == 0) {
                    triplet.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while(j<nums.length && nums[j] == nums[j-1]){
                        ++j;
                    }
                    while(k>j && nums[k] == nums[k+1]) {
                        --k;
                    }
                } else if(current < 0) {
                    j++;
                } else {
                    k--;
                }

            }
        }

        return triplet;
    }
    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4}; // [[-1,-1,2],[-1,0,1]]
        int[] input2 = {0,0,0,0};
        int[] input3 = {3,0,-2,-1,1,0,2,0};
        int[] input4 = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        int[] input5 = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};

        // target = 0
        System.out.println(threeSum2(input5));

        List<List<Integer>> a = new ArrayList();
        for(int i=1;i<8; i++){
            // your logic here make use of Arrays.asList()
            a.add(Arrays.asList(i, i+1));
        }

    }
}
