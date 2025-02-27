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

    private int prev, minDistance;
    private void solve(TreeNode root)
    {
        if(root == null)
        return;
        
        solve(root.left);
        
        minDistance = Math.min(minDistance, root.val - prev);
        prev = root.val;

        solve(root.right);
    }
    
    public int minDiffInBST(TreeNode root) 
    {
        prev = Integer.MIN_VALUE / 2;
        minDistance = Integer.MAX_VALUE;

        solve(root);
        return minDistance;
    }
}