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

    public void flatten(TreeNode root) {
        if (root == null) return;

        // Recursively flatten left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // Store the right subtree
        TreeNode tempRight = root.right;

        // Move left subtree to the right
        root.right = root.left;
        root.left = null;

        // Find the rightmost node of the new right subtree
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }

        // Attach the original right subtree
        curr.right = tempRight;
    }
}