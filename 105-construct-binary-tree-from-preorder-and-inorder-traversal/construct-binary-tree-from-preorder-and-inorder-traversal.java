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

    private int index=0;
    private HashMap<Integer,Integer> map=new HashMap<>();
    private TreeNode solve(int[] preorder,int[] inorder,int start,int end)
    {
        if(start>end)
        return null;

        TreeNode node=new TreeNode(preorder[index++]);
        int pos=map.get(node.val);

        node.left=solve(preorder,inorder,start,pos-1);
        node.right=solve(preorder,inorder,pos+1,end);

        return node;
    }

    public TreeNode buildTree(int[] preorder,int[] inorder) // O(n)  //O(n) space
    {
        int n=inorder.length;
        for(int i=0;i<n;i++)
        map.put(inorder[i],i);

        return solve(preorder,inorder,0,n-1);
    }
}