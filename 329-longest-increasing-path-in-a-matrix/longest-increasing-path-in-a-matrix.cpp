class Solution {
public:
    int n, m;
    vector<vector<int>> dp;
    vector<pair<int, int>> directions = {{-1, 0}, { 1, 0 }, {0, -1}, {0, 1}};
    bool isValidCell(int row, int col)
    {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    int dfs(int row, int col, vector<vector<int>>& matrix)
    {
        if(!isValidCell(row, col))
        return 0;

        if(dp[row][col] != -1)
        return dp[row][col];

        // path at least includes current cell
        int maxLen = 1; 
        for (auto [dx, dy] : directions) 
        {
            int nr = row + dx;
            int nc = col + dy;
            if(isValidCell(nr, nc) && matrix[nr][nc] > matrix[row][col])
            maxLen = max(maxLen, 1 + dfs(nr, nc, matrix));
        }

        return dp[row][col] = maxLen;
    }

    int longestIncreasingPath(vector<vector<int>>& matrix) 
    {
        n = matrix.size();
        m = matrix[0].size();
        dp.resize(n, vector<int>(m, -1));

        int maxLength = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            maxLength = max(maxLength, dfs(i, j, matrix));
        }
        return maxLength;
    }
};