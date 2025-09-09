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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
        return null;

        TreeNode leftSubtree = pruneTree(root.left);
        TreeNode rightSubtree = pruneTree(root.right);

        root.left = leftSubtree;
        root.right = rightSubtree;

        if(leftSubtree != null || rightSubtree != null)
        return root;

        return root.val == 0 ? null : root;
    }
}