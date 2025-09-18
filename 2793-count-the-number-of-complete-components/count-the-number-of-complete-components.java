class Solution {
    private int n;
    private List<Integer>[] adj;
    private void buildGraph(int[][] edges){
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
    }

    private int[] dfs(int node, boolean[] vis){
        vis[node] = true;

        int edges = adj[node].size();
        int count = 1;
        for(int nbr : adj[node]){
            if(!vis[nbr]){
                int[] res = dfs(nbr, vis);
                edges += res[0];
                count += res[1];
            }
        }
        return new int[]{edges, count};
    }

    public int countCompleteComponents(int N, int[][] edges) {
        n = N;
        adj = new ArrayList[n];
        buildGraph(edges);

        boolean[] vis = new boolean[n];
        int completeComponents = 0;
        for(int node = 0; node < n; node++){
            if(vis[node]){
                continue;
            }
            int[] res = dfs(node, vis);
            int totalEdges = res[0], count = res[1];
            if(totalEdges == count * (count - 1)){
                completeComponents++;
            }
        }
        return completeComponents;
    }
}