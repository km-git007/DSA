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
    private int tilt = 0;
    private int solve(TreeNode root)
    {
        if(root == null)
        return 0;

        int leftSubTreeSum = solve(root.left);
        int rightSubTreeSum = solve(root.right);

        int tiltOfNode = Math.abs(leftSubTreeSum - rightSubTreeSum);
        tilt += tiltOfNode;

        return root.val + leftSubTreeSum + rightSubTreeSum;
    }

    public int findTilt(TreeNode root) 
    {
        solve(root);
        return tilt;
    }
}