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
    private int numberOfGoodNodes(TreeNode root, int maxValueInPath){
        if(root == null){
            return 0;
        }

        int numberOfGoodNodes = 0;
        numberOfGoodNodes += maxValueInPath <= root.val ? 1 : 0;

        maxValueInPath = Math.max(maxValueInPath, root.val);

        numberOfGoodNodes += numberOfGoodNodes(root.left, maxValueInPath) ;
        numberOfGoodNodes += numberOfGoodNodes(root.right, maxValueInPath);
        return numberOfGoodNodes;
    }

    public int goodNodes(TreeNode root) {
        return numberOfGoodNodes(root, root.val);
    }
}