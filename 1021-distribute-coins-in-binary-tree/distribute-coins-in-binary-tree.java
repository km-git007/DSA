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
    private int moves;
    private int solve(TreeNode root)
    {
        if(root==null)
        return 0;

        int Left=solve(root.left);
        int Right=solve(root.right);

        moves+=Math.abs(Left)+Math.abs(Right);

        int extraCandies=root.val+Left+Right-1;
        return extraCandies;
    }

    public int distributeCoins(TreeNode root) 
    {
        moves=0;
        solve(root);
        return moves;
    }
}