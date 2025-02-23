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
    private Map<Integer, Integer> map;
    private TreeNode solve(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd)
    {
        if(preStart > preEnd)
        return null;

        if(preStart == preEnd)
        return new TreeNode(preorder[preStart]);

        TreeNode node = new TreeNode(preorder[preStart]);

        int pos = map.get(preorder[preStart + 1]);
        int numLeftTree = pos - postStart + 1;

        node.left = solve(preorder, postorder, preStart + 1, preStart + numLeftTree, postStart, pos);
        node.right = solve(preorder, postorder, preStart + numLeftTree + 1, preEnd, pos + 1, postEnd - 1);

        return node;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) 
    {
        map = new HashMap<>();

        int n = postorder.length;
        for(int i = 0; i < n; i++)
        map.put(postorder[i], i);

        return solve(preorder, postorder, 0, n - 1, 0, n - 1);
    }
}