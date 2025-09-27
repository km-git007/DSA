class Solution {
    private int k, res;
    private void solve(TreeNode root){
        if(root == null) return;
        
        solve(root.left);
        
        if(k > 0) {
            k--;
            res = root.val;
        }else{
            return;
        }

        solve(root.right);
    } 
    
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        solve(root);
        return res;
    }
}