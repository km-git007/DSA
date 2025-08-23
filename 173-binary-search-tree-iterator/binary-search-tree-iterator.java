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
class BSTIterator {
    private List<TreeNode> arr;
    private int index;
    private void inorderTraversal(TreeNode root) {
        if(root == null) return;
        inorderTraversal(root.left);
        arr.add(root);
        inorderTraversal(root.right);
    }

    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        inorderTraversal(root);
        index = 0;
    }

    public int next() {
        return  arr.get(index++).val;
    }

    public boolean hasNext() {
        return index < arr.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */