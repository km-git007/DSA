import java.util.*;

class Solution {
    private int n;
    private List<Integer>[] adj;

    private void buildGraph(int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
    }

    private boolean bfs(int start, boolean[] vis){
        // BFS for this component
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        vis[start] = true;

        int count = 0;       // number of nodes
        int totalEdges = 0;  // sum of degrees

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            totalEdges += adj[node].size(); // add degree of this node

            for (int nbr : adj[node]) {
                if (!vis[nbr]) {
                    vis[nbr] = true;
                    queue.add(nbr);
                }
            }
        }

        // totalEdges is double-counted
        return totalEdges == count * (count - 1);
    }

    public int countCompleteComponents(int N, int[][] edges) {
        n = N;
        adj = new ArrayList[n];
        buildGraph(edges);

        boolean[] vis = new boolean[n];
        int completeComponents = 0;
        for (int start = 0; start < n; start++) {
            if (vis[start]) continue;
            completeComponents += bfs(start, vis) ? 1 : 0;
        }
        return completeComponents;
    }
}
