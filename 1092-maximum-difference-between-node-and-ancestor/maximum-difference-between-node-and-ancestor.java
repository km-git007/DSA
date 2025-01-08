class Solution {
    private int solve(TreeNode root, int currMax, int currMin) {
        if (root == null) {
            // Return the maximum difference encountered so far
            return currMax - currMin;
        }

        // Update currMax and currMin with the current node value
        currMax = Math.max(currMax, root.val);
        currMin = Math.min(currMin, root.val);

        // Calculate the max difference in the left and right subtrees
        int leftDiff = solve(root.left, currMax, currMin);
        int rightDiff = solve(root.right, currMax, currMin);

        // Return the maximum difference
        return Math.max(leftDiff, rightDiff);
    }

    public int maxAncestorDiff(TreeNode root) {
        // Start the recursion with the root value as both max and min
        return solve(root, root.val, root.val);
    }
}
