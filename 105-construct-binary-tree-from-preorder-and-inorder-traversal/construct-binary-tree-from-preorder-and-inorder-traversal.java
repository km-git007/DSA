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

    private int index=0;
    private TreeNode solve(int[] preorder,int[] inorder,int start,int end)
    {
        if(start>end)
        return null;

        TreeNode node=new TreeNode(preorder[index++]);
        int pos=find(inorder,start,end,node.val);

        node.left=solve(preorder,inorder,start,pos-1);
        node.right=solve(preorder,inorder,pos+1,end);

        return node;
    }

    public TreeNode buildTree(int[] preorder,int[] inorder) // O(n^2)  //O(n) space
    {
        return solve(preorder,inorder,0,preorder.length-1);
    }
}