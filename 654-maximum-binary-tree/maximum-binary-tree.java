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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            while(!stack.isEmpty() && stack.peek().val < num) {
                node.left = stack.pop();
            }

            if(!stack.isEmpty()) {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        return stack.peekLast();
    }
}