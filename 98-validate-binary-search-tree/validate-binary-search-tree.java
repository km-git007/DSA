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
    private long prev;
    private boolean validateTree(TreeNode root)
    {
        if(root == null) return true;
        
        boolean left = validateTree(root.left);
        if(!left) return false;
        
        if(prev >= root.val) return false;
        prev = root.val;
        
        return validateTree(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        prev = Long.MIN_VALUE;
        return validateTree(root);
    }
}