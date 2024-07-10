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
        // Approach 1: Use stack and check log[i]
        // if log[i] == "./" -> continue, if log[i] == "../" -> pop, 
        // if not "./" or "../" -> push to stack
        // Before pop check if stack is empty 
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