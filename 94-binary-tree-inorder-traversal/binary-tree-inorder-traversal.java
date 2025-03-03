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
        List<Integer> ans =new ArrayList<>();

        if(root == null)
        return ans;

        while(root != null)
        {
            // left part doesn't exists
            if(root.left == null)
            {
                ans.add(root.val);
                root = root.right;
            }
            // left part exists
            else
            {
                TreeNode curr = root.left;
                while(curr.right != null && curr.right != root)
                curr = curr.right;

                if(curr.right == null)
                {
                    curr.right = root;
                    root = root.left;
                }

                else
                {
                    ans.add(root.val);
                    curr.right = null;
                    root = root.right;
                }
            }
        }
        return ans;
    }
}