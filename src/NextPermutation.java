import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class NextPermutation {

    //    ***************** 1st Method ******************
    // Exceed Memory Limit
    // Not a bad learning though!
    public static void nextPermutation(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0,nums,ans);

        System.out.println("Before Rearranged: " + ans);

        Collections.sort(ans, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                int i=0, j=0;
                while(i<l1.size() && j<l2.size()) {
                    if(l1.get(i) != l2.get(j))
                        return l1.get(i).compareTo(l2.get(j));

                    i++;
                    j++;
                }

                return l1.get(0).compareTo(l2.get(0));
            }
        });

        int index = -1;
        for(int i=0; i<ans.size(); i++) {
            int match = 0;
            for(int j : ans.get(i)) {
                if(j != nums[match])
                    break;
                match++;
            }
            if(match == nums.length)
                index = i;
        }

        System.out.println("After Rearranged: " + ans);
        System.out.println(index);

//        return (index==ans.size()-1) ? ans.get(0) : ans.get(index+1);
//        List<Integer> list = new ArrayList<>();
//        if(index == 0)
//            list = ans.get(1);
//        else
//            list = (index==ans.size()-1) ? ans.get(0) : ans.get(index+1);
        List<Integer> list = (index==ans.size()-1) ? ans.get(0) : ans.get(index+1);

//        nums = list.stream()
//                .mapToInt(Integer::intValue)
//                .toArray();
        int k=0;
        for(int i : list) {
            nums[k++] = i;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if(index == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for(int i=0; i<nums.length; i++) {
                cur.add(nums[i]);
            }
            ans.add(cur);
            return;
        }

        for(int i=index; i<nums.length; i++) {
            swap(i,index,nums);
            recurPermute(index+1, nums, ans);
            swap(i,index,nums);
        }
    }

    private static void swap(int i, int index, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
    //  ***************** End of 1st Method ******************

    //    ***************** 2nd Method ******************
    // Runtime  : 0ms        -> + 100%
    // Memory   : 42.6MB      -> + 63.45%

    public static void nextPermutation2(int[] nums) {
        int n = nums.length;
        int i = n - 2;
//        System.out.println(n + " : " + i);

        for (; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i >= 0) {
            for (int j = n - 1; j > i; --j) {
                System.out.println(nums[j] + " : " + nums[i]);
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }

        System.out.println("**************** len= " + n +  ", i= " + i + " *****************");
        System.out.println(Arrays.toString(nums));

        for (int j = i + 1, k = n - 1; j < k; ++j, --k) {
            swap(nums, j, k);
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
    //  ***************** End of 2nd Method ******************

    //    ***************** 3rd Method ******************
    // Runtime  : 1ms        -> + 60.28%
    // Memory   : 42.7MB      -> + 54.76%
    public static void nextPermutation3(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        for(int j=len-1; i>=0; i--,j--){
            if(nums[i] < nums[j]) {
                mySwap(nums, i, findMinDiff(nums,i));
                System.out.println(Arrays.toString(nums));
                break;
            }
        }
        System.out.println(i);

        for(int j=i+1; j<=len-1; j++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            int k = j;
            while(k<=len-1) {
                if(min > nums[k]) {
                    min = nums[k];
                    minIndex = k;
                }
                k++;
            }

            mySwap(nums, j, minIndex);
            System.out.println(Arrays.toString(nums));
        }
    }

    private static int findMinDiff(int[] nums, int i) {
        int ret = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int j=i+1; j<nums.length; j++) {
            if(nums[i] < nums[j] && minDiff > (nums[j]-nums[i])) {
                minDiff = nums[j]-nums[i];
                ret = j;
            }
        }
        return ret;
    }
    private static void mySwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //  ***************** End of 3rd Method ******************

    public static void main(String[] args) {
        // [1, 3, 2]
//        int[] nums = {1,2,3};

        // [3,1,2]
//        int[] nums = {2,3,1};

        // [1, 2, 3]
//        int[] nums = {3,2,1};

        // [1,5,1]
//        int[] nums = {1,1,5};

        // [5,1,1]
//        int[] nums = {1,5,1};

        // [5,5,2,3,4,7]
        int[] nums = {5,4,7,5,3,2};

        // [1, 1, 0, 1, 3, 2, 1, 0]
        // [1, 1, 0, 2, 0, 1, 1, 3]
//        int[] nums = {1,1,0,1,3,2,0,1};

        // [4, 3, 3, 1, 2, 5]
//        int[] nums = {4,3,2,5,3,1};

        nextPermutation3(nums);
        System.out.println("Final : " + Arrays.toString(nums));

//        System.out.println(Arrays.toString(nums));
//        nextPermutation2(nums);
//        System.out.println(Arrays.toString(nums));
    }


}
