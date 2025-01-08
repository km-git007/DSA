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

    private int maxSum;
    private int solve(TreeNode root)
    {
        if(root == null)
        return 0;

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        int onlyOne = Math.max(leftSum, rightSum) + root.val;
        int rootLeftRight = leftSum + rightSum + root.val;
        int onlyRoot = root.val;

        maxSum = Math.max(Math.max(maxSum, rootLeftRight), Math.max(onlyOne, onlyRoot));
        
        return  Math.max(onlyOne, onlyRoot);
    }

    public int maxPathSum(TreeNode root) 
    {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}