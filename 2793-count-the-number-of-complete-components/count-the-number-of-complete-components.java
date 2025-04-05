class DSU {

    int[] parent, size;

    public DSU(int n)
    {
        this.parent = new int[n];
        this.size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public int getSize(int x) {
        return size[find(x)];
    }

    public void  union(int x, int y)
    {
        int parentX = find(x);
        int parentY = find(y);
        if(parentX == parentY) return;

        if(size[parentX] <= size[parentY]) {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }
        else {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        }
    }
}

class Solution {
    private boolean isCompleteComponent(DSU dsu, int node, Map<Integer, Integer> map)
    {
        // total nodes in the subGraph
        int totalNodes = dsu.getSize(node);
        //total edges expected in a complete component
        int expectedEdges = (totalNodes * (totalNodes - 1)) / 2;

        // for component having size '1' we use getOrDefault.
        return map.getOrDefault(node, 0) == expectedEdges;
    }

    public int countCompleteComponents(int n, int[][] edges) 
    {
        DSU dsu = new DSU(n);

        for(int[] edge : edges)
        {
            int x = edge[0];
            int y = edge[1];

            dsu.union(x, y);
        }

        // map to store total number of edges in a component
        Map<Integer, Integer> map = new HashMap<>();
        // Count edges in each component
        for (int[] edge : edges) 
        {
            int root = dsu.find(edge[0]);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }

        // Check if each component is complete
        int completeCount = 0;
        for (int vertex = 0; vertex < n; vertex++) 
        {
            // If vertex is root
            if(dsu.find(vertex) == vertex && isCompleteComponent(dsu, vertex, map))
            completeCount++;
        }
        return completeCount;
    }
}