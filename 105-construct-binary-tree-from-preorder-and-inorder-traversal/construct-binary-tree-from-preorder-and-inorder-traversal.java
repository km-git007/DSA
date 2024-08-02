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

    private TreeNode solve(int[] preorder,int[] inorder,int start,int end,int index)
    {
        if(start>end)
        return null;

        TreeNode node=new TreeNode(preorder[index]);
        int pos=find(inorder,start,end,preorder[index]);

        node.left=solve(preorder,inorder,start,pos-1,index+1);
        node.right=solve(preorder,inorder,pos+1,end,index+pos-start+1);

        return node;
    }

    public TreeNode buildTree(int[] preorder,int[] inorder) 
    {
        return solve(preorder,inorder,0,preorder.length-1,0);
    }
}