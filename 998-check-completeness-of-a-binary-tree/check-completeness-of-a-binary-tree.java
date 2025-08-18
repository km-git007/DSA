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
    private int calculateTotalNodes(TreeNode root){
        if(root == null) return 0;
        return 1 + calculateTotalNodes(root.left) + calculateTotalNodes(root.right);
    }
    
    private boolean isValid(int nodeNumber, int total, TreeNode root){
        if(root == null) return true;
        
        if(nodeNumber > total) return false;
        
        return isValid(2* nodeNumber, total, root.left) && 
                isValid(2* nodeNumber + 1, total, root.right);
        
    }
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = calculateTotalNodes(root);
        return isValid(1, totalNodes, root);
    }
}