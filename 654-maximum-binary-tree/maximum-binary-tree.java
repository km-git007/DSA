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

    private int findMaxIndex(int[] nums, int start, int end)
    {
        int maxIndex = start;
        for(int i = start; i <= end; i++)
        {
            if(nums[i] > nums[maxIndex])
            maxIndex = i;
        }
        return maxIndex;
    }

    private TreeNode solve(int[] nums, int start, int end)
    {
        if(start > end)
        return null;

        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode node = new TreeNode(nums[maxIndex]);

        node.left = solve(nums,start, maxIndex - 1);
        node.right = solve(nums, maxIndex + 1, end);

        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) 
    {
        return solve(nums, 0, nums.length - 1);
    }
}