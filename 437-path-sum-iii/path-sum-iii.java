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

    private int solve(TreeNode root,long targetSum)
    {
        if(root==null)
        return 0;

        targetSum-=root.val;

        if(targetSum==0)
        return 1+solve(root.left,targetSum)+solve(root.right,targetSum);

        return solve(root.left,targetSum)+solve(root.right,targetSum);
    }

    public int pathSum(TreeNode root, int targetSum) 
    {
        if(root==null)
        return 0;

        return solve(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
}