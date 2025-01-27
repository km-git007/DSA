class Solution {
public:

    bool canFinish(int v, vector<vector<int>>& prerequisites) 
    {
        // creating adj list.
        vector<int> adj[v];

	    // creating indegree vector.
	    vector<int> ind(v,0);

        for(auto x : prerequisites)
        {
            adj[x[1]].push_back(x[0]);
            ind[x[0]]++;
        }
        
        queue<int> q;
        // pushing nodes having zero indegree.
	    for(int i=0;i<v;i++)        
	    {
	        if(ind[i]==0)
	        q.push(i);
	    }

        int count=0;
	    while(!q.empty())
	    {
	        int node=q.front();
	        q.pop();
            count++;
	        for(int x: adj[node])
	        {
	            ind[x]--;           // decreasing indegree by 1.
	            if(ind[x]==0)       // if indegree becomes zero. push the node in the queue.
	            q.push(x);
	        }
	    }
	    return count == v;
    }
};