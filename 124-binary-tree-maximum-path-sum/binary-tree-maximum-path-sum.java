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
        if(root==null)
        return 0;

        int leftSum=solve(root.left);
        int rightSum=solve(root.right);

        int ekAcchaHai=Math.max(leftSum,rightSum)+root.val;
        int phleHiMilgaya=leftSum+rightSum+root.val;
        int rootAcchaHai=root.val;
        maxSum=Math.max(Math.max(ekAcchaHai,phleHiMilgaya),Math.max(rootAcchaHai,maxSum));

        return Math.max(ekAcchaHai,rootAcchaHai);
    }

    public int maxPathSum(TreeNode root) 
    {
        maxSum=Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}