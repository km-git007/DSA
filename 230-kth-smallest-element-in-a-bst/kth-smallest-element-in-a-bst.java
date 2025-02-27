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
    private int K, res;
    private void solve(TreeNode root)
    {
        if(root == null || K <= 0)
        return;
        
        solve(root.left);
        
        if(K > 0) 
        {
            res = root.val;  
            K--;              
        }
        
        solve(root.right);
    }

    public int kthSmallest(TreeNode root, int k) 
    {
        K = k;
        solve(root);
        return res;
    }
}