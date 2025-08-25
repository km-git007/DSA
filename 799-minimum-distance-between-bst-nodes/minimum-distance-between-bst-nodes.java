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
    private TreeNode prev;
    private int minDiff = 1000000;
    private void solve(TreeNode root)
    {
        if(root == null)
        return;

        solve(root.left);

        if(prev != null)
        minDiff = Math.min(minDiff, root.val - prev.val);

        prev = root;

        solve(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        solve(root);
        return minDiff;
    }
}