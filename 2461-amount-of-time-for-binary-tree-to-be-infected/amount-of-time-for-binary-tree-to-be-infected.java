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
    private int timeToInfectTree;
    private int calculateTimeToInfectTree(TreeNode root, int startNode){
        if(root == null) return 0;
        
        int leftHeight = calculateTimeToInfectTree(root.left, startNode);
        int rightHeight = calculateTimeToInfectTree(root.right, startNode);
        
        if(root.val == startNode){
            timeToInfectTree = Math.max(leftHeight, rightHeight);
            return -1;
        }
        
        if(leftHeight < 0 || rightHeight < 0){
            timeToInfectTree = Math.max(timeToInfectTree, Math.abs(leftHeight) + Math.abs(rightHeight));
            return Math.min(leftHeight, rightHeight) - 1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public int amountOfTime(TreeNode root, int start) {
        timeToInfectTree = 0;
        calculateTimeToInfectTree(root, start);
        return timeToInfectTree;
    }
}