class Solution {
    private List<TreeNode>[][] dp;
    // Step 1: Recursive function to generate all BSTs from numbers [start..end]
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        // Base case: empty tree
        if (start > end) {
            result.add(null);
            return result;
        }

        // Memoization check
        if (dp[start][end] != null) {
            return dp[start][end];
        }

        // Step 2: Try each number as root
        for (int rootVal = start; rootVal <= end; rootVal++) {
            // Generate all left subtrees and right subtrees
            List<TreeNode> leftSubtrees = generate(start, rootVal - 1);
            List<TreeNode> rightSubtrees = generate(rootVal + 1, end);

            // Step 3: Combine each left and right subtree with the root
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return dp[start][end] = result; // save to dp
    }

    // Step 4: Main function
    public List<TreeNode> generateTrees(int n) {
        dp = new ArrayList[n + 1][n + 1]; // memoization table
        return generate(1, n);
    }
}
