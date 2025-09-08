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
    private Map<Integer, Integer> map;
    private TreeNode solve(int start, int end, int[] preorder, int[] inorder){
        if(start > end){
            return null;
        }

        int nodeVal = preorder[index++];
        int mid = map.get(nodeVal);
        TreeNode node = new TreeNode(nodeVal);

        node.left = solve(start, mid - 1, preorder, inorder);
        node.right = solve(mid + 1, end, preorder, inorder);

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder){
        index = 0;
        map = new HashMap<>();
        for(int i = 0; i < preorder.length; i++){
            map.put(inorder[i], i);
        }
        return solve(0, preorder.length - 1, preorder, inorder);
    }
}