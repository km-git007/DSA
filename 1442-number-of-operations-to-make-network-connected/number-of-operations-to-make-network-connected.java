class Solution {
    private class DSU 
    {
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

        // Getter method
        public int[] getParent() { 
            return parent;
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

    public int makeConnected(int n, int[][] connections) 
    {
        // cant make the network connected if edges are less than n - 1;
        if(connections.length < n - 1)
        return -1;

        DSU dsu = new DSU(n);

        // calculate the redundant edges i.e edges that are extra
        int extraEdges = 0;
        for(int[] conn : connections)
        {
            int x = conn[0];
            int y = conn[1];

            if(dsu.find(x) == dsu.find(y))
            extraEdges++;

            else
            dsu.unionSet(x, y);
        }

        // calculate the number of components
        int[] parentArray = dsu.getParent();
        int components = 0;
        for(int i = 0; i < n; i++)
        {
            if(i == parentArray[i])
            components++;
        }

        return (extraEdges >= components - 1) ? components - 1 : -1;
    }
}