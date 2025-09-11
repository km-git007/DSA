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
    private int count;
    private Map<Long, Long> map;
    private void solve(TreeNode root, long sum, long target) {
        if(root == null){
            return;
        }

        sum += root.val;
        if(map.containsKey(sum - target)){
            count += map.get(sum - target);
        }
        map.put(sum, map.getOrDefault(sum, 0L) + 1);

        solve(root.left, sum, target);
        solve(root.right, sum, target);

        map.put(sum, map.getOrDefault(sum, 0L) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        map = new HashMap<>();
        map.put(0L, 1L);
        solve(root, 0, targetSum);
        return count;
    }
}