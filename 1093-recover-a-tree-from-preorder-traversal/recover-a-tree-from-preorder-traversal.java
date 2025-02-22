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

    private int index;
    private int compute(String s)
    {
        int num = 0;
        while(index < s.length() && s.charAt(index) != '-')
        {
            num = num * 10 + (s.charAt(index) - '0');
            index++;
        }
        return num;
    }

    public TreeNode recoverFromPreorder(String s) 
    {
        TreeNode root = new TreeNode(-1);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        index = 0;

        while(index < s.length())
        {
            int depth = 0;
            while(index < s.length() && s.charAt(index) == '-')
            {
                index++;
                depth++;
            }

            int value = compute(s);
            TreeNode node = new TreeNode(value);

            while(!stack.isEmpty() && stack.size() - 1 > depth)
            stack.pop();

            TreeNode parent = stack.peek();

            if(parent.left == null)
            parent.left = node;

            else
            parent.right = node;

            stack.push(node);
        }

        return root.left;
    }
}