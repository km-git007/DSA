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

    private class Pair 
    {
        int sum;
        int count;
        Pair(int sum, int count)
        {
            this.sum = sum;
            this.count = count;
        }
    }

    private int ans = 0;
    private Pair solve(TreeNode root)
    {
        if(root == null)
        return new Pair(0,0);

        Pair Left = solve(root.left);
        Pair Right = solve(root.right);

        int sum = root.val + Left.sum + Right.sum;
        int nodeCount = Left.count + Right.count + 1;

        if(sum / nodeCount == root.val) 
        ans++;

        return new Pair(sum, nodeCount); 
    }

    public int averageOfSubtree(TreeNode root) 
    {
        solve(root);
        return ans;
    }
}