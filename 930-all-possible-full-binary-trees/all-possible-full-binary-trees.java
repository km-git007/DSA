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
    private List<TreeNode>[] dp;
    private List<TreeNode> generate(int n){
        List<TreeNode> res = new ArrayList<>();
        if(n == 1){
            res.add(new TreeNode(0));
            return res;
        }
        
        if(dp[n] != null){
            return dp[n];
        }
        
        for(int i = 1; i <= n - 2; i += 2){
            var leftSubtree = generate(i);
            var rightSubtree = generate(n - i - 1);
            for(TreeNode leftRoot : leftSubtree){
                for(TreeNode rightRoot : rightSubtree){
                    TreeNode node = new TreeNode(0);
                    node.left = leftRoot;
                    node.right = rightRoot;
                    res.add(node);
                }
            }
        }
        return dp[n] = res;
    }

    public List<TreeNode> allPossibleFBT(int n) {
        if(n % 2 == 0){
            return new ArrayList<TreeNode>();
        }
        dp = new ArrayList[n + 1];
        return generate(n);
    }
}