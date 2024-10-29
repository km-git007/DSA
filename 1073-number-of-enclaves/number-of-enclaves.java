class Solution {

    private int n,m;
    private int directions[][]=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    private void dfs(int row,int col,int[][] grid)
    {
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0)
        return;

        // marking the cell as visited.
        grid[row][col] = 0;

        for( int[] dir : directions)
        {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(newRow, newCol, grid);
        }
    }

    public int numEnclaves(int[][] grid) 
    {
        n=grid.length;
        m=grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1 && (i == 0 || j == 0 || i == n - 1 || j == m-1))
                dfs(i,j,grid);
            }  
        }

        int enclaves=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1)
                enclaves++;
            }  
        }
        return enclaves;
    }
}