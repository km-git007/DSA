class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) 
    {
        // create adjacency list {node, cost}
        vector<pair<int,int>> adj[n];
        for(int i = 0; i < flights.size(); i++)
        {
            vector<int> v = flights[i];
            adj[v[0]].push_back({v[1],v[2]});
        }

        vector<int> cost(n, INT_MAX);
        cost[src] = 0;

        // queue - pair{node, cost}
        queue<pair<int,int>> q;
        q.push({src,0});
        int stops = 0;
        while(stops <= k)
        {
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++)
            {
                auto p = q.front();
                q.pop();
                int node = p.first;
                int currCost = p.second;

                for(auto neighbour : adj[node])
                {
                    int adjNode = neighbour.first;
                    int price = neighbour.second;
                    if(cost[adjNode] > price + currCost)
                    {
                        cost[adjNode] = price + currCost;
                        q.push({adjNode, cost[adjNode]});
                    }
                }
            }
            stops++;
        }
        return cost[dst] == INT_MAX ? -1 : cost[dst];
    }
};