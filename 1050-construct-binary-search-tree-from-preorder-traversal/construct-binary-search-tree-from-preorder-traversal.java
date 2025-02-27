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

    int index;
    private TreeNode buildBST(int[] preorder, int ub)
    {
        if(index == preorder.length || preorder[index] > ub)
        return null;

        TreeNode node = new TreeNode(preorder[index++]);

        node.left = buildBST(preorder,node.val);
        node.right = buildBST(preorder,ub);

        return node;
    }

    public TreeNode bstFromPreorder(int[] preorder) 
    {
        index = 0;
        return buildBST(preorder, Integer.MAX_VALUE);
    }
}