public class FindThePivotInteger {
    public static void main(String[] args) {
        int n = 8; // 6
        // edge case n= 3 -> -1, need to check rightSum != n

        System.out.println(pivotInteger(4));
    }

    // ***************** 1st Method ******************
    // Approach 1: Base case n=1 -> return 1
    // Then use 2 pointer from 1 to n while keeping track of leftSum & rightSum
    // Loop with condition l<=r and if l=r break
    // Each iteration if leftSum<rightSum, +l to leftSum then l++
    // Otherwise, +r to rightSum then r--
    // Out of loop, if leftSum==rightSum && rightSum!=n, return l, otherwise -1
    // Runtime  : 1ms          -> + 61.93%
    // Memory   : 40.11MB      -> + 92.55%
    public static int pivotInteger(int n) {
        if(n == 1) return 1;
        int leftSum = 1, rightSum = n;
        int l=2, r=n-1;

        while(l <= r)  {
            if(leftSum < rightSum) {
                leftSum += l;
                l++;
            } else {
                rightSum += r;
                r--;
            }
            if(l == r) break;
        }

        return (leftSum==rightSum && rightSum!=n) ? l : -1;
    }
    //  ***************** End of 1st Method ******************

}
