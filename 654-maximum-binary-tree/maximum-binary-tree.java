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
        Deque<TreeNode> deque = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            while(!deque.isEmpty() && deque.peekLast().val < num) {
                node.left = deque.pollLast();
            }
            if(!deque.isEmpty()){
                deque.peekLast().right = node;
            }
            deque.offerLast(node);
        }
        return deque.peekFirst();
    }
}