class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        List<Integer>[] adj = new ArrayList[numCourses];
        // Initialize adjacency list
        for(int i = 0; i < numCourses; i++) 
        adj[i] = new ArrayList<>();

        // Build adjacency list
        for(int i = 0; i < prerequisites.length; i++) 
        {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            adj[prerequisite].add(course);
        }

        // Build in-degree array
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
        {
            for(int neighbor : adj[i]) 
            inDegree[neighbor]++;
        }

        // Add courses with in-degree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) 
        {
            if(inDegree[i] == 0) 
            queue.add(i);
        }

        // Process courses
        int finishedCourses = 0;
        int[] courseList = new int[numCourses];
        while(!queue.isEmpty()) 
        {
            int node = queue.poll();
            courseList[finishedCourses] = node;
            finishedCourses++;

            for(int neighbor : adj[node]) 
            {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) 
                queue.add(neighbor);
            }
        }
        return numCourses == finishedCourses ? courseList : new int[]{};
    }
}