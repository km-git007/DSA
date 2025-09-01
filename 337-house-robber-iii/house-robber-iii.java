class Solution {
    private Map<TreeNode, Integer> dp;
    private int solve(TreeNode root){
        if(root == null) return 0;

        if(dp.containsKey(root)){
            return dp.get(root);
        }

        int take = root.val;
        if(root.left != null) {
            take += solve(root.left.right) + solve(root.left.left);
        }
        if(root.right != null) {
            take += solve(root.right.left) + solve(root.right.right);
        }

        int notTake = solve(root.left) + solve(root.right);
        dp.put(root, Math.max(take, notTake));
        return dp.get(root);
    }

    public int rob(TreeNode root) {
        dp = new HashMap<>();
        return solve(root);
    }
}