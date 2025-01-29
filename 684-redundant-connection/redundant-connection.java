class Solution {
    
    private class DSU {
        private int[] parent, rank;
        // Constructor
        public DSU(int n) 
        {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) 
            {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // Find function with path compression
        public int find(int x) 
        {
            if (x != parent[x]) {
                parent[x] = find(parent[x]); // Path compression
            }

            return parent[x];
        }

        // Union by rank
        public void unionSet(int x, int y) 
        {
            int parentX = find(x);
            int parentY = find(y);

            // Already in the same set
            if (parentX == parentY) return; 

            if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
            } else if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
            } else {
                parent[parentX] = parentY;
                rank[parentY]++;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) 
    {
        int N = edges.length;
        DSU dsu = new DSU(N);

        for (int[] edge : edges) 
        {
            // If input is 1-based
            int x = edge[0] - 1; 
            int y = edge[1] - 1;

            // Redundant edge found
            if(dsu.find(x) == dsu.find(y)) 
            return edge; 
            
            // do union
            dsu.unionSet(x, y);
        }

        // No redundant edge found
        return new int[0]; 
    }
}
