class Solution {

    private int n, m;
    private int[][] dp;
    private int solve(int row, int col, int prev, int[][] grid)
    {
        if(row<0 || row >= n || col < 0 || col >= m || grid[row][col] <= prev)
        return 0;

        if(dp[row][col] != -1)
        return dp[row][col];

        int moves;

        int path1 = 1 + solve(row - 1, col + 1, grid[row][col], grid);
        int path2 = 1 + solve(row, col + 1, grid[row][col], grid);
        int path3 = 1 + solve(row + 1, col + 1, grid[row][col], grid);

        moves = Math.max(path1, Math.max(path2, path3));
        return dp[row][col] = moves;
    }

    public int maxMoves(int[][] grid) 
    {
        n =grid.length;
        m =grid[0].length;

        dp =  new int [n][m];
        for(int i = 0; i < n; i++)
        Arrays.fill(dp[i],-1);

        int moves = 0;
        for(int i = 0; i < n; i++)
        moves = Math.max(moves, solve(i,0,0,grid));

        return moves - 1;
    }
}