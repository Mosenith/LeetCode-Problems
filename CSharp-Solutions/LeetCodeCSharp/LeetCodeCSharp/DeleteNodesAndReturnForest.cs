using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LeetCodeCSharp
{
    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public class DeleteNodesAndReturnForest
    {
        public void PrintNode(TreeNode root)
        {
            if (root == null)
                return;

            Console.WriteLine(root.val);
            PrintNode(root.left);
            PrintNode(root.right);
        }

        // ***************** 1st Method ******************
        // Approach 1: Init HashSet to store to_delete values
        // Use DFS to traverse the tree and check if the current node is in the set
        // Update the left and right node with the return value of the recursive call
        // If it is, add the left(if left!=null) and right(if right!=null) node to the ans list and return null
        // If it is not, return the current node
        // Runtime  : 129ms     -> + 14.29%
        // Memory   : 50.86MB   -> + 18.68%
        public IList<TreeNode> DelNodes(TreeNode root, int[] to_delete)
        {
            IList<TreeNode> ans = new List<TreeNode>();
            HashSet<int> set = new HashSet<int>();

            foreach (int i in to_delete)
            {
                set.Add(i);
            }

            dfsDelete(root, ans, set);
            if (!set.Contains(root.val))
                ans.Add(root);

            return ans;
        }

        private TreeNode dfsDelete(TreeNode root, IList<TreeNode> ans, HashSet<int> set)
        {
            if (root == null)
                return null;

            root.left = dfsDelete(root.left, ans, set);
            root.right = dfsDelete(root.right, ans, set);

            if (set.Contains(root.val))
            {
                if (root.left != null)
                    ans.Add(root.left);
                if (root.right != null)
                    ans.Add(root.right);
                return null;
            }

            return root;
        }
        // ***************** End of 1st Method ******************

        // ***************** 2nd Method ******************
        // Approach 2: Init HashSet to store to_delete values and List to store the result
        // Check if the root is not in the set, add it to the result list
        // Traverse the tree and check if the current node is in the set
        // If it is, add the left(if left!=null) and right(if right!=null) node to the ans list and return null
        // If it is not, return the current node
        // Runtime  : 113ms     -> + 76.92%
        // Memory   : 50.64MB   -> + 25.27%
        public IList<TreeNode> result = new List<TreeNode>();
        public IList<TreeNode> DelNodes2(TreeNode root, int[] to_delete)
        {
            var d = new HashSet<int>(to_delete);
            if (root != null && !d.Contains(root.val))
            {
                result.Add(root);
            }

            Traverse(null, root, true, d);
            Traverse(null, root, false, d);

            return result;
        }

        private void Traverse(TreeNode parent, TreeNode current, bool left, HashSet<int> d)
        {
            if (current == null)
            {
                return;
            }

            Traverse(current, current.left, true, d);
            Traverse(current, current.right, false, d);

            if (d.Contains(current.val))
            {
                if (current.left != null)
                {
                    result.Add(current.left);
                }

                if (current.right != null)
                {
                    result.Add(current.right);
                }

                if (parent != null)
                {
                    if (left)
                    {
                        parent.left = null;
                    }
                    else
                    {
                        parent.right = null;
                    }
                }
                d.Remove(current.val);
            }
        }
        // ***************** End of 2nd Method ******************
    }
}