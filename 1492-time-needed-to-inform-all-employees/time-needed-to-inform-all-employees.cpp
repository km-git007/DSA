class Solution {
public:
    int dfs(int id, vector<int>& informTime, vector<vector<int>> &adj)
    {
        int minTime = 0;
        for(int subOr : adj[id])
        minTime = max(minTime, informTime[id] + dfs(subOr, informTime, adj));
        
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

        return dfs(headID, informTime, adj);
    }
};