class Solution {
    private List<List<Integer>>[] buildGraph(int n, int[][] times){
        List<List<Integer>>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] time : times) {
            int currNode = time[0];
            int neighbour = time[1];
            int distance = time[2];
            adj[currNode].add(List.of(neighbour, distance));
        }

        return adj;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        var adj = buildGraph(n, times);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            var curr = pq.poll();
            int distance = curr[0];
            int node = curr[1];

            if (distance > dist[node]) continue;

            for(var adjNode : adj[node]) {
                int nbr = adjNode.get(0);
                int weight = adjNode.get(1);
                if(distance + weight < dist[nbr]) {
                    dist[nbr] = distance + weight;
                    pq.offer(new int[]{dist[nbr], nbr});
                }
            }
        }
        
        int minTime = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE)
            return -1;
            minTime = Math.max(minTime, dist[i]);
        }
        return minTime;
    }
}