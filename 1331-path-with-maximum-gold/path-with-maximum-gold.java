class Solution {
    int n,m; 
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    private int solve(int row,int col,int[][] grid)
    {
        if(row<0 || row>=n || col<0 || col>=m || grid[row][col]==0)
        return 0;

        int gold=grid[row][col];
        grid[row][col]=0;   // marking the cell as visited.

        int maxGold=0; 
        for(int i=0;i<4;i++)
        maxGold = Math.max(maxGold,solve(row + dir[i][0], col + dir[i][1], grid));

        grid[row][col]=gold; // unmarking the cell.
        return maxGold+gold;
    }

    public int getMaximumGold(int[][] grid) 
    {
        n=grid.length;
        m=grid[0].length;
        int maximumGold=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            if(grid[i][j]>0)
            maximumGold=Math.max(maximumGold,solve(i,j,grid));
        }
        return maximumGold;
    }
}