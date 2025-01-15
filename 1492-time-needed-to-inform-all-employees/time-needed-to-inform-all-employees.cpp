class Solution {
public:
    int bfs(int headID, vector<int>& informTime, vector<vector<int>> &adj)
    {
        queue<pair<int,int>> q;
        q.push({headID, 0});

        int minTime = 0;
        while(!q.empty())
        {
            auto p = q.front();
            q.pop();

            int manager = p.first;
            int time = p.second;

            minTime = max(minTime, time);

            for(int subOrdinates : adj[manager])
            q.push({subOrdinates, time + informTime[manager]});
    
        }

        return minTime;
    }

    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) 
    {
        vector<vector<int>> adj(n);
        for(int i = 0; i < manager.size(); i++)
        {
            if(i != headID)
            adj[manager[i]].push_back(i);
        }

        return bfs(headID, informTime, adj);
    }
};