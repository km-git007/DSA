class Solution {

    private int n,m;
    private int vis[][];
    private int directions[][]=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    private void dfs(int row,int col,char[][] grid)
    {
        if(row>=n || row<0 || col>=m || col<0 || vis[row][col]==1 || grid[row][col]=='0')
        return;

        vis[row][col]=1;
        
        for(int[] dir : directions)
        {
            int newRow=row+dir[0];
            int newCol=col+dir[1];
            dfs(newRow,newCol,grid);
        }
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