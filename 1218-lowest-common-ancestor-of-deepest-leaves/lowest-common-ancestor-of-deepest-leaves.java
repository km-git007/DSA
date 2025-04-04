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
record Pair(int depth, TreeNode node) {}
class Solution {
    private Pair solve(TreeNode root)
    {
        if(root == null)
        return new Pair(0, null);

        var L = solve(root.left);
        var R = solve(root.right);

        if(L.depth() == R.depth()) 
        return new Pair(L.depth() + 1, root);

        return (L.depth() > R.depth()) ? new Pair(L.depth() + 1, L.node()) : new Pair(R.depth() + 1, R.node());
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) 
    {
        return solve(root).node();
    }
}