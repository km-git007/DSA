class Solution {
    private int n;
    private Integer[][] dp;
    private int solve(int row, int col, int[][] grid)
    {
        if(row == n - 1)
        return grid[row][col]; 

        if(dp[row][col] != null)
        return dp[row][col];    

        int minSum = Integer.MAX_VALUE/2;
        for(int j = 0; j < n; j++)
        {
            if(j == col)
            continue;

            minSum = Math.min(minSum, solve(row + 1, j, grid));
        }

        return dp[row][col] = grid[row][col] + minSum;
    }

    public int minFallingPathSum(int[][] grid) 
    {
        n = grid.length;
        dp = new Integer[n][n];

        int res = Integer.MAX_VALUE;
        for(int col = 0; col < n; col++)
        res = Math.min(res, solve(0, col, grid));

        return res;
    }
}