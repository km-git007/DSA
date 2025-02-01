class Solution {
    private int n, m;
    private Integer[][] dp;
    private int solve(int row, int col, int[][] grid)
    {
        // prevent overflow
        if(col < 0 || col >= m)
        return Integer.MAX_VALUE/2;

        if(row == n - 1)
        return grid[row][col]; 

        if(dp[row][col] != null)
        return dp[row][col];    

        int left = grid[row][col] + solve(row + 1, col - 1, grid);
        int right = grid[row][col] + solve(row + 1, col + 1, grid);
        int down = grid[row][col] + solve(row + 1, col, grid);

        return dp[row][col] = Math.min(down, Math.min(left, right));
    }

    public int minFallingPathSum(int[][] grid) 
    {
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m];

        int res = Integer.MAX_VALUE;
        for(int col = 0; col < m; col++)
        res = Math.min(res, solve(0, col, grid));

        return res;
    }
}