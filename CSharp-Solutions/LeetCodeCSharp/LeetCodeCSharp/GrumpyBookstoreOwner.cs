using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LeetCodeCSharp
{
    public class GrumpyBookstoreOwner
    {
        // ***************** 1st Method ******************
        // Approach : Loop through the customers and grumpy arrays to find the satisfied customers
        // If customer[i]=0, add it to the satisfiedCustomer and set customer[i]=0
        // Loop through the customers array for case owner not grumpy for consecutive minutes (curSum)
        // Add cursum to the satisfiedCustomer and return the result
        // Runtime  : 183ms      -> + 25.00%
        // Memory   : 51.06MB    -> + 93.75
        public int MaxSatisfied(int[] customers, int[] grumpy, int minutes)
        {
            int satisfiedCustomer = 0;
            for (int i = 0; i < grumpy.Length; i++)
            {
                if (grumpy[i] == 0)
                {
                    satisfiedCustomer += customers[i];
                    customers[i] = 0;
                }
            }

            int curSum = 0;
            for (int i = 0; i + minutes <= customers.Length; i++)
            {
                int end = i + minutes;
                int tmpSum = CalculateSum(customers, i, end);
                if (curSum < tmpSum)
                {
                    curSum = tmpSum;
                }
            }
            return satisfiedCustomer + curSum;
        }

        private int CalculateSum(int[] customers, int start, int end)
        {
            int sum = 0;
            for (int i = start; i < end; i++)
            {
                sum += customers[i];
            }
            return sum;
        }
        // ***************** End of 1st Method ******************

    }
}