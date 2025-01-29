class Solution {
public:
    bool canReach(int node, int target, vector<int> &vis, vector<int> adj[])
    {
        if(node == target)
        return true;

        vis[node] = 1;

        for(int nbr : adj[node])
        {
            if(!vis[nbr])
            {
                if(canReach(nbr, target, vis, adj))
                return true;
            }
        }

        return false;
    }

    vector<int> findRedundantConnection(vector<vector<int>>& edges) 
    {
        int N = edges.size();
        vector<int> adj[N];

        for(auto edge : edges)
        {
            vector<int> vis(N, 0);

            int u = edge[0] - 1;
            int v = edge[1] - 1;

            if(canReach(u, v, vis, adj))
            return edge;

            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        return {};
    }
};