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

    Deque<Integer> stack=new ArrayDeque<>();
    private void solve(TreeNode root)
    {
        if(root==null)
        return;

        stack.push(root.val);

        solve(root.right);
        solve(root.left);
    }

    public List<Integer> postorderTraversal(TreeNode root) 
    {
        solve(root);

        List<Integer> ans=new ArrayList<>();
        while(!stack.isEmpty())
        ans.add(stack.pop());

        return ans;
    }
}