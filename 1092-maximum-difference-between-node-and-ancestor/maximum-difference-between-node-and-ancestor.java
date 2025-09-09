class Solution {
    private int maxDifference;
    private void solve(int minimum, int maximum, TreeNode root){
        if(root == null){
            return ;
        }

        minimum = Math.min(minimum, root.val);
        maximum = Math.max(maximum, root.val);
        maxDifference = Math.max(maxDifference, Math.abs(maximum - minimum));
        
        solve(minimum, maximum, root.left);
        solve(minimum, maximum, root.right);
    }

    public int maxAncestorDiff(TreeNode root) {
        maxDifference = 0;
        solve(root.val, root.val, root);
        return maxDifference;
    }
}