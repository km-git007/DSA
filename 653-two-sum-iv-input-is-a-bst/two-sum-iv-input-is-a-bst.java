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

    private Deque<TreeNode> stack = new ArrayDeque<>();
    private boolean reverse;

    public BSTIterator(TreeNode root, boolean isReverse) 
    {
        this.reverse = isReverse;
        pushNodes(root);
    }

    private void pushNodes(TreeNode node) 
    {
        while (node != null) 
        {
            stack.push(node);
            node = reverse ? node.right : node.left;
        }
    }

    public int next() 
    {
        TreeNode node = stack.pop();
        pushNodes(reverse ? node.left : node.right);
        return node.val;
    }

    public boolean hasNext() 
    {
        return !stack.isEmpty();
    }
}

class Solution {
    
    public boolean findTarget(TreeNode root, int target) 
    {
        if(root == null) 
        return false;

        BSTIterator leftItr = new BSTIterator(root, false); // In-order
        BSTIterator rightItr = new BSTIterator(root, true); // Reverse in-order

        int left = leftItr.next();
        int right = rightItr.next();

        while(leftItr.hasNext() && rightItr.hasNext())
        {
            if(left != right && left + right == target)
            return true;

            else if(left + right > target)
            right = rightItr.next();

            else
            left = leftItr.next();
        }
        return false;
    }
}