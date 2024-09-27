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

    public Solution()
    {
        minTime = 0;
        adjList = new HashMap<>();
        visited = new HashSet<>();
    }

    private void buildAdjList(TreeNode root,TreeNode parent)
    {
        if(root == null)
        return;

        if(!adjList.containsKey(root.val))
        adjList.put(root.val,new HashSet<>());

        HashSet<Integer> set=adjList.get(root.val);

        if(parent!=null)
        set.add(parent.val);

        if(root.left != null) 
        set.add(root.left.val);

        if(root.right != null) 
        set.add(root.right.val);

        buildAdjList(root.left,root);
        buildAdjList(root.right,root);
    }
    
    private int minTime;
    private HashSet<Integer> visited;
    private HashMap<Integer,HashSet<Integer>> adjList;
    private void dfs(int node,int time)
    {
        visited.add(node);
        HashSet<Integer> neighbours=adjList.get(node);
        for(Integer neighbour : neighbours) 
        {
            if(!visited.contains(neighbour))
            dfs(neighbour,time+1);
        }
        minTime = Math.max(minTime,time);
    }
    
    public int amountOfTime(TreeNode root, int start)
    {
        buildAdjList(root,null);
        dfs(start,0);
        return minTime;
    }
}