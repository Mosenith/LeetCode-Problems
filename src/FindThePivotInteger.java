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
    // Memory   : 40.50MB      -> + 60.79%
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

    // ***************** 2nd Method ******************
    // Approach 2: Compare sum from the left & sum from the right
    // From left, (1+x)(x)/2 and from right, (x+n)(#num of elements)/2
    // Basically, just compare (1+x)(x) with (x+n)(#num of elements)
    // If equal just return x, otherwise out of loop return -1
    // Runtime  : 1ms           -> + 61.93%
    // Memory   : 40.11MB       -> + 92.55%
    public static int pivotInteger2(int n) {
        for (int x = 1; x <= n; ++x) {
            if ((1 + x) * x == (x + n) * (n - x + 1)) {
                return x;
            }
        }
        return -1;
    }
    //  ***************** End of 2nd Method ******************

}
