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
    private Map<Integer, Set<Integer>> adj;
    private void buildGraph(TreeNode node, TreeNode parent)
    {
        if(node == null)
        return;

        if(!adj.containsKey(node.val))
        adj.put(node.val, new HashSet<>());

        Set<Integer> set = adj.get(node.val);

        if(parent != null)
        set.add(parent.val);

        if(node.left != null)
        set.add(node.left.val);

        if(node.right != null)
        set.add(node.right.val);

        buildGraph(node.left, node);
        buildGraph(node.right, node);

    }

    private int bfs(int startNode)
    {
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        // add the startNode in the queue and mark it as visited
        vis.add(startNode);
        q.add(startNode);

        int time = 0;
        while(!q.isEmpty())
        {
            int levelSize = q.size();
            while(levelSize > 0)
            {
                int node = q.poll();
                for(int ele : adj.get(node))
                {
                    if(!vis.contains(ele))
                    {
                        q.add(ele);
                        vis.add(ele);
                    }
                }
                levelSize--;
            }
            time++;
        }
        return time - 1;
    }

    public int amountOfTime(TreeNode root, int start) 
    {
        adj = new HashMap<>();
        buildGraph(root, null);
        return bfs(start);
    }
}