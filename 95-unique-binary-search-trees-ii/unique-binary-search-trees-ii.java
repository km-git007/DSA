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
    private List<TreeNode> generate(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        
        for(int i = start; i <= end; i++){
            var leftSubtree = generate(start, i - 1);
            var rightSubtree = generate(i + 1, end);
            
            for(TreeNode leftRoot : leftSubtree){
                for(TreeNode rightRoot : rightSubtree){
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    res.add(root);
                }
            }
        }
        return res;
    }
    
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
}