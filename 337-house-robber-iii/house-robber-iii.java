class Solution {
    private int[] loot(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }
        
        int[] leftLoot = loot(root.left);
        int[] rightLoot = loot(root.right);
        
        int rob = root.val + leftLoot[1] + rightLoot[1];
        int notRob = Math.max(leftLoot[0], leftLoot[1]) + Math.max(rightLoot[0], rightLoot[1]);

        return new int[]{rob, notRob};
    }
    
    public int rob(TreeNode root) {
        int[] res = loot(root);
        return Math.max(res[0], res[1]);
    }
}