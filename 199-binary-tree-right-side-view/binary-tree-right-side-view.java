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

    List<Integer> list;
    public void solve(TreeNode root,int level)
    {
        if(root == null)
        return;

        if(level == list.size())
        list.add(root.val);

        solve(root.right,level+1);
        solve(root.left,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) 
    {
        list = new ArrayList<>();

        if(root == null)
        return list;

        solve(root,0);
        return list;
    }
}