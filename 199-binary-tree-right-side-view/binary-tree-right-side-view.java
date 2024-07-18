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

    int maxLevel=-1;
    List<Integer> list=new ArrayList<>();
    public void solve(TreeNode root,int level)
    {
        if(root==null)
        return;

        if(level>maxLevel)
        {
            maxLevel=level;
            list.add(Integer.valueOf(root.val));
        }

        solve(root.right,level+1);
        solve(root.left,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) 
    {
        if(root==null)
        return list;

        solve(root,0);
        return list;
    }
}