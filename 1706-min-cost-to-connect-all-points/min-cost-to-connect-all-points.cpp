class Solution {
public:
    int minSpanningTree(int V, vector<vector<int>> adj[])
    {
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, 0}); // Start with node 0 and edge weight 0
    
        int sum = 0; // To store the total weight of the MST
        vector<int> vis(V, 0); // Visited array to track included nodes
        while(!pq.empty())
        {
            auto v = pq.top();
            pq.pop();
            
            int wt = v[0], node = v[1];
            
            // If the node is already included in the MST, skip it
            if(vis[node])
            continue;
      
            // Mark the node as visited and add the edge weight to the MST sum
            vis[node] = 1;
            sum += wt;

            // Traverse all adjacent nodes
            for(auto& adjVector : adj[node])
            {
                int edgeWt = adjVector[1];
                int adjNode = adjVector[0];

                // If the adjacent node is not yet included, push it to the heap
                if(!vis[adjNode])
                pq.push({edgeWt, adjNode});
            }
        }
        return sum;
    }

    int minCostConnectPoints(vector<vector<int>>& points) 
    {
        int n = points.size();
        if(n == 1)
        return 0;

        // creating adjacency list
        vector<vector<int>> adj[n];
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                adj[i].push_back({j, abs(x1 - x2) + abs(y1 - y2)});
                adj[j].push_back({i, abs(x1 - x2) + abs(y1 - y2)});
            }
        }

        return minSpanningTree(n, adj);
    }
};