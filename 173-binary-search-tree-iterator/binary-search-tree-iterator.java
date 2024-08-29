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

    private int index;
    private List<Integer> inorder;
    private void inorderTraversal(TreeNode root)
    {
        if(root==null)
        return;

        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }

    public BSTIterator(TreeNode root) 
    {
        inorder=new ArrayList<>();
        index=0;
        inorderTraversal(root);
    }
    
    public int next() 
    {
        return inorder.get(index++);
    }
    
    public boolean hasNext() 
    {
        return index<inorder.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */