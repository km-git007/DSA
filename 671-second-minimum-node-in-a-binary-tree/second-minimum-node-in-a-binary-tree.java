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
    private Integer firstMin, secondMin;
    private void traversal(TreeNode root){
        if(root == null) return;

        if(firstMin == null){
            firstMin = root.val;
        }

        else if (root.val < firstMin) {
            // Found new minimum, shift current min to second
            secondMin = firstMin;
            firstMin = root.val;
        } 
        
        else if (root.val > firstMin && (secondMin == null || root.val < secondMin)) {
            // Found new second minimum
            secondMin = root.val;
        }

        traversal(root.left);
        traversal(root.right);
    }

    public int findSecondMinimumValue(TreeNode root) {
        traversal(root);
        return secondMin != null ? secondMin : -1;
    }
}