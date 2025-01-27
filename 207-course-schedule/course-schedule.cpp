class Solution {
public:
    vector<int> vis, pathVis;
    bool hasCycle(int node, vector<int> adj[])
    {
        if(vis[node] && pathVis[node])
        return true;

        if(vis[node])
        return false;

        vis[node] = 1;
        pathVis[node] = 1;

        for(int adjNode : adj[node])
        {
            if(hasCycle(adjNode, adj))
            return true;
        }

        pathVis[node] = 0;
        return false;
    }

    bool canFinish(int V, vector<vector<int>>& prerequisites) 
    {
        // creating adj list.
        vector<int> adj[V];

        for(auto x : prerequisites)
        adj[x[1]].push_back(x[0]);
        
        // vis and pathVis vectors
        vis = pathVis = vector<int>(V, 0);

        for(int i = 0; i < V; i++) 
        {
            if(!vis[i]) 
            {
                if(hasCycle(i, adj))
                return false; // Cycle detected so can't finish the courses
            }
        }

        return true;
    }
};