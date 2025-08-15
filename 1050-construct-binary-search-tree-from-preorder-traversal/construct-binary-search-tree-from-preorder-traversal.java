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
    private TreeNode constructBST(int start, int end, int[] preorder) {
        if(start > end) return null;
        
        TreeNode node = new TreeNode(preorder[start]);
        int inorderSuccesorIndex = findInorderSuccessor(start + 1, preorder, node.val);
        if(inorderSuccesorIndex != -1){
            node.right = constructBST(inorderSuccesorIndex, end, preorder);
            node.left = constructBST(start + 1, inorderSuccesorIndex - 1, preorder);
        }else{
            node.left = constructBST(start + 1, end, preorder);
        }
        return node;
    }

    private int findInorderSuccessor(int start, int[] preorder, int key) {
        for(int i = start; i < preorder.length; i++){
            if(preorder[i] > key) return i;
        }
        return -1;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(0, preorder.length - 1, preorder);
    }
}