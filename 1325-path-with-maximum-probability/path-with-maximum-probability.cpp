class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start_node, int end_node) 
    {
        // Initialize adjacency list
        vector<vector<pair<double, int>>> adj(n);

        // Iterate through edges and populate adjacency list
        for (int i = 0; i < edges.size(); i++) 
        {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            // Add bidirectional edges
            adj[u].push_back({prob, v});
            adj[v].push_back({prob, u});
        }

        // create a probability vector
        vector<double> prob(n,-1.00);
        prob[start_node] = 1.00;

        // Default max heap for pairs
        priority_queue<pair<double, int>> pq;
        pq.push({1.00, start_node});
        while(!pq.empty())
        {
            auto p = pq.top();
            pq.pop();
            double currProb = p.first;
            int node = p.second;

            for(auto neighbour : adj[node])
            {
                double newProb = neighbour.first;
                int adjNode = neighbour.second;
                if(prob[adjNode] < newProb * currProb)
                {
                    prob[adjNode] = newProb * currProb;
                    pq.push({prob[adjNode], adjNode});
                }
            }
        }
        return prob[end_node] == -1.00 ? 0 : prob[end_node];
    }
};