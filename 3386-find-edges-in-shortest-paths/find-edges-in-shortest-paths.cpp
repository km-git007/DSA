class Solution {
public:
    void buildGraph(vector<vector<pair<int,int>>> &adj, vector<vector<int>>& edges)
    {
        for(auto edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj[u].push_back({v, wt});
            adj[v].push_back({u, wt});
        }
    }

    vector<int> dijkstrasAlgo(int n, int source, vector<vector<pair<int,int>>> &adj)
    {
        // create a distance array
        vector<int> dist(n, 1e9);
        dist[source] = 0;

        // create a vis array
        // this is optimal dijkstras
        vector<bool> vis(n, false);

        // Min-heap of pair {wt, node}
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
        pq.push({0, source});

        while(!pq.empty())
        {
            auto p = pq.top();
            pq.pop();

            int node = p.second;
            int currDist = p.first;

            if(vis[node])
            continue;

            for(auto adjNode : adj[node])
            {
                int neighbour = adjNode.first;
                int wt = adjNode.second;
                if(dist[neighbour] > currDist + wt)
                {
                    dist[neighbour] = currDist + wt;
                    pq.push({dist[neighbour], neighbour});
                }
            }

            // mark the node as visited after exploring the neighbours
            vis[node] = true;
        }
        return dist;
    }

    vector<bool> findAnswer(int n, vector<vector<int>>& edges) 
    {
        vector<vector<pair<int,int>>> adj(n);
        // build adj list
        buildGraph(adj, edges);

        vector<int> distFromSource = dijkstrasAlgo(n, 0, adj);
        vector<int> distFromDest = dijkstrasAlgo(n, n - 1, adj);

        int m = edges.size();
        vector<bool> res(m, false);
        for(int i = 0; i < m; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            if(distFromSource[u] + wt + distFromDest[v] == distFromSource[n - 1])
            res[i] = true;

            if(distFromSource[v] + wt + distFromDest[u] == distFromSource[n - 1])
            res[i] = true;
        }

        return res;
    }
};