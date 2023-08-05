import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rtnList = new ArrayList<>();

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        if(nums[0] <= Math.pow(-10,9) || nums[nums.length-1] >= Math.pow(10,9))
            return rtnList;

        for(int leftest=0; leftest<nums.length - 3; leftest++) {
            if(leftest>0 && nums[leftest] == nums[leftest-1])
                continue;
            for(int rightest = nums.length-1; rightest>=0 && rightest != leftest; rightest--) {
                if(rightest < nums.length-1 && nums[rightest] == nums[rightest+1])
                    continue;

                int secLeft = leftest+1;
                int secRight = rightest-1;

                if(nums[leftest] >= Math.pow(10,9))
                    return rtnList;
                while (secLeft < secRight) {
                    long sum = nums[leftest] + nums[secLeft] + nums[secRight] + nums[rightest];

//                    System.out.println(sum + " : " + target);
//                    System.out.println(secLeft + ":" + secRight);
                    if(sum == target) {
//                        System.out.println("Here");
                        List<Integer> innerList = new ArrayList<Integer>();
                        innerList.add(nums[leftest]);
                        innerList.add(nums[secLeft]);
                        innerList.add(nums[secRight]);
                        innerList.add(nums[rightest]);

//                        System.out.println(innerList);
                        // checkDistinct not work
//                        System.out.println(checkDistinct(rtnList, innerList));
                        if(rtnList.isEmpty() || checkDistinct(rtnList, innerList)) {
//                            System.out.println("Here: " + innerList);
//                            System.out.println(nums[secLeft] + " : " + nums[secRight]);
                            rtnList.add(innerList);
                        }
//                        System.out.println("Here: " + innerList);
                        secLeft++;
                    } else if(sum < target) {
                        secLeft++;
                    } else {
                        secRight--;
                    }
//                    System.out.println(rtnList);
//                    System.out.println(secLeft + ":" + secRight);
                    if(nums[secLeft] > nums[secRight] || secLeft == secRight)
                        break;
                }

//                System.out.println("OUT OF LOOP");
            }
        }
        return rtnList;
    }

    public static Boolean checkDistinct(List<List<Integer>> rtnList, List<Integer> innerList) {
        for(int i=0; i<rtnList.size(); i++) {
            int dup = 0;
            for(int j=0; j<innerList.size(); j++) {
                if(rtnList.get(i).get(j).equals(innerList.get(j)))
                    dup++;
            }

//            if(innerList.get(0) == -1 && innerList.get(1) == -1) {
//                System.out.println(rtnList.get(i));
//                System.out.print("Size = " + rtnList.size() + " : " +  innerList.get(2));
//                System.out.println(" - " + innerList.get(3));
//                System.out.println("dup = " + dup);
//            }

            if(dup >= 4)
                return false;
        }

        return true;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1, l = n - 1;
                while (k < l) {
                    if ((long) nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        ++k;
                        --l;
                        while (k < n && nums[k] == nums[k - 1]) {
                            ++k;
                        }
                        while (l > j && nums[l] == nums[l + 1]) {
                            --l;
                        }
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        ++k;
                    } else {
                        --l;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1,0,-1,0,-2,2};
//        int target = 0;
//        int[] nums = {2,2,2,2,2};
//        int target = 8;
//        int[] nums = {1,0,-1,0,-2,2};
//        int target = 0;
//        int[] nums = {-2,-1,-1,1,1,2,2};
//        int target = 0;
//        int[] nums = {-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492};
//        int target = 1682;
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;

        System.out.println("Final = " + fourSum(nums,target));
        System.out.println(fourSum(nums,target).size());
    }
}
