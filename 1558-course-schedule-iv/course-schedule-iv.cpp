class Solution {
public:
    vector<unordered_set<int>> canFinish(int V, vector<vector<int>>& prereq)
    {
        // creating adj list and indegree vector.
        vector<vector<int>> adj(V);
	    vector<int> ind(V, 0);

        for(auto x : prereq)
        {
            adj[x[0]].push_back(x[1]);
            ind[x[1]]++;
        }
        
        queue<int> q;
        // pushing nodes having zero indegree.
	    for(int i = 0; i < V; i++)        
	    {
	        if(ind[i] == 0)
	        q.push(i);
	    }

        // create a prereq vector
        vector<unordered_set<int>> map(V);
	    while(!q.empty())
	    {
	        int node = q.front();
	        q.pop();

	        for(int x : adj[node])
	        {
                // add node in the prereq of x
                map[x].insert(node);

                // add all nodes in the prereq of node in the prereq of x
                for(auto p : map[node])
                map[x].insert(p);

                ind[x]--;

	            if(ind[x] == 0)       
                q.push(x);
	        }
	    }

	    return map;
    }

    vector<bool> checkIfPrerequisite(int n, vector<vector<int>>& prereq, vector<vector<int>>& queries) 
    {
        auto map = canFinish(n, prereq);

        vector<bool> res;
        for(auto query : queries)
        {
            int u = query[0];
            int v = query[1];

            res.push_back(map[v].count(u));
        }

        return res;
    }
};