class DSU {

    int[] parent, rank;
    public DSU(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void  union(int x, int y)
    {
        int parentX = find(x);
        int parentY = find(y);

        if(parentX == parentY){
            return;
        }

        if(rank[parentX] == rank[parentY]){
            parent[parentX] = parentY;
            rank[parentY]++;
        }else if(rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        }
        else {
            parent[parentY] = parentX;
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) 
    {
        int n = edges.length;
        // graph is 1 based
        DSU dsu = new DSU(n + 1);

        for(int[] edge : edges)
        {
            int x = edge[0];
            int y = edge[1];

            if(dsu.find(x) == dsu.find(y))
            return edge;

            dsu.union(x, y);
        }

        // No redundant edge found
        return new int[0]; 
    }
}