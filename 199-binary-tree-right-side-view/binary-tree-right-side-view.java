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
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> list=new ArrayList<>();
        if(root==null)
        return list;

        Deque<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int levelSize=q.size();
            for(int i=0;i<levelSize;i++)
            {
                TreeNode node=q.poll();
                
                if(i==levelSize-1)
                list.add(Integer.valueOf(node.val));

                if(node.left!=null)
                q.offer(node.left);

                if(node.right!=null)
                q.offer(node.right);
            }
        }
        return list;
    }
}