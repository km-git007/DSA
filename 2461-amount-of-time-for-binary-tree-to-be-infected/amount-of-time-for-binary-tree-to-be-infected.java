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
    private int result, target;
    private int solve(TreeNode root)
    {
        if(root == null)
        return 0;

        int leftHeight = solve(root.left);
        int rightHeight = solve(root.right);

        // update the result
        result = Math.max(result, Math.max(leftHeight, rightHeight));

        if(root.val == target)
        return -1;

        if(leftHeight < 0)
        {
            result = Math.max(result, Math.abs(leftHeight) + rightHeight);
            return leftHeight - 1;
        }

        if(rightHeight < 0)
        {
            result = Math.max(result, Math.abs(rightHeight) + leftHeight);
            return rightHeight - 1;
        }
        // return height
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int amountOfTime(TreeNode root, int start) 
    {
        result = 0;
        target = start;
        solve(root);
        return result;
    }
}