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

        public int[] getParent()
        {
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

    private boolean isSimilar(String s, String t)
    {
        int diff = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != t.charAt(i))
            diff++;

            if(diff > 2)
            return false;
        }

        return diff == 0 || diff == 2;
    }

    private List<Integer> [] buildAdj(int n, String[] strs)
    {
        List<Integer>[] adj = new ArrayList[n];

        // Initialize each list
        for (int i = 0; i < n; i++)
        adj[i] = new ArrayList<>(); 

        

        return adj;
    }

    public int numSimilarGroups(String[] strs) 
    {
        int n = strs.length;
        DSU dsu = new DSU(n);

        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(isSimilar(strs[i], strs[j]))
                {
                    dsu.unionSet(i, j);
                }
            }
        }

        int[] par = dsu.getParent();

        int count = 0;
        for(int i = 0; i < n; i++)
        {
            if(i == par[i])
            count++;
        }

        return count;
    }
}