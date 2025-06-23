class Solution {

    private int[] color;
    private boolean bfs(int node, int[][] graph) 
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 1;
        while (!queue.isEmpty()) 
        {
            int currNode = queue.poll();
            for(int adjNode : graph[currNode])
            {
                if(color[adjNode] == -1)
                {
                    color[adjNode] = 1 - color[currNode];
                    queue.add(adjNode);
                }
                else if(color[adjNode] == color[currNode])  // Conflict found
                {
                    return false;  // Only return false on conflict
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) 
    {
        int V = graph.length;
        color = new int[V];
        Arrays.fill(color,-1);

        for (int i = 0; i < V; i++) 
        {
            if (color[i] == -1) 
            {
                if(!bfs(i, graph))
                return false;
            }
        }
        return true;
    }
}