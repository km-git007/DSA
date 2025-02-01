class Solution {

    public int minFallingPathSum(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        // initialize the first column
        for(int j = 0; j < m; j++)
        dp[0][j] = grid[0][j];

        int INF = Integer.MAX_VALUE/2;
        for(int i = 1; i < m; i++)
        {
            for(int j = 0; j < m; j++)
            {
                int left = j - 1 >= 0 ? dp[i - 1][j - 1] : INF;
                int right = j + 1 < m ? dp[i - 1][j + 1] : INF;
                int up = dp[i - 1][j];

                dp[i][j] = grid[i][j] + Math.min(up, Math.min(left, right));
            }
        }

        // find the minimum from the last row
        int res = dp[n - 1][0];
        for(int j = 1; j < m; j++)
        res = Math.min(res, dp[n - 1][j]);

        return res;
    }
}