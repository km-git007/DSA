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
    private Set<Integer> set;
    private List<TreeNode> res;
    private TreeNode solve(TreeNode root)
    {
        if(root == null)
        return root;

        root.left = solve(root.left);
        root.right = solve(root.right);

        if(set.contains(root.val))
        {
            if(root.left != null)
            res.add(root.left);

            if(root.right != null)
            res.add(root.right);

            return null;
        }

        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) 
    {
        res = new ArrayList<>();
        if(root == null)
        return res;

        set = new HashSet<>();
        for(int node : to_delete)
        set.add(node);

        solve(root);
        if(!set.contains(root.val))
        res.add(root);

        return res;
    }
}