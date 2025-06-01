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

    int networkDelayTime(vector<vector<int>>& times, int n, int src) 
    {
        // create adjacency list
        vector<vector<pair<int, int>>> adj(n + 1);
        buildGraph(adj, times);

        vector<int> time(n + 1, INT_MAX);
        time[src] = 0;

        //to optimise the dijaktras
        vector<bool> vis(n + 1, false);

        // min heap for pairs {time, node}
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        pq.push({0, src});

        while(!pq.empty())
        {
            auto p = pq.top();
            pq.pop();

            int currTime = p.first;
            int currNode = p.second;

            if(vis[currNode])
            continue;

            for(auto pair : adj[currNode])
            {
                int nbr = pair.second;
                int travelTime = pair.first;

                if(currTime + travelTime < time[nbr])
                {
                    time[nbr] = currTime + travelTime;
                    pq.push({time[nbr], nbr});
                }
            }

            vis[currNode] = true;
        }

        int maxTime = 0;
        for(int i = 1; i < time.size(); i++)
        maxTime = max(maxTime, time[i]);

        return maxTime == INT_MAX ? -1 : maxTime;
    }
};