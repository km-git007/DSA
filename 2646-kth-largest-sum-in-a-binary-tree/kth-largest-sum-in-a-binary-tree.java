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

    public long kthLargestLevelSum(TreeNode root, int k) 
    {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int level=q.size();
            long sum=0;
            for(int i=0;i<level;i++)
            {
                TreeNode curr=q.poll();
                sum+=curr.val;

                if(curr.left!=null)
                q.add(curr.left);

                if(curr.right!=null)
                q.add(curr.right);
            }
            // Add in the priority queue.
            minHeap.add(sum);
            if(minHeap.size()>k)
            minHeap.poll();
        }

        if(minHeap.size()<k)
        return -1;
        return minHeap.peek();
    }
}