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

    int index=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    private TreeNode buildBST(int[] preorder,int[] inorder,int start,int end)
    {
        if(start>end)
        return null;

        TreeNode node=new TreeNode(preorder[index++]);
        int pos=map.get(node.val);

        node.left=buildBST(preorder,inorder,start,pos-1);
        node.right=buildBST(preorder,inorder,pos+1,end);

        return node;
    }

    public TreeNode bstFromPreorder(int[] preorder) 
    {
        int n=preorder.length;
        int[] inorder=Arrays.copyOf(preorder,n);
        Arrays.sort(inorder);

        for(int i=0;i<n;i++)
        map.put(inorder[i],i);

        return buildBST(preorder,inorder,0,n-1);
    }
}