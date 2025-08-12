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
    private boolean solve(TreeNode p, TreeNode q)
    {
        // both are null
        if(p == null && q == null) 
        return true;
        
        //one null and other not null
        if(p == null || q == null) 
        return false;
        
        return p.val == q.val && solve(p.left, q.right) && solve(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) 
    {
        return solve(root.left, root.right);
    }
}