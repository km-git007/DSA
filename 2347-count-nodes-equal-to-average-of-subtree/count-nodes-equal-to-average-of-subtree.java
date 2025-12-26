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
    private int count;
    private int[] solve(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }
        
        int[] leftResult = solve(root.left);
        int[] rightResult = solve(root.right);
        
        int subtreeSum = root.val +  leftResult[0] + rightResult[0];
        int subtreeSize = 1 + leftResult[1] + rightResult[1];
        
        if(root.val == subtreeSum / subtreeSize) {
            count++;
        }
        
        return new int[]{subtreeSum, subtreeSize};
    }
    
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        solve(root);
        return count;
    }
}