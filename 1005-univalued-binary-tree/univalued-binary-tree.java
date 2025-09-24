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
    private boolean isValid(TreeNode root, int value){
        if(root == null){
            return true;
        }

        if(root.val != value){
            return false;
        }

        return isValid(root.left, value) && isValid(root.right, value);
    }

    public boolean isUnivalTree(TreeNode root) {
        return isValid(root, root.val);
    }
}