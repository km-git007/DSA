class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if(curr.left != null) {
                TreeNode node = curr.left;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = curr.right;
                
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
