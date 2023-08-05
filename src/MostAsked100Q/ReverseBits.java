package MostAsked100Q;

public class ReverseBits {
    public static void main(String[] args) {
        // 43261596 = 00000010100101000001111010011100
        // => 00000010100101000001111010011100 = 964176192
        int n = 8;

        System.out.println("Final -> " + reverseBits(100));

//        System.out.println(Integer.parseUnsignedInt(String.valueOf(n)));
    }
    // ***************** 1st Method : HashMap ******************
    // Approach 1: 31 means shift it all the way to the left
    // First, res is all 0 (32bits). When (n&1) -> we get the result
    // To put the result in res, we use |(OR) operation. res |= (n&1)
    // then we need to shift that the leftest => res << (31-i)
    // i is the current pos, from 0 to 31
    // we use & 1 => to know the cur digit is 0 or 1
    // Runtime  : 0ms           -> + 100%
    // Memory   : 40.79 MB        -> + 79.32%
    // Time : O(1), Space: O(1)
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            System.out.println(n & 1);
            res |= ((n & 1) << (31 - i));
            n >>>= 1;
        }
        return res;
    }

    // Step
    // 1. Find the least significant bits by using n & 1
    // 2. Left shift significant bits by total bits - curPosition(i) => x
    // 3. result = result | x => get it to result
    // 4. Shift the input n to right at every loop

}
