using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LeetCodeCSharp
{
    public class AverageWaitingTime
    {
        // ***************** 1st Method ******************
        // Runtime  : 419ms     -> + 100.00%
        // Memory   : 79.80MB   -> + 66.67%
        public double AverageWaitingTimeCal(int[][] customers)
        {
            double time = 0.0;
            int start = 0;
            int end = 0;

            for (int i = 0; i < customers.Length; i++)
            {
                start = customers[i][0];
                if(end == 0 || end < start) end = start;
                end += customers[i][1];
                time += end - start;
            }

            return time / customers.Length;
        }
        // ***************** End of 1st Method ******************
    }
}