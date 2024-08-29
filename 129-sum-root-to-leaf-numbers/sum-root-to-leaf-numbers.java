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
    
    int totalSum=0;
    private void solve(TreeNode root,int sum)
    {
        if(root==null)
        return;

        sum=sum*10+root.val;

        if(root.left==null && root.right==null)
        {
            totalSum+=sum;
            return;
        }

        solve(root.left,sum);
        solve(root.right,sum);
    }

    public int sumNumbers(TreeNode root) 
    {
        solve(root,0);
        return totalSum;
    }
}