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
    private long maxProduct;
    private final int MOD = 1000000007;
    private long totalSum;
    private long totalSum(TreeNode root){
        if(root == null) return 0;
        return root.val + totalSum(root.left) + totalSum(root.right);
    }

    private long findTreeSum(TreeNode root){
        if(root == null) return 0;

        long leftSum = findTreeSum(root.left);
        long rightSum = findTreeSum(root.right);
        long subTreeSum = leftSum + rightSum + root.val;
        maxProduct = Math.max(maxProduct, (subTreeSum * (totalSum - subTreeSum)));
        return subTreeSum;
    }

    public int maxProduct(TreeNode root) {
        maxProduct = 0;
        totalSum = totalSum(root);
        findTreeSum(root);
        return (int)(maxProduct % MOD);
    }
}