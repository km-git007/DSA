class Solution {
public:
    int maxProfit;
    vector<vector<int>> adj;
    unordered_map<int, int> nodeTimeMap;
    bool bobDFS(int node, int time, vector<int> &vis)
    {
        if(vis[node])
        return false;

        vis[node] = 1;
        nodeTimeMap[node] = time;

        if(node == 0)
        return true;

        for(int nbr : adj[node])
        {
            if(bobDFS(nbr, time + 1, vis))
            return true;
        }

        nodeTimeMap.erase(node);
        return false;
    }

    void aliceDFS(int node, int time, int profit, vector<int> &vis, vector<int>& amount)
    {
        if(vis[node])
        return;

        // mark the node as visited
        vis[node] = 1;

        // check if bob can reach this node before alice
        if(!nodeTimeMap.count(node) || time < nodeTimeMap[node])
        profit += amount[node];

        else if(time == nodeTimeMap[node])
        profit += amount[node] / 2;

        // if its a leaf node then update maxProfit
        if(adj[node].size() == 1 && vis[adj[node].back()])
        maxProfit = max(maxProfit, profit);

        for(int nbr : adj[node])
        aliceDFS(nbr, time + 1, profit, vis, amount);
    }

    int mostProfitablePath(vector<vector<int>>& edges, int bob, vector<int>& amount) 
    {
        // build the adjacency list
        int n = edges.size() + 1;
        buildAdj(edges);

        vector<int> vis(n, 0);
        bobDFS(bob, 0, vis);

        maxProfit = INT_MIN;
        vis.assign(n, 0);

        aliceDFS(0, 0, 0, vis, amount);
        return maxProfit;
    }

    void buildAdj(vector<vector<int>>& edges)
    {
        int n = edges.size() + 1;
        adj = vector<vector<int>>(n);
        for(auto edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            adj[u].push_back(v);
            adj[v].push_back(u);
        }
    }
};