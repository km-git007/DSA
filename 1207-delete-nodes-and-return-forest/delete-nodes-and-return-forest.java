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

    private Set<Integer> set = new HashSet<>();
    private List<TreeNode> list = new ArrayList<>();
    private TreeNode solve(TreeNode root)
    {
        if(root == null)
        return root;

        root.left = solve(root.left);
        root.right = solve(root.right);

        if(set.contains(root.val))
        {
            if(root.left != null)
            list.add(root.left);

            if(root.right != null)
            list.add(root.right);

            return null;
        }

        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) 
    {
        for(int num : to_delete)
        set.add(num);

        if(!set.contains(root.val))
        list.add(root);

        solve(root);
        return list;
    }
}