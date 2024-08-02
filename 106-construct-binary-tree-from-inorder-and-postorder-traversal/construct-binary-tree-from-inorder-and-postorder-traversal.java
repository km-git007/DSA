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
    private int find(int[] inorder,int start,int end,int target)
    {
        int i;
        for(i=start;i<=end;i++)
        if(inorder[i]==target)
        break;

        return i;
    }

    private int index;
    private TreeNode solve(int[] postorder,int[] inorder,int start,int end)
    {
        if(start>end)
        return null;

        TreeNode node=new TreeNode(postorder[index--]);
        int pos=find(inorder,start,end,node.val);

        node.right=solve(postorder,inorder,pos+1,end);
        node.left=solve(postorder,inorder,start,pos-1);

        return node;
    }

    public TreeNode buildTree(int[] inorder,int[] postorder)
    {
        index=inorder.length-1;
        return solve(postorder,inorder,0,inorder.length-1);
    }
}