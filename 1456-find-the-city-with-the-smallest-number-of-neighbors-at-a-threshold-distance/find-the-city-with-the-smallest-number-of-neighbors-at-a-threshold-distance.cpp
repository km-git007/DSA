class Solution {
public:
    vector<vector<int>> buildMatrix(int n, int INF, vector<vector<int>>& edges)
    {
        vector<vector<int>> mat(n, vector<int>(n, INF));
        for(auto edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            mat[u][v] = wt;
            mat[v][u] = wt;
        }
        
        // correctly fill the diagonal elements
        for (int i = 0; i < n; i++) 
        mat[i][i] = 0;

        return mat;
    }

    void floydWarshall(int n, vector<vector<int>> &mat)
    {
        // Floyd-Warshall Algorithm
        for (int v = 0; v < n; v++) 
        {
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++) 
                mat[i][j] = min(mat[i][j], mat[i][v] + mat[v][j]);
            }
        }
    }

    int findTheCity(int n, vector<vector<int>>& edges, int target) 
    {
        //distanceThreshold
        int INF = INT_MAX / 2; // Represent "infinity" to prevent overflow

        auto mat = buildMatrix(n, INF, edges);
        floydWarshall(n, mat);

        int node = -1;
        int minCount = n;
        for (int i = 0; i < n; i++) 
        {
            int count = 0;
            for (int j = 0; j < n; j++) 
            {
                if(mat[i][j] <= target)
                count++;
            }
            if(count <= minCount)
            {
                minCount = count;
                node = i;
            }
        }
        return node;
    }
};