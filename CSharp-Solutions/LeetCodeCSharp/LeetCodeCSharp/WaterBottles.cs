using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LeetCodeCSharp
{
    public class WaterBottles
    {
        // ***************** 1st Method ******************
        // Runtime  : 13ms      -> + 100.00%
        // Memory   : 27.02MB   -> + 5.13%
        public int NumWaterBottles(int numBottles, int numExchange) {
            int totalBottles = numBottles;
            while(numBottles >= numExchange)
            {
                var curBottles = numBottles/numExchange;
                var leftover = numBottles%numExchange;
                totalBottles += curBottles;
                numBottles = leftover + curBottles;
            }
            return totalBottles;
        }
        // ***************** End of 1st Method ******************
    }
}