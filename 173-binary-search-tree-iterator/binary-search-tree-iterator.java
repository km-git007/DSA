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

    private Deque<TreeNode> stack;
    private void inorderTraversal(TreeNode root)
    {
        if(root==null)
        return;

        stack.push(root);
        inorderTraversal(root.left);
    }

    public BSTIterator(TreeNode root) 
    {
        stack=new ArrayDeque<>();
        inorderTraversal(root);
    }
    
    public int next() 
    {
        TreeNode node=stack.pop();

        if(node.right!=null)
        inorderTraversal(node.right);

        return node.val;
    }
    
    public boolean hasNext() 
    {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */