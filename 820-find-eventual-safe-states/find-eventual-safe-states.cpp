class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) 
    {
        int v=graph.size();
        // creating adjacency list by reversing the edges of the graph.
        vector<int> adj[v];
	    vector<int> ind(v,0);
        for(int i=0;i<v;i++)          
        {
            for(int j=0;j<graph[i].size();j++)
            {
                adj[graph[i][j]].push_back(i);
                ind[i]++;
            }
        }

        queue<int> q;
	    vector<int> ans;

	    for(int i=0;i<v;i++)
	    {
	        if(ind[i]==0)
	        q.push(i);
	    }

	    while(!q.empty())
	    {
	        int node=q.front();
	        q.pop();
	        ans.push_back(node);
	        for(int x: adj[node])
	        {
	            ind[x]--;
	            if(ind[x]==0)
	            q.push(x);
	        }
	    }

        sort(ans.begin(),ans.end());
	    return ans;
    }
};