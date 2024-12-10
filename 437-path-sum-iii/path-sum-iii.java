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

    private int paths, target;
    private HashMap<Long, Long> map;
    private void solve(TreeNode root, long sum)
    {
        if(root == null)
        return;

        sum += root.val;

        if(map.containsKey(sum - target))
        paths += map.get(sum - target);

        map.put(sum, map.getOrDefault(sum, 0L) + 1);

        solve(root.left, sum);
        solve(root.right, sum);

        map.put(sum, map.get(sum) - 1);
        if(map.get(sum) == 0)
        map.remove(sum);

    }

    public int pathSum(TreeNode root, int targetSum) 
    {
        paths = 0;
        target = targetSum;
        map = new HashMap<>();
        map.put(0L, 1L);
        solve(root, 0);
        return paths;
    }
}