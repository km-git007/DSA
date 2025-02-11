class Solution {
public:
    vector<vector<pair<int, int>>> buildAdj(int n, vector<vector<int>>& roads)
    {
        vector<vector<pair<int, int>>> adj(n);
        for(auto road : roads)
        {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adj[u].push_back({v, time});
            adj[v].push_back({u, time});
        }
        return adj;
    }

    int countPaths(int n, vector<vector<int>>& roads) 
    {
        int mod = 1e9 + 7;
        auto adj = buildAdj(n, roads);

        vector<int> ways(n, 0);
        vector<long long> dist(n, LLONG_MAX);
        ways[0] = 1;
        dist[0] = 0;

        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<>> pq;
        pq.push({0, 0});
        while(!pq.empty())
        {
            auto [currDist, node] = pq.top();
            pq.pop();

            if(currDist > dist[node]) 
            continue;

            for(auto [nbr, wt] : adj[node])
            {
                if(currDist + wt < dist[nbr])
                {
                    dist[nbr] = currDist + wt;
                    ways[nbr] = ways[node];
                    pq.push({dist[nbr], nbr});
                }
                else if(currDist + wt == dist[nbr])
                {
                    ways[nbr] = (ways[nbr] % mod + ways[node] % mod) % mod;
                }
            }
        }
        return ways[n - 1];
    }
};