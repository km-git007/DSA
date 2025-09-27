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
    private int totalSum;
    private void calculateSum(TreeNode root, int pathSum) {
        if (root == null) {
            return;
        }
        
        pathSum = 10 * pathSum + root.val;
        
        if(root.left == null && root.right == null) {
            totalSum += pathSum;
            return;
        }
        
        calculateSum(root.left, pathSum);
        calculateSum(root.right, pathSum);
    }
    
    public int sumNumbers(TreeNode root) {
        totalSum = 0;
        calculateSum(root, 0);
        return totalSum;
    }
}