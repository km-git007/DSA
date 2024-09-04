class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) 
    {
        int n=grid.size();
        int dp[200][200];

        for(int j=0;j<n;j++)      // populating the first column.
        dp[0][j]=grid[0][j];

        // Populate the dp array for all subsequent rows
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int minValue = INT_MAX;
            // Check all possible columns in the previous row except the same column
            for (int k = 0; k < n; k++) {
                if (k != j) {
                    minValue = min(minValue, dp[i-1][k]);
                }
            }
            dp[i][j] = grid[i][j] + minValue;
        }
    }

    // Find the minimum value in the last row
    int mini = INT_MAX;
    for (int j = 0; j < n; j++) {
        mini = min(mini, dp[n-1][j]);
    }

    return mini;
    }
};