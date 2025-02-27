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
    private long prev;
    private boolean check(TreeNode root)
    {
        if(root == null)
        return true;

        if(!check(root.left) || root.val <= prev)
        return false;

        prev = root.val;

        return check(root.right);
    }

    public boolean isValidBST(TreeNode root) 
    {
        prev = Long.MIN_VALUE;
        return check(root);
    }
}