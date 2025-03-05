class Solution {

    private List<List<int[]>> buildGraph(int[][] times, int n) 
    {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) 
        adj.add(new ArrayList<>());

        for(int[] time : times) 
        {
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adj.get(u).add(new int[]{t, v});
        }
        return adj;
    }

    public int networkDelayTime(int[][] times, int n, int k) 
    {
        // Create adjacency list
        var adj = buildGraph(times, n);

        // Create a time array
        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;

        // Visited array to optimize Dijkstra's
        boolean[] visited = new boolean[n + 1];

        // Min heap (priority queue) -> (time, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int currTime = p[0];
            int node = p[1];

            if (visited[node]) 
            continue;

            // Mark the node as visited
            visited[node] = true;

            for (int[] neighbor : adj.get(node)) 
            {
                int edgeTime = neighbor[0];
                int adjNode = neighbor[1];
                if (time[adjNode] > edgeTime + currTime) 
                {
                    time[adjNode] = edgeTime + currTime;
                    pq.offer(new int[]{time[adjNode], adjNode});
                }
            }
        }

        int maxTime = 0;
        // Check if all nodes are reachable
        for (int i = 1; i <= n; i++) 
        {
            if (time[i] == Integer.MAX_VALUE) 
            return -1;
            maxTime = Math.max(maxTime, time[i]);
        }
        return maxTime;
    }
}
