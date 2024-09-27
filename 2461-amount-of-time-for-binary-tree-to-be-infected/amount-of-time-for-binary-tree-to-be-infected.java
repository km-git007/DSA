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
        adjacencyList = new ArrayList[100001];
        // Initialize each element of the array as a new ArrayList
        for(int i = 0; i < adjacencyList.length; i++) 
        adjacencyList[i] = new ArrayList<>();

        minTime = 0;
        visited = new int[adjacencyList.length];
    }

    private void buildAdjacencyList(TreeNode root)
    {
        if(root == null)
        return;

        if(root.left!=null)
        {
            adjacencyList[root.left.val].add(root.val);
            adjacencyList[root.val].add(root.left.val);
        }

        if(root.right!=null)
        {
            adjacencyList[root.right.val].add(root.val);
            adjacencyList[root.val].add(root.right.val);
        }
        
        buildAdjacencyList(root.left);
        buildAdjacencyList(root.right);
    }
    
    private int minTime;
    private int[] visited;
    private List<Integer>[] adjacencyList;
    private void dfs(int node,int time)
    {
        visited[node] = 1;
        for(int adj : adjacencyList[node]) 
        {
            if(visited[adj]==0)
            dfs(adj,time+1);
        }
        minTime = Math.max(minTime,time);
    }
    
    public int amountOfTime(TreeNode root, int start)
    {
        buildAdjacencyList(root);
        dfs(start,0);
        return minTime;
    }
}