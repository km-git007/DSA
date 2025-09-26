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
    private int maxLevel, sum;
    private void solve(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if(level > maxLevel) {
            maxLevel = level;
            sum = root.val;
        }
        else if(level == maxLevel) {
            sum += root.val;
        }

        solve(root.left, level + 1);
        solve(root.right, level + 1);
    }

    public int deepestLeavesSum(TreeNode root) {
        maxLevel = 0;
        sum = 0;
        solve(root, 0);
        return sum;
    }
}