class Solution {
    private long maxProduct;
    private final long MOD = 1_000_000_007;

    private long sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    private long subtreeSum(TreeNode root, long totalSum) {
        if (root == null) return 0;

        long left = subtreeSum(root.left, totalSum);
        long right = subtreeSum(root.right, totalSum);
        long current = left + right + root.val;

        long product = current * (totalSum - current);
        maxProduct = Math.max(maxProduct, product);

        return current;
    }

    public int maxProduct(TreeNode root) {
        maxProduct = 0;
        long totalSum = sum(root);
        subtreeSum(root, totalSum);
        return (int)(maxProduct % MOD);
    }
}
