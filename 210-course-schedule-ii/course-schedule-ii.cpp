class Solution {
public:
    vector<int> findOrder(int V, vector<vector<int>>& prerequisites) 
    {
        // creating adj list.
        vector<vector<int>> adj(V);

	    // creating indegree vector.
	    vector<int> ind(V,0);

        for(auto x : prerequisites)
        {
            adj[x[1]].push_back(x[0]);
            ind[x[0]]++;
        }
        
        queue<int> q;
        // pushing nodes having zero indegree.
	    for(int i = 0; i < V; i++)        
	    {
	        if(ind[i] == 0)
	        q.push(i);
	    }

        vector<int> order;
	    while(!q.empty())
	    {
	        int node=q.front();
	        q.pop();
            // push in the result
            order.push_back(node);

	        for(int x : adj[node])
	        {
	            ind[x]--;           //decreasing indegree by 1.
	            if(ind[x] == 0)       //if indegree becomes zero. push the node in the queue.
	            q.push(x);
	        }
	    }

	    return order.size() == V ? order : vector<int>();
    }
};