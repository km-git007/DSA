class Solution {
    private int[] solve(TreeNode root){
        if(root == null) return new int[2];
        
        int[] leftLoot = solve(root.left);
        int[] rightLoot = solve(root.right);
        
        // loot the root 
        int rob = root.val + leftLoot[1] + rightLoot[1];
        int notRob = Math.max(leftLoot[0], leftLoot[1]) + Math.max(rightLoot[0], rightLoot[1]);
        return  new int[]{rob, notRob};
    }

    public int rob(TreeNode root) {
        int[] res = solve(root);
        return Math.max(res[0], res[1]);
    }
}