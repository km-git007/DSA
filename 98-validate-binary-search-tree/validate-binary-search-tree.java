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
    private boolean validateTree(TreeNode root, long minimum, long maximum){
        if(root == null) return true;
        if(root.val <= minimum || root.val >= maximum) return false;

        return validateTree(root.left, minimum, root.val) && validateTree(root.right, root.val, maximum);
    }

    public boolean isValidBST(TreeNode root) {
        return validateTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}