class Solution {

    private int n,m;
    private int vis[][];
    private void dfs(int row,int col,char[][] grid)
    {
        if(row>=n || row<0 || col>=m || col<0 || vis[row][col]==1 || grid[row][col]=='0')
        return;

        vis[row][col]=1;
        
        dfs(row+1,col,grid);
        dfs(row-1,col,grid);
        dfs(row,col+1,grid);
        dfs(row,col-1,grid);
    }
    public int numIslands(char[][] grid) 
    {
        n=grid.length;
        m=grid[0].length;
        vis=new int[n][m];

        int islands=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && vis[i][j]==0)
                {
                    dfs(i,j,grid);
                    islands++;
                }
            }
            
        }
        return islands;
    }
}