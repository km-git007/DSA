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

    private List<TreeNode>[][] dp;
    private List<TreeNode> solve(int start, int end)
    {
        List<TreeNode> res = new ArrayList<>();
        if(start > end)
        {
            res.add(null);
            return res;
        } 

        if(dp[start][end] != null) 
        return dp[start][end];

        for(int root = start; root <= end; root++)
        {
            var leftBSTs = solve(start, root - 1);
            var rightBSTs = solve(root + 1, end);
            for(TreeNode rightRoot : rightBSTs)
            {
                for(TreeNode leftRoot : leftBSTs)
                {
                    TreeNode node = new TreeNode(root);
                    node.left = leftRoot;
                    node.right = rightRoot;
                    res.add(node);
                }       
            }
        }
        return dp[start][end] = res;
    }

    public List<TreeNode> generateTrees(int n) 
    {
        dp = new ArrayList[n + 1][n + 1];
        return solve(1, n);
    }
}