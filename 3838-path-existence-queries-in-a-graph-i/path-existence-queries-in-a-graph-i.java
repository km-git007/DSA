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

    public int getParent(int x) {
        return parent[x];
    }

    public void  union(int x, int y)
    {
        int parentX = find(x);
        int parentY = find(y);
        if(parentX == parentY) return;

        if(rank[parentX] == rank[parentY]) {
            parent[parentX] = parentY;
            rank[parentY]++;
        }
        else if(rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        }
        else {
            parent[parentY] = parentX;
        }
    }
}

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) 
    {
        DSU dsu = new DSU(n);
        for(int i = 0; i + 1 < n; i++)
        {
            if(Math.abs(nums[i] - nums[i + 1]) <= maxDiff)
            dsu.union(i, i + 1);
        }

        int index = 0;
        boolean[] res = new boolean[queries.length];
        for(int[] query : queries)
        {
            int x = query[0];
            int y = query[1];
            res[index++] = dsu.find(x) == dsu.find(y);
        }
        return res;
    }
}