using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Numerics;
using System.Threading.Tasks;

namespace LeetCodeCSharp
{
    public class FindWinnerOfTheCircularGame
    {
        public int FindTheWinner(int n, int k)
        {   
            int ans = 0;
            for(int i=1; i<=n; i++)
            {
                ans = (ans + k) % i;  // It's the heart of the solution.
            }
        
            return ans+1;
        }
    }
}