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

    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> ans=new ArrayList<>();
        if(root==null)
        return ans;

        // Left->Right->Root
        // we will add in order Root->Right->Left and then reverse the list
        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node=stack.pop();
            ans.add(node.val);

            if(node.left!=null)
            stack.push(node.left);

            if(node.right!=null)
            stack.push(node.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}