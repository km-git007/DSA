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
    private int diameter;
    private int findHeight(TreeNode root)
    {
        if(root == null)
        return 0;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        // update the diameter
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // return the height
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public int diameterOfBinaryTree(TreeNode root) 
    {
        diameter = 0;
        findHeight(root);
        return diameter;
    }
}