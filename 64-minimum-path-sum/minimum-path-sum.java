class Solution {

    private int[][] dp;
    private int n;
    private int m;

    public int solve(int row,int col,int[][] grid)
    {
        if(row==n || col==m)
        return Integer.MAX_VALUE;

        if(row==n-1 && col==m-1)
        return grid[row][col];

        if(dp[row][col]!=-1)
        return dp[row][col];

        return dp[row][col]=grid[row][col]+Math.min(solve(row+1,col,grid),solve(row,col+1,grid));
    }

    public int minPathSum(int[][] grid) 
    {
        dp = new int[201][201];
        for (int[] row : dp)
        Arrays.fill(row,-1);

        m=grid[0].length;
        n=grid.length;

       return solve(0,0,grid);
    }
}