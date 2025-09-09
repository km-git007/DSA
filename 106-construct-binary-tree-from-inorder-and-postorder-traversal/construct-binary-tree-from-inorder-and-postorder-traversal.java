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
    private TreeNode solve(int start, int end, int[] postorder, int[] inorder){
        if(start > end){
            return null;
        }

        int nodeVal = postorder[index--];
        int mid = map.get(nodeVal);
        TreeNode node = new TreeNode(nodeVal);

        node.right = solve(mid + 1, end, postorder, inorder);
        node.left = solve(start, mid - 1, postorder, inorder);

        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        map = new HashMap<>();
        for(int i = 0; i < postorder.length; i++){
            map.put(inorder[i], i);
        }
        return solve(0, postorder.length - 1, postorder, inorder);
    }
}