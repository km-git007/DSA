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
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if(root == null)
        return res;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty())
        {
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            } 

            TreeNode node = stack.pop();
            res.add(node.val);

            root = node.right;
        }
        return res;
    }
}