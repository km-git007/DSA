class Node {
    int sum, min, max;
    public Node(int min, int max, int sum){
        this.sum = sum;
        this.min = min;
        this.max = max;
    }
}

class Solution {
    private static final int INF = Integer.MAX_VALUE / 2;
    private int maxsum;
    private Node solve(TreeNode root) 
    {
        if(root == null)
        return new Node(INF, -INF, 0);

        Node left = solve(root.left);
        Node right = solve(root.right);

        if(left.max < root.val && right.min > root.val) 
        {
            int newMin = Math.min(left.min, root.val);
            int newMax = Math.max(right.max, root.val);
            int sum = left.sum + right.sum + root.val;

            maxsum = Math.max(maxsum, sum);
            return new Node(newMin, newMax, sum);
        }
        return new Node(-INF, INF, Math.max(left.sum, right.sum));
    }

    public int maxSumBST(TreeNode root) 
    {
        maxsum = -INF;
        solve(root);
        return maxsum < 0 ? 0 : maxsum;
    }
}
