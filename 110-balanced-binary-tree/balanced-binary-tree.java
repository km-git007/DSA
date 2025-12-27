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
    private boolean isHeightBalanced;
    private int heightOfTree(TreeNode root){
        if(root == null || !isHeightBalanced) return 0;

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            isHeightBalanced = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        isHeightBalanced = true;
        heightOfTree(root);
        return isHeightBalanced;
    }
}