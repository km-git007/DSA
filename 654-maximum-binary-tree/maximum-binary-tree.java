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
    private int findMaxIndex(int start, int end, int[] nums){
        int maxIndex = start;
        for(int i = start + 1; i <= end; i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    private TreeNode solve(int start, int end, int[] nums){
        if(start > end){
            return null;
        }
        
        int maxIndex = findMaxIndex(start, end, nums);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = solve(start, maxIndex - 1, nums);
        root.right = solve(maxIndex + 1, end, nums);
        
        return root;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(0, nums.length - 1, nums);
    }
}