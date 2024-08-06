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

    private void fillQueue(PriorityQueue<int[]> q,TreeNode root,int x,int y)
    {
        if(root==null)
        return;

        q.offer(new int[]{x,y,root.val});
        
        fillQueue(q,root.left,x-1,y+1);
        fillQueue(q,root.right,x+1,y+1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int horizontalDifference = a[0] - b[0];
            if (horizontalDifference != 0)
                return horizontalDifference;
            int verticalDifference = a[1] - b[1];
            if(verticalDifference!=0)
                return verticalDifference;
            return a[2]-b[2];
        });

        fillQueue(q,root,0,0);

        List<List<Integer>> ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            int[] node=q.poll();
            int x=node[0];
            List<Integer> list=new ArrayList<>();
            list.add(node[2]);

            while(!q.isEmpty() && q.peek()[0]==x)
            list.add(q.poll()[2]);

            ans.add(new ArrayList(list));
        }
        return ans;
    }
}