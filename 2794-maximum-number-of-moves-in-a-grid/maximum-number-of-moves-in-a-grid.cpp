class Solution {
public:
    int maxMoves(vector<vector<int>>& grid) 
    {
        int N = grid.size();
        int M = grid[0].size();
        vector<vector<int>> dp(N, vector<int>(M, 0));

        int maxMoves = 0;
        for(int j = 1; j < M; j++)
        {
            for(int i = 0; i < N; i++) 
            {
                int p1 = 0, p2 = 0, p3 = 0;
                if(i > 0 && grid[i - 1][j - 1] < grid[i][j])
                p1 = 1 + dp[i - 1][j - 1];

                if(i < N - 1 && grid[i + 1][j - 1] < grid[i][j])
                p2 = 1 + dp[i + 1][j - 1];
                
                if(grid[i][j - 1] < grid[i][j])
                p3 = 1 + dp[i][j - 1];

                dp[i][j] = max({p1, p2, p3});

                if(dp[i][j] == 0)
                dp[i][j] = -1;
                
                else
                maxMoves = max(maxMoves, dp[i][j]);
            }
        }

        return maxMoves;
    }
};