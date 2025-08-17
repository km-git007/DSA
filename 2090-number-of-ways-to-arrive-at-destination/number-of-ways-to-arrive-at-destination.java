class Solution {
    private List<int[]>[] buildGraph(int n, int[][] roads){
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] road : roads){
            int source = road[0];
            int target = road[1];
            int travelTime = road[2]; 
            adj[source].add(new int[]{travelTime, target});
            adj[target].add(new int[]{travelTime, source});
        }
        return adj;
    }

    public int countPaths(int n, int[][] roads) {
        var adj = buildGraph(n, roads);
        
        // Priority queue with long for distances
        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        queue.offer(new long[]{0, 0});
        
        long[] ways = new long[n]; 
        ways[0] = 1;
        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;
        
        int MOD = 1000000007;        
        while(!queue.isEmpty()){
            long[] data = queue.poll();
            long currTime = data[0];
            int node = (int)data[1];
            
            if(currTime > time[node]) continue;
            
            for(int[] neighbor : adj[node]){ 
                int travelTime = neighbor[0];  
                int adjNode = neighbor[1];
                long newTime = currTime + (long)travelTime; 

                if(newTime < time[adjNode]){
                    time[adjNode] = newTime;
                    ways[adjNode] = ways[node];
                    queue.offer(new long[]{newTime, adjNode});
                } else if (newTime == time[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }
        return (int)(ways[n - 1] % MOD);
    }
}
