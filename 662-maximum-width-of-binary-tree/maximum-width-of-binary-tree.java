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
    public int widthOfBinaryTree(TreeNode root) 
    {
        // Declare a Queue of array of objects
        Deque<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root,0L});
        long maxWidth=0;
        while(!queue.isEmpty())
        {
            int levelSize=queue.size();
            long startIndex=(long)queue.peek()[1];
            maxWidth=Math.max(maxWidth,(long)queue.peekLast()[1]-startIndex+1);
            for(int i=0;i<levelSize;i++)
            {
                TreeNode node=(TreeNode)queue.peek()[0];
                long index=(long)queue.peek()[1]-startIndex;
                queue.poll();

                if(node.left!=null)
                queue.offer(new Object[]{node.left,2*index+1});

                if(node.right!=null)
                queue.offer(new Object[]{node.right,2*index+2});
            }
        }
        return (int)maxWidth;
    }
}