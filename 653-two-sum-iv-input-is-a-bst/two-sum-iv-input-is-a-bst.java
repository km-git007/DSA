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

    BSTIterator(TreeNode root)
    {
        nextStack = new ArrayDeque<>();
        insertNext(root);
        prevStack = new ArrayDeque<>();
        insertPrev(root);
    }

    private Deque<TreeNode> nextStack, prevStack;
    public void insertNext(TreeNode root)
    {
        while(root != null)
        {
            nextStack.push(root);
            root = root.left;
        }
    }

    public int next()
    {
        TreeNode node = nextStack.pop();
        insertNext(node.right);
        return node.val;
    }

    public boolean hasNext()
    {
        return !nextStack.isEmpty();
    }

    public void insertPrev(TreeNode root)
    {
        while(root != null)
        {
            prevStack.push(root);
            root = root.right;
        }
    }

    public int prev()
    {
        TreeNode node = prevStack.pop();
        insertPrev(node.left);
        return node.val;
    }

    public boolean hasPrev()
    {
        return !prevStack.isEmpty();
    }
}

class Solution {
    
    public boolean findTarget(TreeNode root, int target) 
    {
        BSTIterator itr = new BSTIterator(root);
        int left = itr.next();
        int right = itr.prev();
        while(itr.hasNext() && itr.hasPrev())
        {
            if(left != right && left + right == target)
            return true;

            else if(left + right > target)
            right = itr.prev();

            else
            left = itr.next();
        }
        return false;
    }
}