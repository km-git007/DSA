class Solution {
    private Map<TreeNode, Integer> dp;
    private int loot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if(dp.containsKey(root)) {
            return dp.get(root);
        }
        
        int take = root.val;
        if(root.left != null) {
            take += loot(root.left.left) + loot(root.left.right);
        }
        if(root.right != null) {
            take += loot(root.right.left) + loot(root.right.right);
        }
        
        int notTake = loot(root.left) + loot(root.right);
        
        dp.put(root, Math.max(take, notTake));
        return dp.get(root);
    }

    public int rob(TreeNode root) {
        dp = new HashMap<>();
        return loot(root);
    }
}