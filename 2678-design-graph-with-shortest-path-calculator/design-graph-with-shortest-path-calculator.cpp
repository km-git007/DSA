class Graph {
public:
    int N;
    vector<vector<pair<int,int>>> adj;
    Graph(int n, vector<vector<int>>& edges) 
    {
        N = n;
        // create adj list
        adj = vector<vector<pair<int,int>>>(n);
        for(auto edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj[u].push_back({v,wt});
        }
    }
    
    void addEdge(vector<int> edge) 
    {
        int u = edge[0];
        int v = edge[1];
        int wt = edge[2];

        adj[u].push_back({v,wt});
    }
    
    int shortestPath(int src, int dest) 
    {
        vector<int> dist(N, INT_MAX);
        dist[src] = 0;

        vector<int> vis(N, 0);
    
        // Min-heap {dist, node}
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
        pq.push({0, src}); 
    
        // Dijkstras Algorithm
        while (!pq.empty()) 
        {
            auto curr = pq.top();
            pq.pop();
            int currDist = curr.first;
            int node = curr.second;
        
            // If we reach the destination, return the distance
            if (node == dest)
            return currDist;

            // if the current node is visited we already have got the shortest distance to reach this node
            if(vis[node])
            continue;

            // mark the node as visited 
            vis[node] = 1;

            // Explore all neighbours
            for(auto adjNode : adj[node])
            {
                int neigh = adjNode.first;
                int wt = adjNode.second;
                
                // If a smaller dist is found, update and push to the priority queue
                if(dist[neigh] > wt + currDist)
                {
                    dist[neigh] = wt + currDist;
                    pq.push({dist[neigh], neigh});
                }
            }
        }
        // return whatever the fuck you want to
        return -1;
    }
};

/**
 * Your Graph object will be instantiated and called as such:
 * Graph* obj = new Graph(n, edges);
 * obj->addEdge(edge);
 * int param_2 = obj->shortestPath(node1,node2);
 */