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
    private void solve(TreeNode root, int prevResult){
        if(root == null){
            return;
        }
        
        prevResult = prevResult * 2 + root.val;
        if(root.left == null && root.right == null){
            totalSum += prevResult;
            return;
        }
        solve(root.left, prevResult);
        solve(root.right, prevResult);
    }
    
    public int sumRootToLeaf(TreeNode root) {
        totalSum = 0;
        solve(root, 0);
        return totalSum;
    }
}