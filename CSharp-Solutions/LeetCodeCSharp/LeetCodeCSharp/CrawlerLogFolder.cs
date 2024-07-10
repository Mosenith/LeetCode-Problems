using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LeetCodeCSharp
{
    public class CrawlerLogFolder
    {
        // ***************** 1st Method ******************
        // Approach : Loop through the customers and grumpy arrays to find the satisfied customers
        // If customer[i]=0, add it to the satisfiedCustomer and set customer[i]=0
        // Loop through the customers array for case owner not grumpy for consecutive minutes (curSum)
        // Add cursum to the satisfiedCustomer and return the result
        // Runtime  : 58ms      -> + 67.12%
        // Memory   : 40.30MB   -> + 84.93%
        public int MinOperations(string[] logs)
        {
            Stack<string> stk = new Stack<string>();

            for (int i = 0; i < logs.Length; i++)
            {
                if (logs[i].Equals("./")) continue;
                if (logs[i].Equals("../") && stk.Count() > 0) stk.Pop();
                if (!logs[i].Equals("./") && !logs[i].Equals("../")) stk.Push(logs[i]);
            }

            return stk.Count();
        }
        // ***************** End of 1st Method ******************
    }
}