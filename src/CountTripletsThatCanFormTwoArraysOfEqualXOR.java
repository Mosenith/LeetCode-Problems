public class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7};
        System.out.println(countTriplets(nums));
    }

    // ***************** 1st Method ******************
    // Approach 1: Split arr into 2 non-empty arrays
    // So that the xor of the first array is equal to the xor of the second array
    // equivalent to searching for sub-array with xor = 0
    // Runtime  : 2ms     -> + 77.44%
    // Memory   : 40.97MB -> + 68.72%
    public static int countTriplets(int[] arr) {
        int count = 0;

        // split arr into 2 non-empty arrays
        for(int i=0; i<arr.length-1; i++) {
            int xor = arr[i];
            for(int j=i+1; j<arr.length; j++) {
                xor ^= arr[j];
                if(xor == 0) {
                    count += j-i;
                }
            }
        }

        return count;
    }
    // ***************** End of 1st Method ******************

}
