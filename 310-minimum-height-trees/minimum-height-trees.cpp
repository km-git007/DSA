class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) 
    {
        if (n == 1) return {0}; 

        vector<vector<int>> adj(n);
        vector<int> deg(n, 0);
        for(int i =0; i < edges.size(); i++)
        {
            vector<int> v = edges[i];
            adj[v[0]].push_back(v[1]);
            adj[v[1]].push_back(v[0]);
            deg[v[0]]++;
            deg[v[1]]++;
        }

        queue<int> q;

        for(int i = 0; i < n; i++)
        if(deg[i] == 1)
        q.push(i);

        int remain = n;
        while(remain > 2)
        {
            int level = q.size();
            while(level--)
            {
                int node = q.front();
                q.pop();
                remain--;

                for(int adjNode : adj[node])
                {
                    deg[adjNode]--;
                    if(deg[adjNode] == 1)
                    q.push(adjNode);
                }
            }
        }

        vector<int> mht;
        while(!q.empty())
        {
            mht.push_back(q.front());
            q.pop();
        }
        return mht;
    }
};