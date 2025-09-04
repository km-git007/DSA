class Solution {
    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }


    private void reverse(TreeNode left, TreeNode right, int level) {
        if(left == null || right == null) return;
        if(level % 2 == 1){
            swap(left, right);
        }
        reverse(left.left, right.right, level + 1);
        reverse(left.right, right.left, level + 1);
    }
    
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root.left == null && root.right == null) return root;
        reverse(root.left, root.right, 1);
        return root;
    }
}