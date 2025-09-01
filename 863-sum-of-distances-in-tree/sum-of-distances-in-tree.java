class Solution {
    private List<Integer>[] adj;
    private int dfs1(int parent, int node, int level, int[] count, int[] dist){
        count[node] = 1;
        dist[0] += level;
        for(int neighbor : adj[node]){
            if(neighbor != parent){
                count[node] += dfs1(node, neighbor, level + 1, count, dist);
            }
        }
        return count[node];
    }

    private void dfs2(int parent, int node, int[] count, int[] dist, int n){
        if(parent != -1){
            dist[node] = dist[parent]- count[node] + (n - count[node]);
        }

        for(int neighbor : adj[node]){
            if(neighbor != parent){
                dfs2(node, neighbor, count, dist, n);
            }
        }
    }

    private List<Integer>[] buildGraph(int n, int[][] edges){
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return adj;
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        adj = buildGraph(n, edges);
        int[] count = new int[n];
        int[] dist = new int[n];
        dfs1(0, 0, 0, count, dist);
        dfs2(-1, 0, count, dist, n);
        return dist;
    }
}