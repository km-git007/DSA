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
    public TreeNode solve(int[] a,int low,int high)
    {
        if(low>high)
        return null;

        int mid=low+(high-low)/2;

        TreeNode node=new TreeNode(a[mid]);
        node.left=solve(a,low,mid-1);
        node.right=solve(a,mid+1,high);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] a) 
    {
        return solve(a,0,a.length-1);
    }
}