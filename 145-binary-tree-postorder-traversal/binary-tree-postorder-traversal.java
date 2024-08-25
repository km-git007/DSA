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
        // adds element in order(Root-Right-Left)
        // we will have to reverse the ans at last.
        while(root!=null)
        {
            if(root.right==null)
            {
                ans.add(root.val);
                root=root.left;
            }
            else
            {
                TreeNode curr=root.right;
                while(curr.left!=null && curr.left!=root)
                curr=curr.left;

                if(curr.left==null)
                {
                    ans.add(root.val);
                    curr.left=root;
                    root=root.right;
                }
                else if(curr.left==root)
                {
                    curr.left=null;
                    root=root.left;
                }
            }
        }

        Collections.reverse(ans);
        return ans;
    } 
}