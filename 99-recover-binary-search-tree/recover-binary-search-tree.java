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
    private TreeNode first, middle, last, prev;
    private void inorderTraversal(TreeNode root)
    {
        if(root == null)
        return;

        inorderTraversal(root.left);

        if(prev != null && root.val < prev.val)
        {
            if(first == null)
            {
                first = prev;
                middle = root;
            }

            else
            last = root;
        }

        prev = root;
        inorderTraversal(root.right);
    }

    public void recoverTree(TreeNode root) 
    {
        inorderTraversal(root);
        int temp = first.val;
        if(last == null)
        {
            first.val = middle.val;
            middle.val = temp;
        }
        else
        {
            first.val = last.val;
            last.val = temp;
        }
    }
}