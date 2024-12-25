class Solution {
public:
    int n, m;
    vector<vector<int>> dp;
    int solve(int row, int col, int prev, vector<vector<int>>& grid)
    {
        if(row < 0 || row >= n || col >= m)
        return 0;

        if(dp[row][col] != -1)
        return dp[row][col];

        int curr = grid[row][col];
        if (curr <= prev)
        return 0; // Invalid move

        // Recursive exploration
        int right = solve(row, col + 1, curr, grid);
        int upRight = solve(row - 1, col + 1, curr, grid);
        int downRight = solve(row + 1, col + 1, curr, grid);

        // Return maximum moves from the current position
        return dp[row][col] = 1 + max({right, upRight, downRight});
    }

    int maxMoves(vector<vector<int>>& grid) 
    {
        n = grid.size();
        m = grid[0].size();
        
        // Initialize dp array with -1
        dp = vector<vector<int>>(n, vector<int>(m, -1));

        int maxMoves = 0;
        for(int i = 0; i < n; i++)
        maxMoves = max(maxMoves, solve(i, 0, -1, grid) - 1);
        
        return maxMoves;
    }
};