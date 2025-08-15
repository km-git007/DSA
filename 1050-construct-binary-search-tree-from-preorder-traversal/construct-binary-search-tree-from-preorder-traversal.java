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
    private int index;
    private TreeNode buildBST(int upperBound, int[] preorder) {
        if(index == preorder.length || preorder[index] > upperBound) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = buildBST(root.val, preorder);
        root.right = buildBST(upperBound, preorder);
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return  buildBST(Integer.MAX_VALUE, preorder);
    }
}