class Solution {
    int n, m; 
    int[][] directions ={{0,1},{0,-1},{1,0},{-1,0}};
    private int solve(int row,int col,int[][] grid)
    {
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0)
        return 0;

        int gold = grid[row][col];
        grid[row][col] = 0;   // marking the cell as visited.

        int maxGold = 0; 
        for(int[] dir : directions)
        maxGold = Math.max(maxGold,solve(row + dir[0], col + dir[1], grid));

        grid[row][col] = gold; // unmarking the cell.
        return maxGold+gold;
    }

    public int getMaximumGold(int[][] grid) 
    {
        n = grid.length;
        m = grid[0].length;
        int maximumGold = 0;
        for(int i=0;i<n;i++)
        {
            for(int j = 0; j < m; j++)
            if(grid[i][j] > 0)
            maximumGold = Math.max(maximumGold, solve(i,j,grid));
        }
        return maximumGold;
    }
}