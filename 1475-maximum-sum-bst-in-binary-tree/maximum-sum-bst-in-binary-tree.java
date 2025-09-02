class BST {
    boolean isBST;
    int sum, min, max;
    public BST(int min, int max, int sum, boolean isBST){
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}

class Solution {
    private static final int INF = Integer.MAX_VALUE / 2;
    private int maxsum;
    private BST solve(TreeNode root)
    {
        if(root == null){
            return new BST(INF, -INF, 0, true);
        }
        
        var left = solve(root.left);
        var right = solve(root.right);
        
        if(left.isBST && right.isBST && left.max < root.val && right.min > root.val){
            int newMax = Math.max(root.val, right.max);
            int newMin = Math.min(root.val, left.min);
            int totalSum = left.sum + right.sum + root.val;
            maxsum = Math.max(maxsum, totalSum);
            return new BST(newMin, newMax, totalSum, true);
        }
        
        return new BST(left.min, right.max, Math.max(left.sum, right.sum), false);
    }

    public int maxSumBST(TreeNode root)
    {
        maxsum = 0;
        solve(root);
        return maxsum;
    }
}
