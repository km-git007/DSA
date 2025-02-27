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
    private TreeNode first, last, prev;
    private void inorderTraversal(TreeNode root)
    {
        if(root == null)
        return;

        inorderTraversal(root.left);

        if(prev != null && root.val < prev.val)
        {
            if(first == null)
            first = prev;

            last = root;
        }

        prev = root;
        inorderTraversal(root.right);
    }

    public void recoverTree(TreeNode root) 
    {
        inorderTraversal(root);

        // swap first and last
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
}