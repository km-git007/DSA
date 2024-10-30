class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) 
    {
        vector<int> adj[n + 1];
        vector<int> indegree(n + 1, 0);
        // Build the adjacency list and indegree array
        for(int i = 0; i < relations.size(); i++)
        {
            adj[relations[i][0]].push_back(relations[i][1]);
            indegree[relations[i][1]]++;
        }
        
        
        queue<int> queue;
        // Push all nodes with 0 indegree into the queue
        for(int i = 1; i <= n; i++)
        if(indegree[i] == 0)
        queue.push(i);
        
        // prev couses kitna time lenge completehone mein tab jake ye start hoga.
        vector<int> startAfter(n + 1, 0);
        while(!queue.empty())
        {
            int node = queue.front();
            queue.pop();
            int currCourseTime = time[node-1];

            for(int adjNode : adj[node])
            {
                indegree[adjNode]--;
                startAfter[adjNode] = max(startAfter[adjNode], startAfter[node] + currCourseTime);
                if(indegree[adjNode] == 0)
                queue.push(adjNode);
            }
        }

        int monthsToCompleteAllCourses = 0;
        for(int i = 1; i <= n; i++)
        monthsToCompleteAllCourses = max(monthsToCompleteAllCourses, startAfter[i] + time[i-1]);
        return monthsToCompleteAllCourses; 
    }
};