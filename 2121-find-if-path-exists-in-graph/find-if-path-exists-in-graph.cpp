class Solution {
public:

    class DSU {
    public:

        vector<int> parent, rank;
        DSU(int n)
        {
            for(int i = 0; i < n; i++)
            {
                parent.push_back(i);
                rank.push_back(0);
            }
        }

        int find(int x) 
        {
            if(x == parent[x])
            return x;
            
            // Path compression
            return parent[x] = find(parent[x]);
        }

        void unionSet(int x, int y) 
        {
            int parentX = find(x);
            int parentY = find(y);
            
            if(parentX == parentY)
            return;

            // Union by rank
            // rank same - anyone can be made parent
            if(rank[parentX] == rank[parentY]) 
            {
                parent[parentX] = parentY;
                rank[parentY]++;
            }

            // rank of parent of 'x' is higher
            else if(rank[parentX] > rank[parentY])
            parent[parentY] = parentX;

            // rank of parent of 'y' is higher
            else
            parent[parentX] = parentY;

        }
    };

    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) 
    {
        DSU* dsu = new DSU(n);
        for(auto edge : edges)
        {
            int x = edge[0];
            int y = edge[1];

            dsu->unionSet(x, y);
        }

        return dsu->find(source) == dsu->find(destination);
    }
};