class Solution {
    private int n,m;
    private int vis[][];
    private int dfs(int row,int col,int[][] grid)
    {
        if(row>=n || row<0 || col>=m || col<0 || grid[row][col]==0)
        return 1;

        if(vis[row][col]==1)
        return 0;

        vis[row][col]=1;
        
        int down=dfs(row+1,col,grid);
        int up=dfs(row-1,col,grid);
        int right=dfs(row,col+1,grid);
        int left=dfs(row,col-1,grid);

        return down+up+right+left;
    }

    public int islandPerimeter(int[][] grid) 
    {
        n=grid.length;
        m=grid[0].length;
        vis=new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                return dfs(i,j,grid);
            }
            
        }
        return -1;
    }
}