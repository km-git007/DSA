/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void solve(TreeNode LeftNode, TreeNode RightNode, int level)
    {
        if(LeftNode == null || RightNode == null)
        return;

        if(level % 2 == 1)
        {
            int temp = LeftNode.val;
            LeftNode.val = RightNode.val;
            RightNode.val = temp;
        }

        solve(LeftNode.left, RightNode.right, level + 1);
        solve(LeftNode.right, RightNode.left, level + 1);
    }

    public TreeNode reverseOddLevels(TreeNode root) 
    {
        solve(root.left, root.right, 1);
        return root;
    }
}