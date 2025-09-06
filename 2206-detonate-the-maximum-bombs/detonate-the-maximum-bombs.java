class Solution {
    private List<Integer>[] buildGraph(int[][] bombs){
        int n = bombs.length;
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == i){
                    continue;
                }
                long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                long x2 = bombs[j][0], y2 = bombs[j][1];
                if((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r1 * r1){
                    adj[i].add(j);
                }
            }
        }
        return adj;
    }


    private int dfs(int node, List<Integer>[] adj, boolean[] visited){
        if(visited[node]){
            return 0;
        }
        
        visited[node] = true;
        
        if(adj[node].isEmpty()){
            return 1;
        }
        
        int count = 1;
        for(int adjNode : adj[node]){
            count += dfs(adjNode, adj, visited);
        }
        return count;
    }
    
    public int maximumDetonation(int[][] bombs) {
        var adj = buildGraph(bombs);
        int maxBombsDetonated = 0;
        for(int node = 0; node < adj.length; node++){
            boolean[] visited = new boolean[adj.length];
            maxBombsDetonated = Math.max(maxBombsDetonated, dfs(node, adj, visited));
        }
        return maxBombsDetonated;
    }
}