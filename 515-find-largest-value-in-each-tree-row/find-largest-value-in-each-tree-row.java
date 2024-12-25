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
    private List<Integer> res = new ArrayList<>();
    private void dfs(TreeNode root, int level)
    {
        if(root == null)
        return;

        if(level == res.size())
        res.add(root.val);
        else if(root.val > res.get(level))
        res.set(level, root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public List<Integer> largestValues(TreeNode root) 
    {
        dfs(root, 0);
        return res;
    }
}