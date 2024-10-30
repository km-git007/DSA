class Solution {

    private int[] color;
    private boolean dfs(int node, int[][] graph) 
    {
        for(int adjNode : graph[node])
        {
            if(color[adjNode] == -1)
            {
                color[adjNode] = color[node] == 1 ? 0 : 1;
                if(!dfs(adjNode, graph))
                return false;
            }
            else if(color[adjNode] == color[node])
            return false;  
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
                color[i] = 1;
                if(!dfs(i, graph))
                return false;
            }
        }
        return true;
    }
}