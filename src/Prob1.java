import java.util.Arrays;

public class Prob1 {

//    Given an integer array of length N, write a function that
//    selects any two distinct elements from the array, calculates their
//    sum, and returns the values of the pair that results in the smallest sum.
    // [1,2,3,4] -> 1,2
    public int[] smallestPair(int[] arr) {
        int[] ans = new int[2];

        // if arr has less than 2 elements return ans
        if(arr.length < 2) return ans;

        // sort array
        Arrays.sort(arr);

        // assuming that array has >=2 2 elements
        ans[0] = arr[0];

        // in case there are duplicate element with 0 index
        for(int i=1; i<arr.length; i++) {
            if(arr[i] != ans[0]) {
                ans[1] = arr[i];
                break;
            }
        }

        return ans;
    }

//    13 - 1,
    // 14 -
//    Write a function to determine if a given integer N is a prime number.
//    The function should return true if N is a prime number, and false otherwise.
    public boolean isPrime(int n) {
        // prime num > 1
        if(n <= 1) return false;

        for(int i=2; i<n; i++) {
            // Prime can't be divided by other element except 1 & itself(n)
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }


//    Write a function to find and return the longest palindromic substring in a given string,
//    where the maximum length of the string is 1000. A palindrome is a string that reads the same
//    forwards and backwards.
    // babad -> bab & aba
    // baba
    // 0-4, substr - 0-4, 0-3, 0-2, 0-1
    public String longestPalindrome(String s) {
        // check if s is Palindrome, if so return s cos s is the longest
        if(isPalindrome(s)) return s;

        String finalAns = "";
        for(int i=0; i<s.length(); i++) {
            // find all possible substring of s & check isPalindrome
            for(int j=0; j<s.length(); j++) {
                String curStr = s.substring(i,s.length()-j);
                if(isPalindrome(curStr)) {
                    if(finalAns.equals("")) {
                        finalAns = curStr;
                    } else {
                        finalAns = (finalAns.length() < curStr.length()) ? curStr : finalAns;
                    }
                }
            }
        }

        return finalAns;
    }

    private boolean isPalindrome(String s) {
        // using 2 pointers
        for(int i=0, j=s.length()-1; i>j; i++, j--) {
            // not the same -> false
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
