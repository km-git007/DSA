class Solution {

    private final int MOD = 1_000_000_007;
    private List<int[]>[] buildGraph(int n, int[][] roads){
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] road : roads){
            int node1 = road[0];
            int node2 = road[1];
            int time = road[2];
            adj[node1].add(new int[]{time, node2});
            adj[node2].add(new int[]{time, node1});
        }
        return adj;
    }

    public int countPaths(int n, int[][] roads) {
        var adj = buildGraph(n, roads);
        long[] count = new long[n];
        count[0] = 1;

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        boolean[] visited = new boolean[n];
        // Use Long.compare for safe comparison of long values
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});
        pq.offer(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currDistance = curr[0];
            int currNode = (int)curr[1];

            if(visited[currNode]) continue;
            visited[currNode] = true;

            for(var adjNode : adj[currNode]){
                int nbr = adjNode[1];
                int weight = adjNode[0];
                if(currDistance + weight < dist[nbr]){
                    dist[nbr] = currDistance + weight;
                    count[nbr] = count[currNode];
                    pq.offer(new long[]{dist[nbr], nbr});
                }
                else if(currDistance + weight == dist[nbr]){
                    count[nbr] = (count[nbr] + count[currNode]) % MOD;
                }
            }
        }
        return (int)count[n - 1] % MOD;
    }
}