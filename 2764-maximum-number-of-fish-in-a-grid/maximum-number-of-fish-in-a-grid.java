class Solution {

    private int n,m;
    private int vis[][];
    private int directions[][]=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    private int dfs(int row, int col, int[][] grid)
    {
        if(row < 0 || row >= n || col < 0 || col >=m || grid[row][col]==0 || vis[row][col]==1)
        return 0;

        vis[row][col]=1;

        int fish = grid[row][col];
        for( int[] dir : directions)
        {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            fish +=dfs(newRow, newCol, grid);
        }
        return fish;
    }

    public int findMaxFish(int[][] grid) 
    {
        n=grid.length;
        m=grid[0].length;
        vis=new int[n][m];

        int maxFish=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]>0 && vis[i][j]==0)
                maxFish=Math.max(maxFish,dfs(i,j,grid));
            }
        }
        return maxFish;
    }
}