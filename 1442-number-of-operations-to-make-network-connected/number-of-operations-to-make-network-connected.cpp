class Solution {
public:
    vector<vector<int>> buildAdjList(int n, vector<vector<int>>& connections) 
    {
        vector<vector<int>> adj(n); // Adjacency list for n vertices

        for (const auto& edge : connections) {
            int u = edge[0]; // Start vertex
            int v = edge[1]; // End vertex
            adj[u].push_back(v); // Add v to u's adjacency list
            adj[v].push_back(u); // Add u to v's adjacency list (since the graph is bidirectional)
        }

        return adj;
    }

    // Function to perform DFS
    void dfs(int node, vector<vector<int>>& adj, vector<bool>& visited) 
    {
        // Mark the current node as visited
        visited[node] = true;

        // Recursively visit all unvisited neighbors
        for(int neighbor : adj[node]) 
        {
            if(!visited[neighbor]) 
            dfs(neighbor, adj, visited);
        }
    }

    int makeConnected(int n, vector<vector<int>>& connections) 
    {
        // can't make the graph connected there are less than n - 1 edges
        if(connections.size() < n - 1)
        return -1;

        // Build the adjacency list
        vector<vector<int>> adj = buildAdjList(n, connections);

        // Initialize visited vector
        vector<bool> visited(n, false);

        int count = 0;
        // Perform DFS starting from unvisited vertex 
        for(int node = 0; node < n; node++)
        if(!visited[node])
        {
            dfs(node, adj, visited);
            count++;
        }
        return count - 1;
    }
};