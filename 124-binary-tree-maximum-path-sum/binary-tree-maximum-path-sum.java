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
private int maxPathSum;
    private int maxPathSumNodeToLeaf(TreeNode root){
        if(root == null) return 0;
        
        int leftSum = maxPathSumNodeToLeaf(root.left);
        int rightSum = maxPathSumNodeToLeaf(root.right);
        
        int maxChildSum = Math.max(leftSum, rightSum);
        maxPathSum = Math.max(Math.max(leftSum + rightSum + root.val, maxPathSum), Math.max(root.val,maxChildSum + root.val));
        
        return Math.max(maxChildSum + root.val, root.val);
    }
    
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        maxPathSumNodeToLeaf(root);
        return maxPathSum;
    }
}