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
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int levelSize = q.size();
            long sum = 0;
            for(int i=0; i<levelSize;i++)
            {
                TreeNode node = q.poll();
                sum += node.val;

                if(node.right!=null)
                q.add(node.right);

                if(node.left!=null)
                q.add(node.left);
            }
            minHeap.add(sum);
            if(minHeap.size() > k)
            minHeap.poll();
        }
        return (minHeap.size() == k) ? minHeap.peek() : -1;
    }
}