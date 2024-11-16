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

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private void solve(TreeNode root, int target)
    {
        if(root == null)
        return;

        list.add(root.val);
        target -= root.val;

        if(root.left == null && root.right == null && target == 0)
        ans.add(new ArrayList(list));

        solve(root.left, target);
        solve(root.right, target);

        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        solve(root, targetSum);
        return ans;
    }
}