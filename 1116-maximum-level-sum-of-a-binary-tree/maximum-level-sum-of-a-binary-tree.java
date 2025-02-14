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
    private int bfs(TreeNode root) 
    {
        int level = 1, maxSum = Integer.MIN_VALUE, ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            int sum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;

                if (curr.left != null) 
                    q.add(curr.left);

                if (curr.right != null) 
                    q.add(curr.right);
            }

            if (sum > maxSum) {
                ans = level;
                maxSum = sum;
            }  
            level++; 
        }
        return ans;
    }

    public int maxLevelSum(TreeNode root) 
    {
        return bfs(root);
    }
}
