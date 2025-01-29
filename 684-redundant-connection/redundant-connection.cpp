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
    

    vector<int> findRedundantConnection(vector<vector<int>>& edges) 
    {
        int N = edges.size();
        DSU* dsu = new DSU(N);

        for(auto edge : edges)
        {
            int x = edge[0] - 1;
            int y = edge[1] - 1;

            if(dsu->find(x) == dsu->find(y))
            return edge;

            dsu->unionSet(x, y);
        }
        return {};
    }
};