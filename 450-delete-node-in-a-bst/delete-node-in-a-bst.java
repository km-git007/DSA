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
    private TreeNode findSuccessor(TreeNode root)
    {
        while(root.left != null)
        root = root.left;

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) 
    {
        if(root == null)
        return root;

        if(root.val > key)
        root.left = deleteNode(root.left, key);

        else if(root.val < key)
        root.right = deleteNode(root.right, key);

        else
        {
            // root has no child
            if(root.left == null && root.right == null)
            return null;

            // root has right child
            else if(root.left == null)
            return root.right;

            // root has left child
            else if(root.right == null)
            return root.left;

            // root has both child
            else
            {
                TreeNode succ = findSuccessor(root.right);
                root.val = succ.val;
                root.right = deleteNode(root.right, succ.val);
            }
        }

        return root;
    }
}