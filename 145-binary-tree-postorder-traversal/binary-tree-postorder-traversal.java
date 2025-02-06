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

        while(root!=null)
        {
            // Right-Part doesn't exist.
            if(root.right == null)
            {
                ans.add(root.val);
                root = root.left;
            }
            // Right-Part does exist.
            else
            {
                TreeNode curr = root.right;
                while(curr.left != null && curr.left != root)
                curr = curr.left;
                // Right-Part not yet traversed.
                if(curr.left == null)
                {
                    ans.add(root.val);
                    curr.left = root;
                    root = root.right;
                }
                // Right-Part already traversed.
                else
                {
                    curr.left = null;
                    root = root.left;
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}