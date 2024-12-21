class Solution {
public:
    int k, componentCount;
    int solve(int node, int parent, vector<vector<int>> &adj, vector<int> &values)
    {
        int sum = 0;
        for(int adjNode : adj[node])
        {
            if(adjNode != parent)
            {
                sum += solve(adjNode, node, adj, values);
                // Ensure the sum stays within bounds
                sum %= k;
            }
        }

        sum += values[node];
        sum %= k;

        if(sum % k == 0)
        componentCount++;

        return sum;
    }

    int maxKDivisibleComponents(int n, vector<vector<int>>& edges, vector<int>& values, int K) 
    {
        // Step 1: Create adjacency list from edges
        vector<vector<int>> adj(n);
        for (auto edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adj[node1].push_back(node2);
            adj[node2].push_back(node1);
        }
        // Step 2: Initialize component count and k
        componentCount = 0;
        k = K;

        // Step 3: Start DFS traversal from node 0
        solve(0, -1, adj, values);

        // Step 4: Return the total number of components
        return componentCount;
    }
};