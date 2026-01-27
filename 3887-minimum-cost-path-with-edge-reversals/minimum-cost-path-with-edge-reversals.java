class Solution {
 private void buildGraph(List<int[]>[] adj, int[][] edges){
        for(int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            adj[from].add(new int[]{to, weight});
            // add edge after reversal
            adj[to].add(new int[]{from, weight * 2});
        }
    }
    
    public int minCost(int n, int[][] edges) {
        List<int[]>[] adj = new List[n];
        buildGraph(adj, edges);
        
        int[] distance = new int[n];
        for(int i = 1; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // {dist, node}
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int dist = curr[1];
            int node = curr[0];
            
            // early exit
            if(dist > distance[node]){
                continue;
            }
            
            for(int[] adjNode : adj[node]) {
                int weight = adjNode[1];
                int nbr = adjNode[0];
                if(dist + weight < distance[nbr]) {
                    distance[nbr] = dist + weight;
                    queue.add(new int[]{nbr, distance[nbr]});
                }
            }
        }
        return distance[n - 1] == Integer.MAX_VALUE ? -1 : distance[n - 1];
    }
}