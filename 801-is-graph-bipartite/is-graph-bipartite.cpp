class Solution {
public:
    bool dfs(int node, int col, vector<vector<int>>& graph, vector<bool>& vis, vector<int>& color)
    {
        if(vis[node])
        return color[node] == col;

        vis[node] = true;
        color[node] = col;
        
        for(int nbr : graph[node])
        {
            if(!dfs(nbr, 1 - col, graph, vis, color))
            return false;
        }
        
        return true;
    }

    bool isBipartite(vector<vector<int>>& graph) 
    {
        int n = graph.size();
        vector<bool> vis(n, false);  // Separate visited array
        vector<int> color(n, -1);    // Color array only for storing colors
        
        // Check each component of the graph
        for(int node = 0; node < n; node++)
        {
            if(!vis[node] && !dfs(node, 0, graph, vis, color))
            return false;
        }
        return true;
    }
};