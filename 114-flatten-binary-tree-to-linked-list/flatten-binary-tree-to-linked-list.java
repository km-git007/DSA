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

    public void flatten(TreeNode root) 
    {
        if(root==null)
        return;

        while(root!=null)
        {
            // LeftPart exist.
            if(root.left!=null)
            {
                TreeNode curr=root.left;
                while(curr.right!=null)
                curr=curr.right;
                
                // make connection with root-Right
                curr.right=root.right;
                root.right=root.left;
                // set root-left to null
                root.left=null;
            }
            // move forward.
            root=root.right;
        }
    }
}