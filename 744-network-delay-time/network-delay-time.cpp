class Solution {
public:
    void buildGraph(vector<vector<pair<int, int>>> &adj, vector<vector<int>>& times)
    {
        // Iterate through times and populate adjacency list
        for (int i = 0; i < times.size(); i++) 
        {
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];

            adj[u].push_back({t, v});
        }
    }

    int networkDelayTime(vector<vector<int>>& times, int n, int k) 
    {
        // create adjacency list
        vector<vector<pair<int, int>>> adj(n + 1);
        buildGraph(adj, times);

        // create a time vector
        vector<int> time(n + 1, INT_MAX);
        time[k] = 0;

        // create a vis array to optimise dijkstras
        vector<bool> vis(n + 1, false);

        // min heap for pairs
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, k});
        while(!pq.empty())
        {
            auto p = pq.top();
            pq.pop();
            int currTime = p.first;
            int node = p.second;

            if(vis[node])
            continue;

            for(auto neighbour : adj[node])
            {
                int edgeTime = neighbour.first;
                int adjNode = neighbour.second;
                if(time[adjNode] > edgeTime + currTime)
                {
                    time[adjNode] = edgeTime + currTime;
                    pq.push({time[adjNode], adjNode});
                }
            }

            // mark the node as visited after exploring all neighbours
            vis[node] = true;
        }
        
        int maxTime = 0;
        // Check if all nodes are reachable
        for (int i = 1; i <= n; i++) 
        {
            if (time[i] == INT_MAX) 
            return -1;
            maxTime = max(maxTime,time[i]);
        }
        return maxTime;
    }
};