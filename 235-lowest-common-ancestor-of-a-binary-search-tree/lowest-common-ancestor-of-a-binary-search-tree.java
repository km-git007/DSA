/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    private TreeNode solve(TreeNode root,int mini,int maxi)
    {
        if(root==null)
        return root;

        if(root.val>=mini && root.val<=maxi)
        return root;

        TreeNode L=solve(root.left,mini,maxi);
        TreeNode R=solve(root.right,mini,maxi);

        if(L==null && R==null)
        return null;

        return (L==null)?R:L;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        int mini=Math.min(p.val,q.val);
        int maxi=Math.max(p.val,q.val);

        return solve(root,mini,maxi);
    }
}