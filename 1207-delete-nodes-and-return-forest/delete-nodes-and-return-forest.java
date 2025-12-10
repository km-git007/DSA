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
    private TreeNode solve(TreeNode root, Set<Integer> deleteSet, List<TreeNode> res){
        if(root == null) return root;

        root.left = solve(root.left, deleteSet, res);
        root.right = solve(root.right, deleteSet, res);

        if(deleteSet.contains(root.val)){
            if(root.left != null){
                res.add(root.left);
            }
            if(root.right != null){
                res.add(root.right);
            }
            return null;
        }

        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleteSet = new HashSet<>();
        for (int val : to_delete) {
            deleteSet.add(val);
        }

        List<TreeNode> res = new ArrayList<>();
        solve(root, deleteSet, res);
        if(!deleteSet.contains(root.val)){
            res.add(root);
        }
        return res;
    }
}