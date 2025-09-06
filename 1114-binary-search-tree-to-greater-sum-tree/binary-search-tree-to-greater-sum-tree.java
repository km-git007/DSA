class Solution {
    int sum;
    private void solve(TreeNode root)
    {
        if(root == null)
        return;

        solve(root.right);
        sum += root.val;
        root.val = sum;

        solve(root.left);
    }

    public TreeNode bstToGst(TreeNode root) 
    {
        sum = 0;
        solve(root);
        return root;
    }
}