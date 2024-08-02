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
    
    private int index;
    private HashMap<Integer,Integer> map=new HashMap<>();
    private TreeNode solve(int[] postorder,int[] inorder,int start,int end)
    {
        if(start>end)
        return null;

        TreeNode node=new TreeNode(postorder[index--]);
        int pos=map.get(node.val);

        node.right=solve(postorder,inorder,pos+1,end);
        node.left=solve(postorder,inorder,start,pos-1);

        return node;
    }

    public TreeNode buildTree(int[] inorder,int[] postorder)
    {
        int n=inorder.length;
        index=n-1;

        for(int i=0;i<n;i++)
        map.put(inorder[i],i);

        return solve(postorder,inorder,0,n-1);
    }
}