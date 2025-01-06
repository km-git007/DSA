class Solution {

    int[][] dp;
    int m,n;
    private int solve(int row, int col)
    {
        if(row >= n || col >=m)
        return 0;

        if(row == n - 1 && col == m - 1)
        return 1;

        if(dp[row][col] != -1)
        return dp[row][col];

        return dp[row][col] = solve(row + 1, col) + solve(row, col + 1);
    }

    public int uniquePaths(int n, int m) 
    {
        this.n = n;
        this.m = m;
        dp = new int[n][m];
        
        for(int i = 0; i < n; i++)
        Arrays.fill(dp[i], -1);

        return solve(0, 0);
    }
}