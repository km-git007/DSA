/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int kthSmallestElement, k;
    private void solve(TreeNode root)
    {
        if(root == null) 
        return;

        solve(root.left);
        
        if(k > 0){
            kthSmallestElement = root.val;
            k--;
        }else {
            return;
        }
        
        solve(root.right);
    }

    public int kthSmallest(TreeNode root, int K) {
        k = K;
        solve(root);
        return kthSmallestElement;
    }
}