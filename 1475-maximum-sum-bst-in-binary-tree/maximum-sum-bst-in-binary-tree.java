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
class Node{
    int sum, mini, maxi;
    Node(int sum, int mini, int maxi)
    {
        this.sum = sum;
        this.mini = mini;
        this.maxi = maxi;
    }
}

class Solution {
    private int INF, maxSum;
    private Node solve(TreeNode root)
    {
        if(root == null)
        return new Node(0, INF, -INF);

        Node left = solve(root.left);
        Node right = solve(root.right);

        // root forms a valid BST with the left and right subtrees
        if(left.maxi < root.val && root.val < right.mini)
        {
            int sum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, sum);
            return new Node(sum, Math.min(left.mini, root.val), Math.max(right.maxi, root.val));
        }

        return new Node(Math.max(left.sum, right.sum), -INF, INF);
    }

    public int maxSumBST(TreeNode root) 
    {
        INF = Integer.MAX_VALUE;
        maxSum = -INF;
        solve(root);
        return maxSum < 0 ? 0 : maxSum;
    }
}